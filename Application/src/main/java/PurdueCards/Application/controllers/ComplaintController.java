package PurdueCards.Application.controllers;

import PurdueCards.Application.model.Complaints;
import PurdueCards.Application.model.Customer;
import PurdueCards.Application.model.Sales;
import PurdueCards.Application.model.complaintID;
import PurdueCards.Application.repository.ComplaintsRepository;
import PurdueCards.Application.repository.CustomerRepository;
import PurdueCards.Application.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/complaint")
public class ComplaintController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ComplaintsRepository complaintsRepository;
    @PostMapping(path = "/make")
    ResponseEntity<?> makeComplaint(@RequestBody ComplaintInsertRequest cr){
        Customer complainer;
        Sales sale;
        try{
            complainer = customerRepository.findByCustomerID(cr.getCustomer_id()).orElseThrow(Exception::new);
        }catch (Exception e){
            return new ResponseEntity<>("No customer was found with that ID\n", HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            sale = salesRepository.findById(cr.getSale_id()).orElseThrow(Exception::new);
        }catch (Exception e){
            return new ResponseEntity<>("No customer was found with that ID\n", HttpStatus.NOT_ACCEPTABLE);
        }
        if(cr.body.length() <= 0){
            return new ResponseEntity<>("Invalid complaint message\n", HttpStatus.NOT_ACCEPTABLE);
        }
        complaintID id = new complaintID(complainer,sale);
        Complaints complaint = new Complaints(id,cr.getBody());
        complaintsRepository.save(complaint);
        return new ResponseEntity<>("Complaint successfully made\n",HttpStatus.OK);
    }
}
