package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Card;
import PurdueCards.Application.model.Customer;
import PurdueCards.Application.model.Purchases;
import PurdueCards.Application.model.Sales;
import PurdueCards.Application.repository.CardRepository;
import PurdueCards.Application.repository.CustomerRepository;
import PurdueCards.Application.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/sales")
public class SalesController {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SalesRepository salesRepository;

    @PostMapping(path = "/make")
    ResponseEntity<?> recordSale(@RequestBody SalesInsertRequest sr){
        Card card;
        Customer buyer;
        try{
            card = cardRepository.findById(sr.getCard_id()).orElseThrow(Exception::new);
        }
        catch (Exception e){
            return new ResponseEntity<>("Card not found in database, please add it first\n", HttpStatus.NOT_ACCEPTABLE);
        }
        try{
            buyer = customerRepository.findByCustomerID(sr.getBuyer_id()).orElseThrow(Exception::new);
        }
        catch (Exception e){
            return new ResponseEntity<>("Customer not found in database, please add them first\n", HttpStatus.NOT_ACCEPTABLE);
        }
        if(sr.getDate() == null){
            return new ResponseEntity<>("Invalid Date format\n", HttpStatus.NOT_ACCEPTABLE);
        }
        card.setQuantity(card.getQuantity() - sr.getQuantity());
        if(card.getQuantity() < 0)
        {
            return new ResponseEntity<>("Illegal amount of cards sold. We don't have that many in stock\n", HttpStatus.NOT_ACCEPTABLE);
        }
        cardRepository.save(card);
        buyer.setSellCount(buyer.getSellCount() + sr.getQuantity());
        customerRepository.save(buyer);
        Sales toSave = new Sales(buyer,card,sr.getProfit(),sr.getQuantity(),sr.getDate());
        salesRepository.save(toSave);
        return new ResponseEntity<>("Successfully recorded sale",HttpStatus.OK);
    }
    @GetMapping(path = "/findAll")
    ResponseEntity<?> findPurchases(@RequestBody int buyer_ID){
        List<Sales> toReturn = salesRepository.findByBuyer_customerID(buyer_ID);
        return new ResponseEntity<List<Sales>>(toReturn,HttpStatus.OK);
    }
}
