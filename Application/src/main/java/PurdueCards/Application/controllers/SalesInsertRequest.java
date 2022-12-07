package PurdueCards.Application.controllers;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class SalesInsertRequest {
    int buyer_id;
    int card_id;
    int profit;
    int quantity;
    Date date;

    public SalesInsertRequest(int buyer_id, int card_id, int profit,int quantity, String date){
        this.buyer_id = buyer_id;
        this.card_id = card_id;
        this.profit = profit;
        this.quantity = quantity;
        try{
            this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        }
        catch (Exception e){
            this.date = null;
        }
    }
}
