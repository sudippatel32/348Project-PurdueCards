import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardService } from './card.service';
import { ComplaintService } from './complaint.service';
import { ComplaintComponent } from './complaint/complaint.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { SaleComponent } from './sale/sale.component';
import { DatePipe } from '@angular/common';
import { ComplaintAllComponent } from './complaint-all/complaint-all.component';

@NgModule({
  declarations: [
    AppComponent,
    ComplaintComponent,
    PageNotFoundComponent,
    PurchaseComponent,
    SaleComponent,
    ComplaintAllComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [CardService, ComplaintService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
