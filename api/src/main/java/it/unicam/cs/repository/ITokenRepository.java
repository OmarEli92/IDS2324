package it.unicam.cs.repository;

import it.unicam.cs.security.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface ITokenRepository extends JpaRepository<Token, Integer> {
    @Query("""
     select t from Token t inner join Utente u 
    on t.utente.id = u.id 
    where t.utente.id = :idUtente 
    and t.isLoggedOut = false
    """
    )
    List<Token> findAllTokenByUtente(Integer idUtente);

    Optional<Token> findByToken(String token);
}
