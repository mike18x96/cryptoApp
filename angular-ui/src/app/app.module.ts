import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { WeatherComponent } from './components/weather/weather.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { GithubComponent } from './components/github/github.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { githubUrl, weatherFormUrl, weatherUrl } from './models/links';
import { WeatherFormComponent } from './components/weather-form/weather-form.component';

const routes: Routes = [
  { path: githubUrl, component: GithubComponent },
  { path: weatherUrl, component: WeatherComponent },
  { path: weatherFormUrl, component: WeatherFormComponent },
  { path: '', redirectTo: weatherUrl, pathMatch: 'full'},
  { path: '**', component: NotFoundComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    WeatherComponent,
    GithubComponent,
    NotFoundComponent,
    WeatherFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatToolbarModule,
    MatDividerModule,
    MatButtonToggleModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
