import { Component, OnInit } from '@angular/core';
import { UsuarioService }  from '../usuario.service'
import { PostService } from '../post.service'
import { Usuario }  from '../usuario'
import { Post } from '../post'
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

  post = {} as Post
  posts: Post[]
  postsUsu: Post[]

  tipoUsuario: number
  
  constructor(private route: ActivatedRoute, private router: Router, private usuarioService: UsuarioService,private postService: PostService) { }

  ngOnInit(): void {
    
    this.usuario = new Usuario();
   
    this.id = this.route.snapshot.params['id'];

    this.usuarioService.getUsuarioById(this.id)
      .subscribe(data => {
        console.log(data)
        this.usuario = data;
        if(this.usuario.tipoUsuario==0){
          this.tipoUsuario=0
        }else if(this.usuario.tipoUsuario==1){
          this.tipoUsuario=1
        }
        console.log(this.tipoUsuario)
        
      }, error => console.log(error));

      window.location.reload
      this.postService.getPostList()
      .subscribe(data => {
       
        console.log(data)
        this.posts = data;
      }, error => console.log(error));

      this.postService.getPostListUsu(this.id)
      .subscribe(data => {
        console.log(data)
        this.postsUsu = data;
      }, error => console.log(error));
    

     

  }
  

  

}
