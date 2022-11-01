package PurdueCards.Application.repository;

import PurdueCards.Application.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Integer> {

    List<Card> findByName(String name);
    Optional<Card> findByNameAndSetAndFoil(String name, String set, boolean foil);

}
