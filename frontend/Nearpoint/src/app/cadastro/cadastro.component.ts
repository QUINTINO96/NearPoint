import { getTestBed } from '@angular/core/testing';
import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
import { FormGroup, NgForm }  from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  usuario = {} as Usuario
  usuarios: Usuario[]
  imageError: string;
  isImageSaved: boolean;
  cardImageBase64: string;
  senha: string;
  senha2:string;
  mensagem: string;
  confirmaSenha: number;
  previewImagePath: any;


  constructor(private route: ActivatedRoute, private router: Router, private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  this.confirmaSenha=0
  this.saveUsuario
  }

  saveUsuario(form: NgForm) {

      this.usuarioService.saveUsuario(this.usuario).subscribe(() => {
        this.usuarioService.updateUsuario

        this.usuarioService.getUsuarioByEmail(this.usuario.email) .subscribe(data => {
          console.log(data)
          this.usuario = data;

          this.usuarioService.updateEndereco(this.usuario)        
        }, error => console.log(error));

        this.cleanForm(form);
       
      });

    
    console.log(this.usuario)
    this.router.navigate(['/login']);
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
    this.getUsuarios;
    form.resetForm();
    this.usuario = {} as Usuario;
  } 
  fileChangeEvent(fileInput: any) {
    this.imageError = null;
    if (fileInput.target.files && fileInput.target.files[0]) {
        // Size Filter Bytes
        const max_size = 20971520;
        const allowed_types = ['image/png', 'image/jpeg'];
        const max_height = 15200;
        const max_width = 25600;

        if (fileInput.target.files[0].size > max_size) {
            this.imageError =
                'Maximum size allowed is ' + max_size / 1000 + 'Mb';

            return false;
        }

       /*  if (!fileInput.target.files[0].types.includes(allowed_types)) {
            this.imageError = 'Only Images are allowed ( JPG | PNG )';
            return false;
        } */
        const reader = new FileReader();
        reader.onload = (e: any) => {
            const image = new Image();
            image.src = e.target.result;
            image.onload = rs => {
                const img_height = rs.currentTarget['height'];
                const img_width = rs.currentTarget['width'];

                console.log(img_height, img_width);


                if (img_height > max_height && img_width > max_width) {
                    this.imageError =
                        'Maximum dimentions allowed ' +
                        max_height +
                        '*' +
                        max_width +
                        'px';
                    return false;
                } else {
                    const imgBase64Path = e.target.result;
                    this.cardImageBase64 = imgBase64Path;
                    this.isImageSaved = true;

                     this.previewImagePath = imgBase64Path;
                     this.usuario.fotoPerfil = imgBase64Path.toString();
                }
            };
        };

        reader.readAsDataURL(fileInput.target.files[0]);
        
        console.log(this.usuario.fotoPerfil);

        
       /*  this.usuario.fotoPerfil= btoa(this.usuario.fotoPerfil);
       
        console.log(this.usuario.fotoPerfil); */
        
        
        
    }
}

removeImage() {
    this.cardImageBase64 = null;
    this.isImageSaved = false;
}

onKeyUpEvent(event: any){
  if(this.usuario.senha!=this.usuario.senha2){
    this.mensagem="As senhas não conferem"
    this.confirmaSenha=0
  }else{
    this.mensagem="As senhas conferem"
    this.confirmaSenha=1
   
  }
  console.log(this.usuario.senha2);
  console.log(this.usuario.senha)

}

gotoList() {
  this.router.navigate(['/login']);
}
}

