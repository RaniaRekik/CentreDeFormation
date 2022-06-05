import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaysComponent } from './pays/pays.component';
import { OrganismeComponent } from './organisme/organisme.component';
import { ProfilComponent } from './profil/profil.component';
import { DomaineComponent } from './domaine/domaine.component';
import { ParticipantComponent } from './participant/participant.component';
import { FormationComponent } from './formation/formation.component';
import { FormateurComponent } from './formateur/formateur.component';

import { UserContent } from './users/usercontent.component';
import { AdminContent } from './users/admincontent.component';
import { SessionComponent } from './session/session.component';
import { SessionDetailsComponent } from './session-details/session-details.component';
import { FormationDetailsComponent } from './formation-details/formation-details.component';

import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { AllUsersComponent } from './users/allusers.component';
const routes: Routes = [

  /* { path: '', redirectTo: 'home', pathMatch: 'full' }, */
  {path: 'signup', component: RegisterComponent}, 
  {path: 'login', component: LoginComponent}, 
  {path: 'home', component: HomeComponent},
  {path: 'allusers', component: AllUsersComponent},
  {path: 'usercontent', component: UserContent},
  {path: 'admincontent', component: AdminContent},

  {path: 'pays', component: PaysComponent}, 
   {path: 'organisme', component: OrganismeComponent} ,
   {path: 'profil', component: ProfilComponent} ,
   {path: 'domaine', component: DomaineComponent} ,
   {path: 'participant', component: ParticipantComponent} ,
   {path: 'formation', component: FormationComponent} ,
   {path: 'formation/:formationId', component: FormationDetailsComponent} ,
   {path: 'formateur', component: FormateurComponent} ,
   {path: 'session', component: SessionComponent} ,
   {path: 'session/:sessionId', component: SessionDetailsComponent} ,

  
  ]


@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
