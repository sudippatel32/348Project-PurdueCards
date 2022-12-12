import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Complaint } from '../complaint';
import { ComplaintService } from '../complaint.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient }  from '@angular/common/http';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent {
  complaintForm = this.formBuilder.group({
      customerId: '',
      saleId: '',
      body: '',
  })
  public complaints: Complaint[];
  public customerId: number;
  public saleId: number;
  public body: string;
  //public complaint : Complaint = new Complaint();
  public qr: any;
  //public complaintForm: FormGroup


  constructor(private router: Router, private route: ActivatedRoute,
      private complaintService: ComplaintService,
      private http: HttpClient,
      private formBuilder: FormBuilder) { }




  onSubmit() {

    var data = this.complaintForm.value;
    var complaint = <Complaint>{};
    complaint.customerId = Number(data.customerId);
    complaint.saleId = Number(data.saleId);
    complaint.body = String(data.body);
    //console.log(complaint);
    this.saveComplaint(complaint);
    this.router.navigate(['/']);
  }

  saveComplaint(complaint: Complaint) {
    this.complaintService.addComplaint(complaint).subscribe();
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


