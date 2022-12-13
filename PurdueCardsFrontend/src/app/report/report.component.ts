import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Report } from '../report';
import { ReportService } from '../complaint.report';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient }  from '@angular/common/http';

Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent {
  interface entry {
    transaction_id: number;
    customer_name: string;
    card_name: string;
    change: number;
    quantity: number;
    date: Date;
  }
  public sales: entry[];
  public purchases: entry[];
}
