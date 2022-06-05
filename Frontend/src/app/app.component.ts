import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from "@angular/router";

import * as $ from 'jquery';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularbootstrap';


  constructor(private authService: AuthService, private router :Router){}
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showUserBoard = false;
  userName: string;
  userRoles: string;

  user: string = '';
 
  ngOnInit() {
    //
      /*  this.router.events.subscribe(event => {
          if (event.constructor.name === "NavigationEnd") {
           this.isLoggedIn   = this.authService.LoggedIn;
          }
        })
     */
            $("#menu-toggle").click(function(e) {
          e.preventDefault();
          $("#wrapper").toggleClass("toggled");
          });
        
        /*   this.user = sessionStorage.getItem("roles");
          this.userName = sessionStorage.getItem("username");
     
         this.showAdminBoard = this.user.includes('ROLE_ADMIN');
          this.showUserBoard = this.user.includes('ROLE_USER'); */
    
                //Toggle Click Function
        }
    
    getUserName(){
      return sessionStorage.getItem("username");
    }
    getUserRole(){
     return sessionStorage.getItem("roles");
    }
    onLogOut(){
     this.authService.logout();
    }
    
    loggedIn(){
     return this.authService.isLoggedIn()
    }
    
 
  //opened=false;
 /*  selectedMenu:any='arbitre'
goTo(paramTexte:string)
{
  this.selectedMenu = paramTexte
} */
}


  
  
