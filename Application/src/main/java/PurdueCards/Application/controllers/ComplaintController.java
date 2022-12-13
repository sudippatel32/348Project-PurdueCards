package PurdueCards.Application.controllers;

import PurdueCards.Application.model.*;
import PurdueCards.Application.repository.ComplaintsRepository;
import PurdueCards.Application.repository.CustomerRepository;
import PurdueCards.Application.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/complaint")
public class ComplaintController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ComplaintsRepository complaintsRepository;
    @PostMapping(path = "/add")
    ResponseEntity<?> makeComplaint(@RequestBody ComplaintInsertRequest cr){
        Customer complainer;
        Sales sale;

        try{
            complainer = customerRepository.findByCustomerID(cr.getCustomerId()).orElseThrow(Exception::new);
        }catch (Exception e){
            return new ResponseEntity<>("No customer was found with that ID\n" + cr.getCustomerId() + " middle" + cr.customerId + " ending", HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            sale = salesRepository.findById(cr.getSaleId()).orElseThrow(Exception::new);
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

    @GetMapping(path = "/all")
    ResponseEntity<?> getAllComplaints() {
        List<Complaints> complaints = complaintsRepository.findAll();
        List<ComplaintInsertRequest> toReturn = new ArrayList<>();
        for(int i = 0; i < complaints.size(); i++){
            Complaints toRead = complaints.get(i);
            ComplaintInsertRequest toInsert = new ComplaintInsertRequest(toRead.getID().getCustomer().getCustomerID(),
                    toRead.getID().getSale().getId(),toRead.getBody());
            toReturn.add(toInsert);
        }
        return new ResponseEntity<List<ComplaintInsertRequest>>(toReturn,HttpStatus.OK);
    }
}
