# IDS2324
Progetto esame Ingegneria del software 2023/24
Autori @Omar El Idrissi @Nicolas Rossi

Come usare l'applicazione :
-aprite l'applicazione sul vostro IDE ed eseguitela
-aprite il vostro browser ed andate su localhost:8888/swagger-ui/index.html
-come prima cosa, andare sull'endpoint per la regsitrazione utente ed inserire tutto quello richiesto dal json (il primo utente, per default, avrà come ruolo il gestore piattaforma). L'applicazione fa utilizzo di jwt bearer, per cui per accedere a determinati endpoint è necessaria l'autenticazione (vedere in SecurityConfig i permessi per i vari endpoint).
-per vedere gli aggiornamenti man mano sul database, andate su localhost:8888/h2-console/ con le seguenti credenziali :
PASSWORD : turismo
USERNAME : turismo
