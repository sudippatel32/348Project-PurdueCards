import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { PurchaseService } from './purchase.service';
import { Purchase } from './purchase';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent {
  purchaseForm = this.formBuilder.group({
    card_id: '',
    seller_id: '',
    cost: '',
    quantity: ''
  })
  constructor(
    private purchaseService: PurchaseService,
    private formBuilder: FormBuilder,
    private datePipe: DatePipe
  ){}

  savePurchase(purchase: Purchase){
    this.purchaseService.recordPurchase(purchase).subscribe();
  }
  
  onSubmit(){
    var data = this.purchaseForm.value;
    var purchase = <Purchase>{};
    purchase.seller_id = Number(data.seller_id);
    purchase.card_id = Number(data.card_id);
    purchase.cost = Number(data.cost);
    purchase.quantity = Number(data.quantity);
    var date = this.datePipe.transform( new Date(), 'dd-MM-yyyy');
    if(date == null){
      date = "";
    }
    purchase.date = date;
    this.savePurchase(purchase);
  }
}
