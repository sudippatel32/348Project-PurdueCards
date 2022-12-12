import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComplaintComponent } from './complaint/complaint.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { SaleComponent } from './sale/sale.component';
import { ComplaintAllComponent } from './complaint-all/complaint-all.component';

const routes: Routes = [
  { path: 'complaint', component: ComplaintComponent },
  { path: 'purchases', component: PurchaseComponent },
  { path: 'sale', component: SaleComponent },
  { path: 'complaint-all', component: ComplaintAllComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
