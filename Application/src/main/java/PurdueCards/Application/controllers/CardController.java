package PurdueCards.Application.controllers;
import PurdueCards.Application.model.*;
import PurdueCards.Application.repository.CardRepository;
import PurdueCards.Application.repository.ComplaintsRepository;
import PurdueCards.Application.repository.CustomerRepository;
import PurdueCards.Application.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/card")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @PostMapping(path="/add")
    @Transactional(isolation = Isolation.READ_COMMITTED)
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

    @GetMapping(path = "/all")
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    ResponseEntity<?> getAllCards() {
        List<Card> toReturn = cardRepository.findAll();
        return new ResponseEntity<List<Card>>(toReturn,HttpStatus.OK);
    }

    @GetMapping(path="/search")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<?> searchCard(@RequestBody String name){
        List<Card> toReturn = cardRepository.findByName(name);
        return new ResponseEntity<List<Card>>(toReturn,HttpStatus.OK);
    }
}
