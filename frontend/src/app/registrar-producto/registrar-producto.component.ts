import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registrar-producto',
  templateUrl: './registrar-producto.component.html',
  styleUrls: ['./registrar-producto.component.css'],
})
export class RegistrarProductoComponent {
  producto: Producto = new Producto();


  constructor(
    private productoService: ProductoService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  guardarProducto() {
    this.productoService.registrarProducto(this.producto).subscribe(
      (dato) => {
        console.log(dato);
        this.irAListaProducto()
      },
      (error) => console.error(error)
    );
  }

  irAListaProducto() {
    this.router.navigate(['/productos']);
  }

  onSubmit() {
    this.guardarProducto();
  }

}
