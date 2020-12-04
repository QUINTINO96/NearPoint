import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Post } from './post'

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url = 'http://localhost:8080/springboot-crud-rest/api/v1/posts';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  createPost(Post: Post): Observable<Post> {
    return this.http.post<Post>('http://localhost:8080/springboot-crud-rest/api/v1/posts', JSON.stringify(Post), this.httpOptions)
      .pipe(
        retry(2),
      )
  }

  getPostList(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.url}`);
  }
  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>(this.url + '/' + id)
      .pipe(
        retry(2),
      )
  }
  getPost(): Observable<Post[]> {
    return this.http.get<Post[]>(this.url)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  updatePost(Post: Post): Observable<Post> {
    return this.http.put<Post>(this.url + '/' + Post.id, JSON.stringify(Post), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // deleta um Usuarioro
  deletePost(Post: Post) {
    return this.http.delete<Post>(this.url + '/' + Post.id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // Manipulação de erros
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };

}