import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})

export class UsuarioService {

  private url = 'http://localhost:8080/springboot-crud-rest/api/v1/usuarios/';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  getUsuariosLogin(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>('http://localhost:8080/springboot-crud-rest/api/v1/login/validade')
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  // Obtem um Usuarioro pelo id
  getUsuarioById(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(this.url + 'usuarios/' + id)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // salva um Usuarioro
  saveUsuario(Usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>('http://localhost:8080/springboot-crud-rest/api/v1/cadastro', JSON.stringify(Usuario), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // utualiza um Usuarioro
  updateUsuario(Usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(this.url + '/' + Usuario.id, JSON.stringify(Usuario), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // deleta um Usuarioro
  deleteUsuario(Usuario: Usuario) {
    return this.http.delete<Usuario>(this.url + '/' + Usuario.id, this.httpOptions)
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
