import { Endereco } from './endereco';
import { ArrayType } from '@angular/compiler';
export class Usuario extends Endereco {

    id: number;
    nome : string;
    email :string;
    telefone :string;
    cpf :string;
    tipoUsuario :number; // verificar se o tipo numero existe realmente
    sobrenome:string;
    fotoPerfil:string;
    rua = this.rua;
    complemento = this.complemento;
    estado = this.estado;
    cep = this.cep;
    bairro = this.bairro;
    cidade = this.cidade;//olhar depois como declarar um objeto
    dataNascimento:string; //olhar depois como declarar data
    senha:string;
    senha2:string;
}