import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-managerheader',
  templateUrl: './managerheader.component.html',
  styleUrls: ['./managerheader.component.css']
})
export class ManagerheaderComponent implements OnInit {

  fullName: string;

  constructor(
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.fullName = this.loginService.getFullName();
  }



  logout() {
    this.loginService.logout();
    this.router.navigateByUrl('/login');
  }

}
