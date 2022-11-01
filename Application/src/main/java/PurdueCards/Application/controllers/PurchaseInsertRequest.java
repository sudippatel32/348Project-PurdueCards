package PurdueCards.Application.controllers;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class PurchaseInsertRequest {
    int seller_id;
    int card_id;
    int cost;
    int quantity;
    Date date;

    public PurchaseInsertRequest(int seller_id, int card_id, int cost, int quantity, String date){
        this.seller_id = seller_id;
        this.card_id = card_id;
        this.cost = cost;
        this.quantity = quantity;
        try{
            this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        }
        catch (Exception e){
            this.date = null;
        }

    }
}
