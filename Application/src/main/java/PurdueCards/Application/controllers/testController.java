package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Card;
import PurdueCards.Application.model.Customer;
import PurdueCards.Application.repository.CardRepository;
import PurdueCards.Application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CardRepository cardRepository;

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

    @GetMapping(path="/getAllCards")
    public List<Card> getAllCards(){
        //Card testCard = new Card("testCard", "third", "green", 'R', true, 55);
        //cardRepository.save(testCard);

        return cardRepository.findAll();
    }

    @GetMapping(path="/searchCard")
    public List<Card> searchCard(){
        
        return cardRepository.findByName("random");
    }

    @GetMapping(path="/addCard")
    public void addCard(String name, String set, String color, Character rarity, Boolean foil, int price){
        Card testCard = new Card("testCard", "third", "green", 'R', true, 55);
        cardRepository.save(testCard);
    }

}
