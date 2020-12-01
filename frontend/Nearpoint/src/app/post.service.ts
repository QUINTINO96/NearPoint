import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Post } from './post'

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/posts';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  getPost(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  // createPost(post: Object): Observable<Object> {
  //   return this.http.post(`${this.baseUrl}`, post);
  // }

  createPost(Post: Post): Observable<Post> {
    return this.http.post<Post>('http://localhost:8080/springboot-crud-rest/api/v1/posts', JSON.stringify(Post), this.httpOptions)
      .pipe(
        retry(2),
      )
  }

  updatePost(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getPostList(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.baseUrl}`);
  }
}