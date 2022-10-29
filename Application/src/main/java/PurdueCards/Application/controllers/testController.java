package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Customer;
import PurdueCards.Application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/test")
public class testController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="/add")
    public void addTest(){
        Customer test = new Customer("test",0,0);
        customerRepository.save(test);
    }
    @GetMapping(path="/get")
    public String getCustomers(){
        List<Customer> toReturn = customerRepository.findAll();
        return "hello";
    }
}
