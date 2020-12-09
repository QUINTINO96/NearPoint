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
  
  constructor(private route: ActivatedRoute, private router: Router, private usuarioService: UsuarioService,private postService: PostService) { }

  ngOnInit(): void {
    this.usuario = new Usuario();

    this.id = this.route.snapshot.params['id'];

    this.usuarioService.getUsuarioById(this.id)
      .subscribe(data => {
        console.log(data)
        this.usuario = data;
      }, error => console.log(error));

      this.postService.getPostList()
      .subscribe(data => {
        console.log(data)
        this.posts = data;
      }, error => console.log(error));
    
      console.log(this.posts)


  }

  

}
