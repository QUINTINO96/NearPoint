import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service'
import { Post } from '../post'
import { FormGroup, NgForm }  from '@angular/forms'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-criar-post',
  templateUrl: './criar-post.component.html',
  styleUrls: ['./criar-post.component.css']
})
export class CriarPostComponent implements OnInit {

  id: number;
  post = {} as Post
  posts: Post[]
  imageError: string;
  isImageSaved: boolean;
  cardImageBase64: string;

  constructor(private route: ActivatedRoute, private router: Router, private postService : PostService) { }

  ngOnInit(): void {
    this.getPosts()
  }

  savePost(form: NgForm) {
    if (this.post.id !== undefined) {

      this.postService.createPost(this.post).subscribe(() => { 

      });
      
    } else {
      this.postService.createPost(this.post).subscribe(() => {
      
      });
    }
  }



  getPosts() {
    this.postService.getPostList().subscribe((Posts: Post[]) => {
      this.posts = Posts;
    });
  }
  save(){
    this.router.navigate(['/painel/'+this.id]);
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

}
