import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { LoginService } from './service/login.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './component/header/header.component';
import { EmployeeComponent } from './component/employee/employee.component';
import { AuthGuard } from './auth.guard';
import { ReimbursementService } from './service/reimbursement.service';
import { FooterComponent } from './component/footer/footer.component';
import { ReimbursementformComponent } from './component/reimbursementform/reimbursementform.component';
import { ManagerComponent } from './component/manager/manager.component';
import { ManagerService } from './service/manager.service';
import { ManagerheaderComponent } from './component/managerheader/managerheader.component';
import { UpdatereimbursementComponent } from './component/updatereimbursement/updatereimbursement.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    EmployeeComponent,
    FooterComponent,
    ReimbursementformComponent,
    ManagerComponent,
    ManagerheaderComponent,
    UpdatereimbursementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    LoginService,
    AuthGuard,
    ReimbursementService, 
    ManagerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
