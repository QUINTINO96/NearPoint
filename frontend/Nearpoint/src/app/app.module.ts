import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePostComponent } from './create-post/create-post.component';
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

@NgModule({
  declarations: [
    AppComponent,
    CreatePostComponent,
    UpdatePostComponent,
    PostDetailsComponent,
    UsuarioDetailsComponent,
    PostListComponent,
    UsuarioListComponent,
    LoginComponent,
    CadastroComponent,
    PainelPadraoComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTabsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
