package it.unicam.cs.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.service.Interfaces.IGeolocalizzazioneService;
import it.unicam.cs.util.info.Posizione;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class OSMService implements IGeolocalizzazioneService {
    private final String BASE_URL = "https://nominatim.openstreetmap.org/search?format=json&q=";
    @Override
    public Posizione ottieniPosizioneComune(String comune) {
        String risposta = ottieniRisultatoDaOSM(BASE_URL+comune);
        Posizione posizione = new Posizione();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(risposta.toString());
            if (rootNode.isArray() && rootNode.size() > 0) {
                JsonNode primoElemento = rootNode.get(0);
                posizione.setLatitudine(primoElemento.path("lat").asDouble());
                posizione.setLongitudine(primoElemento.path("lon").asDouble());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return posizione;
    }

    @Override
    public boolean verificaPuntoNelComune(Posizione posizionePunto, Posizione[] posizioneComune) {
        if(posizionePunto == null || posizioneComune[0] == null || posizioneComune[1] == null){
            throw new NullPointerException("Le posizioni devono contenere un valore valido e che non sia null");
        }
        /** Formato posizioneComune: {min lat, min long}, {max lat, max long}**/
        return (posizioneComune[0].getLatitudine() <= posizionePunto.getLatitudine()) &&
                (posizionePunto.getLatitudine()<= posizioneComune[1].getLatitudine())
                && (posizioneComune[0].getLongitudine() <= posizionePunto.getLongitudine())
                && (posizioneComune[1].getLongitudine() >= posizionePunto.getLongitudine());
    }

    @Override
    public List<Posizione> ottieniPerimetro(String comune) {
        double[] latAndLonRanges = new double[4];
        String risposta = ottieniRisultatoDaOSM(BASE_URL+comune);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(risposta.toString());
            if (rootNode.isArray() && rootNode.size() > 0) {
                JsonNode primoElemento = rootNode.get(0);
                JsonNode boundingbox = primoElemento.path("boundingbox");
                for(int i = 0; i < boundingbox.size(); i++){
                    latAndLonRanges[i] = boundingbox.path(i).asDouble();
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        List<Posizione> perimetro = new ArrayList<>();
        perimetro.add(new Posizione(latAndLonRanges[0],latAndLonRanges[2]));
        perimetro.add(new Posizione(latAndLonRanges[1], latAndLonRanges[3]));
        return perimetro;
    }

    private String ottieniRisultatoDaOSM(String Url) {
        String response = "";
        HttpURLConnection connessione = null;
        try {
            URL url = new URL(Url);
            connessione = (HttpURLConnection) url.openConnection();
            connessione.setRequestMethod("GET");
            connessione.setRequestProperty("Accept", "application/json");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connessione.getInputStream()))) {
                StringBuilder risposta = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    risposta.append(line);
                }
                response = risposta.toString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (connessione != null) {
                connessione.disconnect();
            }
        }
        return response;
    }
        /*
        String response = "";
        HttpURLConnection connessione = null;
        try {
            URL url = new URL(Url);
            connessione = (HttpURLConnection) url.openConnection();
            connessione.setRequestMethod("GET");
            connessione.setRequestProperty("Accept", "application/json");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connessione.getInputStream()))) {
                StringBuilder risposta = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    risposta.append(line);
                }
                response = risposta.toString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            connessione.disconnect();
        }
        return response;

         */

}
