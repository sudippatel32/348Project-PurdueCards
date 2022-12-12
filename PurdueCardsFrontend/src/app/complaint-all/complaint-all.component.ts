import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ComplaintAll } from './complaint-all';
import { ComplaintAllService } from './complaint-all.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient }  from '@angular/common/http';


@Component({
  selector: 'app-complaint-all',
  templateUrl: './complaint-all.component.html',
  styleUrls: ['./complaint-all.component.css']
})
export class ComplaintAllComponent implements OnInit{
    public complaints: ComplaintAll[];

    constructor(private router: Router, private route: ActivatedRoute,
        private complaintAllService: ComplaintAllService) { }


    ngOnInit() {
      this.getComplaints();
    }

    onSubmit() {
      this.getComplaints();
    }


    public getComplaints(): void {
      this.complaintAllService.getComplaints().subscribe(
        (response: ComplaintAll[]) => {
          this.complaints = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
}
