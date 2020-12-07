import { getTestBed } from '@angular/core/testing';
import { Endereco } from './../endereco';
import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { Usuario }  from '../usuario'
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
  imageError: string;
  isImageSaved: boolean;
  cardImageBase64: string;
  senha: string;
  senha2:string;
  mensagem: string;
  confirmaSenha: number;


  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  this.confirmaSenha=0
  this.saveUsuario
  

  
 
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
    console.log(this.usuario)
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

        /* if (!_.includes(allowed_types, fileInput.target.files[0].type)) {
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

                    // this.previewImagePath = imgBase64Path;
                }
            };
        };

        reader.readAsDataURL(fileInput.target.files[0]);
        
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

}
  