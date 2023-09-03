import { Injectable } from '@angular/core';
import {Product} from "../../entities/product";
import {first, map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private readonly urlRoot: string = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }

  list(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.urlRoot}/product`)
      .pipe(
        map((products) =>
          products.map(p => {
            return {...p, priceInCents: (p.priceInCents/100)}
          })
        ),
        first()
      );
  }
}
