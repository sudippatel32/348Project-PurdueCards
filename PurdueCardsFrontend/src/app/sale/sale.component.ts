import { Component } from '@angular/core';
import { SaleService } from './sale.service';
import { FormBuilder } from '@angular/forms';
import { Sale } from './sale';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})

export class SaleComponent {

  saleForm = this.formBuilder.group({
    card_id: '',
    buyer_id: '',
    profit: '',
    quantity: ''
  })

  constructor(
    private saleService: SaleService,
    private formBuilder: FormBuilder,
    private datePipe:DatePipe
  ){}
  saveSale(sale: Sale){
    this.saleService.recordSale(sale).subscribe();    
  }
  onSubmit(){
    console.log("He hit the button!");
    var data = this.saleForm.value;
    var sale = <Sale>{};
    sale.buyer_id = Number(data.buyer_id);
    sale.card_id = Number(data.card_id);
    sale.profit = Number(data.profit);
    sale.quantity = Number(data.quantity);
    var date = this.datePipe.transform( new Date(), 'dd-MM-yyyy');
    console.log(date);
    if(date == null){
      date = "";
    }
    sale.date=date;
    console.log(sale);
    this.saveSale(sale);
    console.log("ran save sale");
    
  }
}
