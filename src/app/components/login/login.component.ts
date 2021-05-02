import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/class/login';
import { User } from 'src/app/class/user';
import { RegistrationService } from 'src/app/services/registration.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

     user=new User();
     msg='';
     login=new Login();

  constructor(private _service: RegistrationService, private _router: Router) { }

  ngOnInit() {
  }

  loginForUser(){
this._service.loginUserFromRemote(this.user).subscribe(
  data=>
  {
    console.log("Data received");
    this._router.navigate(['/dashboard']);

  },
  error=>
  {
    console.log("Exception Occured");
    this.msg="Invalid credentials";
  }

)
  }




      
  }



// .loginuserFromRemote1(this.user)
// .subscribe(data=>
//   {console.log("Data received");
// }