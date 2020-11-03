import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { CreateUsuarioComponent } from './create-usuario/create-usuario.component';
import { UpdateUsuarioComponent } from './update-usuario/update-usuario.component';
import { UpdatePostComponent } from './update-post/update-post.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { UsuarioDetailsComponent } from './usuario-details/usuario-details.component';
import { PostListComponent } from './post-list/post-list.component';
import { UsuarioListComponent } from './usuario-list/usuario-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatePostComponent,
    CreateUsuarioComponent,
    UpdateUsuarioComponent,
    UpdatePostComponent,
    PostDetailsComponent,
    UsuarioDetailsComponent,
    PostListComponent,
    UsuarioListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
