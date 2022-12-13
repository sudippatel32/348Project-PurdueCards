import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Card } from '../card';
import { CardService } from '../card.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient }  from '@angular/common/http';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  cardForm = this.formBuilder.group({
        foil: '',
        name: '',
        set: '',
        quantity: '',
        color: '',
        rarity: '',
        price: ''
    })

    constructor(private router: Router, private route: ActivatedRoute,
          private cardService: CardService,
          private http: HttpClient,
          private formBuilder: FormBuilder) { }

    onSubmit() {

      var data = this.cardForm.value;
      var card = <Card>{};
      var foilString = String(data.foil);
      card.foil = this.getBool(foilString);


      card.name = String(data.name);
      card.set = String(data.set);
      card.quantity = Number(data.quantity);
      card.color = String(data.color);
      card.rarity = String(data.rarity);
      card.price = Number(data.price);
      console.log(card);
      this.saveCard(card);
      this.router.navigate(['/']);
    }

    saveCard(card: Card) {
      this.cardService.addCard(card).subscribe();
    }


    getBool(foil: String) {
        if (foil === "yes" || foil === "Yes") {
          return true;
        } else {
          return false;
        }

    }
}

/*
    id: number;
    foil: boolean;
    name: string;
    set: string;
    quantity: number;
    color: string;
    rarity: string;
    price: number;

*/
