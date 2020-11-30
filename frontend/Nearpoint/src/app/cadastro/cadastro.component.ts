import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
import { Endereco } from '../endereco'
import { FormGroup, NgForm }  from '@angular/forms'

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  usuario = {} as Usuario
  usuarios: Usuario[]
  endereco = {} as Endereco
  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  this.getUsuarios()
  }

  saveUsuario(form: NgForm) {
    if (this.usuario.id !== undefined) {
      this.usuarioService.updateUsuario(this.usuario).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.usuarioService.saveUsuario(this.usuario).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // Chama o serviço para obtém todos os Usuarios
  getUsuarios() {
    this.usuarioService.getUsuarios().subscribe((Usuarios: Usuario[]) => {
      this.usuarios = Usuarios;
    });
  }

  // deleta um Usuarioro
  deleteUsuario(Usuario: Usuario) {
    this.usuarioService.deleteUsuario(Usuario).subscribe(() => {
      this.getUsuarios();
    });
  }

  // copia o Usuarioro para ser editado.
  editUsuario(Usuario: Usuario) {
    this.usuario = { ...Usuario };
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    this.getUsuarios();
    form.resetForm();
    this.usuario = {} as Usuario;
  }

}
  