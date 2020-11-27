import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/posts';

  constructor(private http: HttpClient) { }

  getPost(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createPost(post: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, post);
  }

  updatePost(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getPostList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}