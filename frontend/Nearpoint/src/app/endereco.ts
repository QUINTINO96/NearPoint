import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class Endereco{
  rua:string;
  complemento:string;
  estado:string;
  cep:string;
  bairro:string;
  cidade:string;

}