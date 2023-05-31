import { Component, OnInit  } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actualizar-producto',
  templateUrl: './actualizar-producto.component.html',
  styleUrls: ['./actualizar-producto.component.css']
})
export class ActualizarProductoComponent implements OnInit {
  id: number;
  producto: Producto = new Producto();
  constructor(
    private productoService: ProductoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.productoService.obtenerProductoId(this.id).subscribe(
      (dato) => {
        this.producto = dato;
      },
      (error) => console.log(error)
    );
  }

  onSubmit(){
    this.productoService.actualizarProducto(this.id,this.producto).subscribe(dato => {
      console.log(dato);
      this.irAlaListaDeProductos();
    },error => console.log(error));
  }

  irAlaListaDeProductos(){
    this.router.navigate(['/productos']);
  }
}
