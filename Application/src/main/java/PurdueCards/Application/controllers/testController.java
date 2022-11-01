package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Card;
import PurdueCards.Application.model.Customer;
import PurdueCards.Application.repository.CardRepository;
import PurdueCards.Application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Card>> searchCard(@RequestBody String name){
        List<Card> toReturn = cardRepository.findByName(name);
        return new ResponseEntity<List<Card>>(toReturn,HttpStatus.OK);
    }

    @PostMapping(path="/addCard")
    public ResponseEntity<?> addCard(@RequestBody CardInsertRequest CR){
        try {
            Card card = cardRepository.findByNameAndSetAndFoil(CR.getName(), CR.getSet(), CR.isFoil()).orElseThrow(Exception::new);
            card.setQuantity(card.getQuantity()+ CR.getQuantity());
            cardRepository.save(card);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch (Exception e){
            Card card = new Card(CR.getName(), CR.getSet(), CR.getColor(),CR.getRarity(),CR.isFoil(), CR.getPrice(), CR.getQuantity());
            cardRepository.save(card);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
    }

}
