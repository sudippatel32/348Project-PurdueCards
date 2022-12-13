package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Card;
import PurdueCards.Application.model.Customer;
import PurdueCards.Application.model.Purchases;
import PurdueCards.Application.repository.CardRepository;
import PurdueCards.Application.repository.CustomerRepository;
import PurdueCards.Application.repository.PurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/purchase")
public class PurchaseController {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    PurchasesRepository purchasesRepository;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping(path = "/make")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    ResponseEntity<?> recordPurchase(@RequestBody PurchaseInsertRequest PR){
        Card card;
        Customer seller;
        try{
            card = cardRepository.findById(PR.getCard_id()).orElseThrow(Exception::new);
        }
        catch (Exception e){
            return new ResponseEntity<>("Card not found in database, please add it first\n", HttpStatus.NOT_ACCEPTABLE);
        }
        try{
            seller = customerRepository.findByCustomerID(PR.getSeller_id()).orElseThrow(Exception::new);
        }
        catch (Exception e){
            return new ResponseEntity<>("Customer not found in database, please add them first\n", HttpStatus.NOT_ACCEPTABLE);
        }
        if(PR.getDate() == null){
            return new ResponseEntity<>("Invalid Date format\n", HttpStatus.NOT_ACCEPTABLE);
        }
        card.setQuantity(card.getQuantity() + PR.getQuantity());
        cardRepository.save(card);
        seller.setPurchaseCount(seller.getPurchaseCount()+1);
        customerRepository.save(seller);

        Purchases purchases = new Purchases(seller,card,PR.getCost(),PR.getQuantity(),PR.getDate());
        purchasesRepository.save(purchases);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/findAll")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    ResponseEntity<List<Purchases>> findPurchases(@RequestBody int seller_ID){
        List<Purchases> toReturn = purchasesRepository.findByPurchaser_customerID(seller_ID);
        return new ResponseEntity<List<Purchases>>(toReturn,HttpStatus.OK);
    }
}
