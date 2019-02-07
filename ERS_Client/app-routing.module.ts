import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { HeaderComponent } from './component/header/header.component';
import { EmployeeComponent } from './component/employee/employee.component';
import { AuthGuard } from './auth.guard';
import { ReimbursementformComponent } from './component/reimbursementform/reimbursementform.component';
import { ManagerComponent } from './component/manager/manager.component';
import { UpdatereimbursementComponent } from './component/updatereimbursement/updatereimbursement.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'header', component: HeaderComponent },
  { path: 'login', component: LoginComponent },
  { path: 'employee', component: EmployeeComponent,
  canActivate: [AuthGuard]
 },
  { path: 'createReimbursement', component: ReimbursementformComponent},
  { path: 'manager', component: ManagerComponent },
  { path: 'update_reimbursement', component: UpdatereimbursementComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
