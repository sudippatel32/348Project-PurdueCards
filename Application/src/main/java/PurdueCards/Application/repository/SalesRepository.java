package PurdueCards.Application.repository;

import PurdueCards.Application.model.Purchases;
import PurdueCards.Application.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
    List<Sales> findByBuyer_customerID(int buyer_id);
    List<Sales> findByBuyerName(String buyer_name);
    Optional <Sales> findById(int sale_id);
}
