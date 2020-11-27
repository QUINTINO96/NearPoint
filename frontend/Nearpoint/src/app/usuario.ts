import { Endereco } from './endereco';

export class Usuario {

    id: number;
    nome : string;
    email :string;
    telefone :string;
    cpf :string;
    tipoUsuario :number; // verificar se o tipo numero existe realmente
    sobrenome:string;
    fotoPerfil:ImageBitmap;
    endereco:Endereco; //olhar depois como declarar um objeto
    dataNascimento:string; //olhar depois como declarar data
    senha:string;
    //olhar como declarar o post e o list de post
}