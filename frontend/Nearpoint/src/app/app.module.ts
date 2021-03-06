import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UpdatePostComponent } from './update-post/update-post.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { UsuarioDetailsComponent } from './usuario-details/usuario-details.component';
import { PostListComponent } from './post-list/post-list.component';
import { UsuarioListComponent } from './usuario-list/usuario-list.component';
import { LoginComponent } from './login/login.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { PainelPadraoComponent } from './painel-padrao/painel-padrao.component';


import {MatTabsModule} from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CriarPostComponent } from './criar-post/criar-post.component';
import { FormsModule } from '@angular/forms'

import {HttpClientModule} from '@angular/common/http'
import { UpdateUsuarioComponent } from './update-usuario/update-usuario.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UpdatePostComponent,
    PostDetailsComponent,
    UsuarioDetailsComponent,
    PostListComponent,
    UsuarioListComponent,
    LoginComponent,
    CadastroComponent,
    PainelPadraoComponent,
    CriarPostComponent,
    UpdateUsuarioComponent,

 

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTabsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
