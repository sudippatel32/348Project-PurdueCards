import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CardAll } from './card-all';
import { CardAllService } from './card-all.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient }  from '@angular/common/http';

@Component({
  selector: 'app-card-all',
  templateUrl: './card-all.component.html',
  styleUrls: ['./card-all.component.css']
})
export class CardAllComponent implements OnInit{
    public cards: CardAll[];

   constructor(private router: Router, private route: ActivatedRoute,
       private cardAllService: CardAllService) { }


   ngOnInit() {
     this.getCards();
   }


   public getCards(): void {
     this.cardAllService.getCards().subscribe(
       (response: CardAll[]) => {
         this.cards = response;
       },
       (error: HttpErrorResponse) => {
         alert(error.message);
       }
     );
   }
}
