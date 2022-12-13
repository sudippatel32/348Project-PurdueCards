package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Customer;
import PurdueCards.Application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/add")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<?> addCustomer(@RequestBody String name){
        Customer customer = new Customer(name,0,0);
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
