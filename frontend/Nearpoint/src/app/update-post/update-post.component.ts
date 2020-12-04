import { Component, OnInit } from '@angular/core';
import { PostService }  from '../post.service'
import { Post }  from '../post'
import { FormGroup, NgForm }  from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.css']
})

export class UpdatePostComponent implements OnInit {


  id: number;
  post: Post;
  
  constructor(private route: ActivatedRoute, private router: Router, private postService: PostService) { }

  ngOnInit(): void {
    this.post = new Post();

    this.id = this.route.snapshot.params['id'];

    this.postService.getPostById(this.id)
      .subscribe(data => {
        console.log(data)
        this.post = data;
      }, error => console.log(error));
    }

    savePost() {
      this.postService.updatePost(this.post).subscribe(() => {});
  }


  }