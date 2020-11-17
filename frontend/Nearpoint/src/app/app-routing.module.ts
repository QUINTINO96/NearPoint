import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { CriarPostComponent } from './criar-post/criar-post.component';
import { LoginComponent } from './login/login.component';
import { PainelPadraoComponent } from './painel-padrao/painel-padrao.component';




const routes: Routes = [
  { path: '',component: LoginComponent},
  { path: 'cadastro', component: CadastroComponent },
  { path: 'login',component: LoginComponent},
  { path: 'anuncio',component: PainelPadraoComponent},
  { path: 'painel',component: PainelPadraoComponent},
  { path: 'criar',component: CriarPostComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
