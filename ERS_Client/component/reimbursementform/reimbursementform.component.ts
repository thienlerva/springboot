import { Component, OnInit } from '@angular/core';
import { Reimbursement } from 'src/app/models/reimbursement';
import { ReimbursementService } from 'src/app/service/reimbursement.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-reimbursementform',
  templateUrl: './reimbursementform.component.html',
  styleUrls: ['./reimbursementform.component.css']
})
export class ReimbursementformComponent implements OnInit {

  types = ['Travel', 'Food', 'Lodging', 'Other'];
  typeString: string;
  
  reim = new Reimbursement();

  constructor(
    private reimService: ReimbursementService,
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit() {
  }

  onSubmit() {
    this.reim.id = 0;
    this.reim.authorId = this.loginService.getUserID();
    this.reim.status = 'Pending';
    this.reim.typeId = this.convertType(this.typeString);

    this.reimService.createReimbursement(this.reim).subscribe((data)=>{
      this.reim = data;
      console.log(this.reim);
      alert("Reimbursement has been created");
      this.router.navigate(['/employee']);
    },
    err => {
    
      alert("Something wrong");
    });
  }

  convertType(input: string): number {
    switch(input) {
      case 'Travel': return 1;
      case 'Food': return 2;
      case 'Lodging': return 3;
      case 'Other': return 4;
      default: return 1;
    }
  }

}
