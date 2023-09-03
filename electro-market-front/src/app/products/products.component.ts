import {Component, OnInit} from '@angular/core';
import { MatCardModule } from "@angular/material/card";
import { MatGridListModule } from "@angular/material/grid-list";
import { NgForOf } from "@angular/common";
import {Product} from "../entities/product";
import {ProductsService} from "./service/products.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
  standalone: true,
  imports: [MatCardModule, MatGridListModule, NgForOf]
})
export class ProductsComponent implements OnInit {
  products: Product[] = [];

  constructor(private productsService: ProductsService) {
  }

  ngOnInit(): void {
    this.productsService.list().subscribe(products => {
      this.products = products;
      }
    );
  }

}
