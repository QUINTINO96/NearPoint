import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service'
import { Post } from '../post'
import { FormGroup, NgForm }  from '@angular/forms'

@Component({
  selector: 'app-criar-post',
  templateUrl: './criar-post.component.html',
  styleUrls: ['./criar-post.component.css']
})
export class CriarPostComponent implements OnInit {

  post = {} as Post
  posts: Post[]

  constructor(private postService : PostService) { }

  ngOnInit(): void {
    this.getPosts()
  }

  savePost(form: NgForm) {  
  
      this.postService.createPost(this.post).subscribe(() => { });
    
  }

  getPosts() {
    this.postService.getPostList().subscribe((Posts: Post[]) => {
      this.posts = Posts;
    });
  }

}
