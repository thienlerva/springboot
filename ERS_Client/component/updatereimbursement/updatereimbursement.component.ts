import { Component, OnInit } from '@angular/core';
import { Reimbursement } from 'src/app/models/reimbursement';
import { ReimbursementService } from 'src/app/service/reimbursement.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-updatereimbursement',
  templateUrl: './updatereimbursement.component.html',
  styleUrls: ['./updatereimbursement.component.css']
})
export class UpdatereimbursementComponent implements OnInit {

  reimbursement: Reimbursement;
  statuses = ['Approve', 'Deny'];

  constructor(
    private reimService: ReimbursementService,
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.reimbursement = this.reimService.getter();
  }

  onSubmit() {
    this.reimbursement.resolverId = this.loginService.getUserID();
    this.reimbursement.submittedDate = '2019-01-22T20:09:27.186+0000';
    this.reimService.updateReimbursement(this.reimbursement).subscribe((data)=> {
      this.reimbursement = data;
      this.router.navigate(['/manager']);
    },
    err => {
      alert("something wrong");
    });
    
  }

}
