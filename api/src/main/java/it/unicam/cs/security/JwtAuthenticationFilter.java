package it.unicam.cs.security;

import it.unicam.cs.security.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component @RequiredArgsConstructor @Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String username;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken = authHeader.substring(7);
        username = jwtService.estraiUsername(jwtToken);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){ //non è connesso
            log.info("Utente {} presente nel db ma non connesso",username);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(jwtService.isTokenValid(jwtToken,userDetails)){//token valido
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                log.info("Il token è valido e l'utente è presente nel db");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //aggiunge i dettagli dalla request
                SecurityContextHolder.setContext(securityContext);
                SecurityContextHolder.getContext().setAuthentication(authToken); // aggiorna il contesto della sicurezza
            }
        }
        filterChain.doFilter(request, response);
    }
}
