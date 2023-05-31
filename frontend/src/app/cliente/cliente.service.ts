import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {formatDate, DatePipe} from '@angular/common'
import { Cliente } from './cliente';
import { map, catchError, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private baseURL="http://localhost:8080/api/clientes"

  constructor(
    private http:HttpClient, private router: Router) { }

    getClientes(page: number): Observable<any> {
      //return of(CLIENTES);
      return this.http.get(this.baseURL + '/page/' + page ).pipe(
        tap((response: any) => {
          //let clientes = response as Cliente[];
          (response.content as Cliente[]).forEach(
            cliente => {
              console.log(cliente.nombre);
            }
          )
        }),
        map((response:any) => {
            //let clientes = response as Cliente[];
            (response.content as Cliente[]).map(cliente => {
             cliente.nombre = cliente.nombre.toUpperCase();
             //let datePipe = new DatePipe('es');
             //cliente.createAt = datePipe.transform(cliente.createAt, 'EEEE dd, MMMM yyyy'); //formatDate(cliente.createAt, 'dd-MM-yyyy', 'en-US')clientes.createAt

             return cliente;
           });
           return response;
        }),
        tap(response => {
          (response.content as Cliente[]).forEach(
            cliente => {
              console.log('Tap2');
              console.log(cliente.nombre);
            }
          )
        })
      );
    }

    create(cliente: Cliente) : Observable<Cliente>{
      return this.http.post(this.baseURL, cliente ).pipe(
        map( (response: any) => response.cliente as Cliente),
        catchError(e => {

          if(e.status==400){
            return throwError(e);
          }
          if(e.error.mensaje){
            console.error(e.error.mensaje);
          }


          console.error(e.error.mensaje);

          return throwError(e);
        })
      );
    }

    getCliente(id:number): Observable<Cliente>{
      return this.http.get<Cliente>(`${this.baseURL}/${id}`).pipe(
        catchError(e => {
          if(e.status != 401 && e.error.mensaje){
            this.router.navigate(['/clientes']);
            console.error(e.error.mensaje);
          }


          return throwError(e);

        })
      );
    }

    update(cliente: Cliente) : Observable<any>{
      return this.http.put<any>(`${this.baseURL}/${cliente.id}`, cliente ).pipe(
        catchError(e => {

          if(e.status==400){
            return throwError(e);
          }
          if(e.error.mensaje){
            console.error(e.error.mensaje);
          }

          return throwError(e);
        })
      );
    }

    delete(id: number): Observable<Cliente>{
      return this.http.delete<Cliente>(`${this.baseURL}/${id}`).pipe(
        catchError(e => {

          if(e.error.mensaje){
            console.error(e.error.mensaje);
          }

          return throwError(e);
        })
      );
    }

}
