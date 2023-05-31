import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { HttpEventType } from '@angular/common/http';
import { ModalService } from './modal.service';
import { Factura } from '../../facturas/models/factura';
import { FacturaService } from 'src/app/facturas/factura.service';

@Component({
  selector: 'detalle-cliente',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {
  @Input() cliente: Cliente;
  titulo: string = "Detalle del cliente";

  //authService is used to hide buttons in the views based on roles
  constructor(private clienteService: ClienteService,
    public modalService: ModalService,
    private facturaService: FacturaService ) { }

  ngOnInit() { }



  cerrarModal(){
    this.modalService.cerrarModal();
  }

  delete(factura: Factura){
    this.facturaService.delete(factura.id).subscribe((dato) => {
      console.log(dato);
    });
  }

  ShowFactura(factura:Factura){
    this.facturaService.getFactura(factura.id).subscribe((dato)=>{
      console.log(dato);
    });
  }


}
