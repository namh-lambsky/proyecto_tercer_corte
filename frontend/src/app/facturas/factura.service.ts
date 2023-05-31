import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from './models/factura';
import { Producto } from '../producto';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  private baseURL="http://localhost:8080/api/facturas";

  constructor(private http: HttpClient) { }

  getFactura(id:number):Observable<Factura>{
    return this.http.get<Factura>(`${this.baseURL}/${id}`);
  }

  delete(id: number): Observable<void>{
    return this.http.delete<void>(`${this.baseURL}/${id}`);
  }

  filtrarProductos(term:string):Observable<Producto[]>{
    return this.http.get<Producto[]>(`${this.baseURL}/filtrar-productos/${term}`);

  }

  create(factura: Factura): Observable<Factura>{
    return this.http.post<Factura>(this.baseURL, factura);
  }


}
