
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaProductosComponent } from './lista-productos/lista-productos.component';
import { RegistrarProductoComponent } from './registrar-producto/registrar-producto.component';
import { ActualizarProductoComponent } from './actualizar-producto/actualizar-producto.component';
import { FacturasComponent } from './facturas/facturas.component';
import { DetallesProductosComponent } from './detalles-productos/detalles-productos.component';
import { ClienteComponent } from './cliente/cliente.component';
import { DetalleComponent } from './cliente/detalle/detalle.component';

const routes: Routes = [
  {path : 'productos', component:ListaProductosComponent},
  {path : 'registrar-producto', component : RegistrarProductoComponent},
  {path:'actualizar-producto/:id',component:ActualizarProductoComponent},
  {path:'facturas', component:FacturasComponent},
  {path:'detalles-productos', component:DetallesProductosComponent},
  {path:'cliente', component:ClienteComponent},
  {path:'detalle', component:DetalleComponent},
  {path: 'facturas/form/:clienteId', component: FacturasComponent},
  {path:'',redirectTo:'cliente',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
