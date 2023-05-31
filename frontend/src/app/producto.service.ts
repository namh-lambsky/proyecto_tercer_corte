import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
//URL de tipo get para obtener todos los productos de la tabla empleados
 private baseURL="http://localhost:8080/products";

  constructor(private httpClient : HttpClient) { }

//obtener los empleados
  obtenerListaProducto():Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(`${this.baseURL}`);
  }

  obtenerProductoId(id:number):Observable<Producto>{
    return this.httpClient.get<Producto>(`${this.baseURL}/${id}`)
  }

//registrar un nuevo producto
  registrarProducto(producto:Producto):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/new`,producto);
  }

  actualizarProducto(id:number,producto:Producto):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/update-${id}`,producto)
  }

  eliminarProducto(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete-${id}`)
  }


}
