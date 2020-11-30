import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
import { Endereco } from '../endereco'
import { FormGroup, NgForm }  from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-usuario',
  templateUrl: './update-usuario.component.html',
  styleUrls: ['./update-usuario.component.css']
})
export class UpdateUsuarioComponent implements OnInit {

  id: number;
  usuario: Usuario;
  
  constructor(private route: ActivatedRoute, private router: Router, private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.usuario = new Usuario();

    this.id = this.route.snapshot.params['id'];

    this.usuarioService.getUsuarioById(this.id)
      .subscribe(data => {
        console.log(data)
        this.usuario = data;
      }, error => console.log(error));
    }

    saveUsuario() {
      this.usuarioService.updateUsuario(this.usuario).subscribe(() => {});
  }


  }

  
