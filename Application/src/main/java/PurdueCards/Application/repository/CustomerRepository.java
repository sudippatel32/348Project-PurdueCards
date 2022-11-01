package PurdueCards.Application.repository;

import PurdueCards.Application.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAll();
    Optional<Customer> findByCustomerID(int customer_id);
}
