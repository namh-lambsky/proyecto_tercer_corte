import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.css']
})
export class ListaProductosComponent  {
  productos:Producto[];
  dtOptions: DataTables.Settings = {};


  constructor(
    private productoService: ProductoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      processing: true,
    };
   this.obtenerProductos();
  }

  private obtenerProductos() {
    this.productoService.obtenerListaProducto().subscribe((dato) => {
      this.productos = dato;
      console.log(dato);
    });
  }

  actualizarProducto(id: number) {
    this.router.navigate(['/actualizar-producto', id]);
  }

  eliminarProducto(id: number) {
    this.productoService.eliminarProducto(id).subscribe((dato) => {
      console.log(dato);
      this.obtenerProductos();
    });
  }
}
