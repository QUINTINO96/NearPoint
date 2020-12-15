import { ArrayType } from '@angular/compiler';
export class Usuario {

    
    id: number;
    nome : string;
    email :string;
    telefone :string;
    cpf :string;
    tipoUsuario :number; // verificar se o tipo numero existe realmente
    sobrenome:string;
    fotoPerfil: string;
    rua: string;
    bairro: string;
    cep: string;
    complemento: string;
    estado: string;
    cidade: string;
    dataNascimento:string; //olhar depois como declarar data
    senha:string;
    senha2:string;
    //olhar como declarar o post e o list de post
}