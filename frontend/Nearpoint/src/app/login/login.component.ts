import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
import {FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form;


  email: number = 0;

  senha: number = 0;

  id: number
  
  mensagem: string;

  usuario = {} as Usuario
  usuarios: Usuario[]
  
 
  constructor(private route: ActivatedRoute, private router: Router,private formBuilder:FormBuilder, private usuarioService: UsuarioService) {

    this.criarForm();

}

  ngOnInit(): void{
    

    this.usuarioService.getUsuariosLogin()
      .subscribe(data => {
        console.log(data)
        this.usuarios = data;
      }, error => console.log(error));
      console.log( this.usuarios)
  }

  onLogin(){

  }

  // getUsuarios() {
  //   this.usuarioService.getUsuariosLogin().subscribe((Usuarios: Usuario[]) => {
  //     this.usuarios = Usuarios;
  //   });
  // }
  getUsuarios() {
    this.usuarioService.getUsuarios().subscribe((Usuarios: Usuario[]) => {
      this.usuarios = Usuarios;
    });
  }

  validaLogin(){
    
    for(var i=0;i<this.usuarios.length;i++){
      if(this.usuarios[i][1]==this.form.get('email').value){
        
        this.email=1
        if(this.usuarios[i][2]==this.form.get('senha').value){
          this.senha=1
          this.id=this.usuarios[i][0]
        }
      }
    }
    if(this.email==1 && this.senha==1){
      
      this.router.navigate(['/painel/'+this.id]);
        }else{
          this.mensagem="login ou senha incorretos"
        }
  }

  criarForm(){

    this.form = this.formBuilder.group({

        email: [''],

        senha: ['']

    })

}

}
