import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private currentUser = new User();
  public error = false;
  output: string = '';

  constructor(
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    
  }

  onSubmit() {
    this.error = false;
    this.loginService.validateUser(this.currentUser).subscribe((user) => {
      this.currentUser = user;

      this.error = false;
        this.loginService.persistLogin(this.currentUser);
        console.log(this.currentUser);
        if(this.currentUser.roles == 'Employee') {
          this.router.navigateByUrl('/employee');
        } else if (this.currentUser.roles == "FinanceManager") {
          this.router.navigate(['/manager']);
        }
    },
    err => {
    
      this.output = 'Invalid Credential';
      this.error = true;
      setTimeout( () => { this.error = false; }, 4000 );
    }
    );
  }

  logout() {
    this.loginService.logout();
  }

}
