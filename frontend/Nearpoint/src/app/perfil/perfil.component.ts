import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
import { NgForm }  from '@angular/forms'

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  usuario = {} as Usuario
  usuarios: Usuario[]
  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  this.getUsuarios()
  }

  getUsuarios() {
    this.usuarioService.getUsuarios().subscribe((usuarios: Usuario[]) => {
      this.usuarios = usuarios;
    });
  }

}
