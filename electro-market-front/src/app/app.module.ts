import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from "@angular/material/toolbar";
import { HomeComponent } from './home/home.component';
import { MatButtonModule } from "@angular/material/button";
import { ProductsComponent } from "./products/products.component";
import {RegisterProductComponent} from "./register-product/register-product.component";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    ProductsComponent,
    HomeComponent,
    RegisterProductComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
