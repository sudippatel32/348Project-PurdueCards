package PurdueCards.Application.repository;

import PurdueCards.Application.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasesRepository extends JpaRepository<Purchases,Integer> {
    List<Purchases> findByPurchaser_customerID(int purchaser_id);
    List<Purchases> findByPurchaserName(String purchaser_name);
}
