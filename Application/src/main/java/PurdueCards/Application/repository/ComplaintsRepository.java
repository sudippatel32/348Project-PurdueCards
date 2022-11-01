package PurdueCards.Application.repository;

import PurdueCards.Application.model.Complaints;
import PurdueCards.Application.model.complaintID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintsRepository extends JpaRepository<Complaints, complaintID> {
    List<Complaints> findByID_customer_customerID(int customer_id);

}
