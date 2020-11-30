import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
import { FormGroup, NgForm }  from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-painel-padrao',
  templateUrl: './painel-padrao.component.html',
  styleUrls: ['./painel-padrao.component.css']
})
export class PainelPadraoComponent implements OnInit {

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

}
