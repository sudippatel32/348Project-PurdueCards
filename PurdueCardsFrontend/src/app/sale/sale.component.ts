import { Component } from '@angular/core';
import { Sale } from './sale';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})

export class SaleComponent {
  onSubmit(){
    console.log("He hit the button!");

  }
}
