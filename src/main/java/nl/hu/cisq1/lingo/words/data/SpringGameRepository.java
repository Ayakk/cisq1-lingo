package nl.hu.cisq1.lingo.words.data;

import nl.hu.cisq1.lingo.words.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringGameRepository extends JpaRepository<Game, Long> {
}
