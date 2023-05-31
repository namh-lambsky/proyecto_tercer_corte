import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaProductosComponent } from './lista-productos/lista-productos.component';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { RegistrarProductoComponent } from './registrar-producto/registrar-producto.component';
import { FormsModule } from '@angular/forms';
import { ActualizarProductoComponent } from './actualizar-producto/actualizar-producto.component';
import { FacturasComponent } from './facturas/facturas.component';
import { RouterModule,Routes } from '@angular/router';
import { DetallesProductosComponent } from './detalles-productos/detalles-productos.component';
import { ClienteComponent } from './cliente/cliente.component';
import { ClienteService } from './cliente/cliente.service';
import { DetalleComponent } from './cliente/detalle/detalle.component';
import { DetalleFacturaComponent } from './facturas/detalle-factura.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { PaginatorComponent } from './paginator/paginator.component';


const routes: Routes = [
  {path:'productos',component:ListaProductosComponent},
  {path:'actualizar-producto/:id',component:ActualizarProductoComponent},
  {path:'registrar-producto',component:RegistrarProductoComponent},
  {path:'facturas', component:FacturasComponent},
  {path:'detalles-productos', component:DataTablesModule},
  {path:'cliente', component:ClienteComponent},
  {path:'detalle', component:DetalleComponent},
  {path:'detalle-factura',component:DetalleFacturaComponent},
  {path: 'facturas/form/:clienteId', component: FacturasComponent},
  {path:'',redirectTo:'login-restaurante',pathMatch:'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListaProductosComponent,
    RegistrarProductoComponent,
    ActualizarProductoComponent,
    FacturasComponent,
    DetallesProductosComponent,
    ClienteComponent,
    DetalleFacturaComponent,
    PaginatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    DataTablesModule,
    MatAutocompleteModule
  ],
  exports: [],
  providers: [ClienteService],
  bootstrap: [AppComponent],
})
export class AppModule {}
