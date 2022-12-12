import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Purchase } from './purchase';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {
  private apiServerUrl = 'http://localhost:8080/purchase';
  private recordPurchaseUrl = 'http://localhost:8080/purchase/make';
  constructor(private http:HttpClient) { 

  }
  recordPurchase(purchase:Purchase): Observable<Purchase>{
    return this.http.post<Purchase>(this.recordPurchaseUrl,purchase).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse){
    console.log(error.status);
    return throwError(() => new Error(error.message));
  }
}
