import { Component } from '@angular/core';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { NgxMaskDirective, provideNgxMask } from "ngx-mask";
import {NgxDropzoneChangeEvent, NgxDropzoneModule} from "ngx-dropzone";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { NgIf } from "@angular/common";
import { Product } from "../entities/product";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-register-product',
  templateUrl: './register-product.component.html',
  styleUrls: ['./register-product.component.scss'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, NgxMaskDirective, NgxDropzoneModule,
    HttpClientModule, NgIf, MatButtonModule, FormsModule],
  providers: [provideNgxMask()]
})
export class RegisterProductComponent {
  file: File = new File([], "", {});
  product: Product = {
    name: "",
    priceInCents: 0,
    description: "",
    imageFileName: "",
    base64Image: ""
  };

  constructor(private http: HttpClient) { }

  onSelect(event: NgxDropzoneChangeEvent) {
    console.log(event);
    this.file = event.addedFiles[0];
  }

  saveProduct() {
    const formData = new FormData();
    const productToBeSaved = {...this.product, priceInCents: this.convertDollarsToCents(this.product.priceInCents)};
    const blobProduct = new Blob([JSON.stringify(productToBeSaved)], { type: "application/json" });
    formData.append("product", blobProduct);
    formData.append("imageFile", this.file);
    this.http.post('http://localhost:8080/product', formData)
    .subscribe(res => {
      console.log(res);
    });
  }

  private convertDollarsToCents(priceInCents: number): number {
    return Math.floor(priceInCents*100);
  }

  onRemove() {
    this.file = new File([], "", {});
  }
}
