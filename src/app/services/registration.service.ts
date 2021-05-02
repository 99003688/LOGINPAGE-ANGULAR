import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../class/login';
import { User } from '../class/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http : HttpClient) { }

  public loginUserFromRemote(user: User):Observable<any>
  {
    return this._http.post<any>("http://localhost:8080/login", user);
  }
  public registerUserFromRemote(user: User):Observable<any>
  {
    return this._http.post<any>("http://localhost:8080/crusers", user);
  }



}
