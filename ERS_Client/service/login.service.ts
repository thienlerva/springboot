import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl: string = "http://localhost:8080/user/";
  private currentUser: User;
  private LOGGEDIN = 'loggedIn';
  private USERNAME = 'username';
  private ID = 'id';
  private FULLNAME = 'fullname';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
    localStorage.setItem(this.LOGGEDIN, 'false');
   }

  validateUser(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl + 'login', user, this.httpOptions);
  }

  public persistLogin(user: User) {
    localStorage.setItem(this.ID, user.id.toString());
    localStorage.setItem(this.USERNAME, user.username);
    localStorage.setItem(this.FULLNAME, user.firstname + ' ' + user.lastname);
    localStorage.setItem(this.LOGGEDIN, 'true');
  }
 
  public getUserName(): string {
    return localStorage.getItem(this.USERNAME);
  }
 
  public getFullName(): string {
    return localStorage.getItem(this.FULLNAME);
  }
 
  public getUserID(): number {
    return Number(localStorage.getItem(this.ID));
  }

  public isLoggedIn(): boolean {
    let loggedIn = localStorage.getItem(this.LOGGEDIN);
 
    // just in case loggedIn isn't in local storage
    if (loggedIn == null) {
      localStorage.setItem(this.LOGGEDIN, 'false');
      loggedIn = localStorage.getItem(this.LOGGEDIN);
    }
 
    return (loggedIn === 'true');
    
  }

  public logout() {
    localStorage.removeItem(this.ID);
    localStorage.removeItem(this.USERNAME);
    //localStorage.removeItem(this.TOKEN);
    localStorage.removeItem(this.FULLNAME);
    localStorage.setItem(this.LOGGEDIN, 'false');
  }

}
