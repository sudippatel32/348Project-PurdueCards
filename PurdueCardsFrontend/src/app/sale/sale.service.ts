import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Sale } from './sale';

@Injectable({
  providedIn: 'root'
})
export class SaleService {
  private apiServerUrl = 'http://localhost:8080/sales';
  private recordSaleUrl = 'http://localhost:8080/sales/make';
  constructor(private http:HttpClient) {

  }
  recordSale(sale: Sale): Observable<Sale>{
    return this.http.post<Sale>(this.recordSaleUrl,sale).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse){
    console.log(error.status);
    return throwError(() => new Error(error.message));
  }
}
