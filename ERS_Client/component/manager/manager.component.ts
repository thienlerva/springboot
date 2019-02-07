import { Component, OnInit } from '@angular/core';
import { Reimbursement } from 'src/app/models/reimbursement';
import { ManagerService } from 'src/app/service/manager.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import { User } from 'src/app/models/user';
import { ReimbursementService } from 'src/app/service/reimbursement.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  reimbursements: Reimbursement[];
  user: User;

  constructor(private managerService: ManagerService,
      private router: Router,
      private loginService: LoginService,
      private reimService: ReimbursementService
    ) { }

  ngOnInit() {
    
    this.getAllReimbusements();
  }

  getAllReimbusements() {
    this.managerService.getAllReimbursements().subscribe((data)=> {
      this.reimbursements = data;
    })
  }

  getAuthorName(id: number) {
    this.managerService.getAuthorName(id).subscribe((data)=> {
      this.user = data;
      console.log(this.user);
    
    });
    
  }

  updateReimbursement(reimbursement: Reimbursement) {
    this.reimService.setter(reimbursement);
    this.router.navigate(['/update_reimbursement']);
  }

  convertType(id: number): string {
    switch(id) {
      case 1: return 'Travel';
      case 2: return 'Food';
      case 3: return 'Lodging';
      case 4: return 'Other';
      default: return 'N/A';
    }
  }

}
