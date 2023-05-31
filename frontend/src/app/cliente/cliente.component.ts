import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { ModalService } from './detalle/modal.service';
import { ActivatedRoute } from '@angular/router';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit{
clientes:Cliente[];
paginador: any;
clienteSeleccionado:Cliente;
dtOptions: DataTables.Settings = {};


constructor(private clienteService: ClienteService,private activatedRoute: ActivatedRoute, public modalService: ModalService){}

ngOnInit() { this.activatedRoute.paramMap.subscribe(params => {
  let page: number = +(params?.get('page') ?? '0');

  if(!page){
      page = 0;
  }

  this.clienteService.getClientes(page).pipe(
    tap(response => {
      console.log('Tap3');
      (response.content as Cliente[]).forEach(cliente => {
        console.log(cliente.nombre);
      });
    })
  ).subscribe(
    // => es la forma de declarar una funcion anonima.
    response => {
      this.clientes = response.content as Cliente[];
      this.paginador = response;
    }
  );
}
);

this.modalService.notificarUpload.subscribe(cliente => {
  this.clientes = this.clientes.map(clienteOriginal => {
      if(cliente.id == clienteOriginal.id){
      }
      return clienteOriginal;
  })
})
}

delete(cliente: Cliente): void {({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})



}

abrirModal(cliente: Cliente){
  this.clienteSeleccionado = cliente;
  this.modalService.abrirModal();
}



}
