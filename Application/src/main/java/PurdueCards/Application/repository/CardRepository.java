package PurdueCards.Application.repository;

import PurdueCards.Application.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {

}
