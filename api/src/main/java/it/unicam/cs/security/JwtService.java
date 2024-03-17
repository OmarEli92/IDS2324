package it.unicam.cs.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import it.unicam.cs.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service @Slf4j
public class JwtService {
    private final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";//Encoders.BASE64.encode(Jwts.SIG.HS512.key().build().getEncoded());
    private final ITokenRepository tokenRepository;

    public JwtService(ITokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public String estraiUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public String generaToken(UserDetails userDetails){
        return generaToken(new HashMap<>(),userDetails);
    }


    public String generaToken(Map<String,Object> extractedClaims, UserDetails userDetails){
        return Jwts.builder()
                .claims()
                .add(extractedClaims)
                .and()
                .subject(userDetails.getUsername())
                .signWith(getSignInKey(),Jwts.SIG.HS256)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 *90))
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = estraiUsername(token);
        boolean isValid = tokenRepository.findByToken(token).map(t -> !t.isLoggedOut()).orElse(false);
        return(username == userDetails.getUsername() && !isTokenExpired(token) && isValid);
    }

    private boolean isTokenExpired(String token){
        Date expirationDate = extractClaim(token, Claims::getExpiration);
        return (expirationDate.before( new Date()));
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        try {
            return claimsResolver.apply(extractAllClaims(token));
        } catch (MalformedJwtException e) {
            log.error("JWT non corretto: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error(" JWT scaduto: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error(" JWT non supportato: " + e.getMessage());
        }
        return null;

    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());/*
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
        */
    }

}
