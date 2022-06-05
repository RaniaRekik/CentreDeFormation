import { Organisme } from "../organisme/organisme";
import { Formateur } from "../formateur/formateur";

export interface Session {
    id : number;
    lieu : string;
    date_debut : Date;
    date_fin : Date;
    nb : number;
    formateur : Formateur;
    organisme : Organisme;
  
}