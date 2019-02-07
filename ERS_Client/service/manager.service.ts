import { Injectable } from '@angular/core';
import { Reimbursement } from '../models/reimbursement';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  private baseUrl: string = "http://localhost:8080/ers";
  private reim: Reimbursement;
  httpOptions = { headers: new HttpHeaders({'Content-Type': 'application/json'})};

  constructor(private http: HttpClient) { }

  getAllReimbursements(): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>(this.baseUrl + '/all');
  }

  getAuthorName(id: number): Observable<User> {
    return this.http.get<User>('http://localhost:8080/user/' + id);
  }
}
