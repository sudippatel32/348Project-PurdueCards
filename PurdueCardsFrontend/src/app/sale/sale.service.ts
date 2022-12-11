import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class SaleService {
  private apiServerUrl = 'http://localhost:8080/sales';
  constructor() { }
}
