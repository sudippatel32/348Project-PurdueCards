import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Card } from './card';
import { CardService } from './card.service';
import { Complaint } from './complaint';
import { ComplaintService } from './complaint.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'PurdueCardsFrontend';
  public cards: Card[];
  public complaints: Complaint[];

  constructor(private cardService: CardService){}

  constructor(private complaintService: ComplaintService){}

  ngOnInit() {
      this.getCards();
      this.getComplaints();
  }


  public getCards(): void {
    this.cardService.getCards().subscribe(
      (response: Card[]) => {
        this.cards = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getComplaints(): void {
      this.complaintService.getComplaints().subscribe(
        (response: Complaint[]) => {
          this.complaints = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

}
