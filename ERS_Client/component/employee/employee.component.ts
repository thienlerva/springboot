import { Component, OnInit } from '@angular/core';
import { Reimbursement } from 'src/app/models/reimbursement';
import { ReimbursementService } from 'src/app/service/reimbursement.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  reimbursements: Reimbursement[];
  id: number;

  constructor(
    private reimService: ReimbursementService,
    private router: Router,
    private loginService: LoginService
    ) { }

  ngOnInit() {
    this.id = this.loginService.getUserID();
    this.getReimbursementByAuthorId(this.id);
  }

  getAllReimbursements() {
    this.reimService.getAllReimbursements().subscribe((data)=> {
      this.reimbursements = data;
      console.log(this.reimbursements);
    })
  }

  getReimbursementByAuthorId(id: number) {
    this.reimService.getReimbursementByAuthorId(id).subscribe((data)=> {
      this.reimbursements = data;
    })
  }

  newReim() {
    let reim = new Reimbursement();
    this.reimService.setter(reim);
    this.router.navigate(['/createReimbursement']);
  }
}
