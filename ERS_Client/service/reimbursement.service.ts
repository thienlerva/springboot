import { Injectable } from '@angular/core';
import { Reimbursement } from '../models/reimbursement';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  private baseUrl: string = "http://localhost:8080/ers";
  private reim: Reimbursement
  httpOptions = { headers: new HttpHeaders({'Content-Type': 'application/json'})};

  constructor(private http: HttpClient) { }

  getAllReimbursements(): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>(this.baseUrl + '/all');
  }

  getReimbursement(id: number): Observable<Reimbursement> {
    return this.http.get<Reimbursement>(this.baseUrl + '/' + id);
  }

  getReimbursementByAuthorId(id: number): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>(this.baseUrl + '/find-by-author-id/' + id);
  }

  createReimbursement(reim: Reimbursement): Observable<Reimbursement> {
    return this.http.post<Reimbursement>(this.baseUrl + '/create', reim, this.httpOptions);
  }

  updateReimbursement(reim: Reimbursement): Observable<Reimbursement> {
    return this.http.put<Reimbursement>(this.baseUrl + '/update', reim, this.httpOptions);
  }

  setter(reimbursement: Reimbursement) {
    this.reim = reimbursement;
  }

  getter() {
    return this.reim;
  }
}
