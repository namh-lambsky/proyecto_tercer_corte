import { ItemFactura } from "./item-factura";
import { Cliente } from "src/app/cliente/cliente";

export class Factura {
  "id":number;
  "description":string;
  "items": Array< ItemFactura>=[];
  "cliente":Cliente;
  "valorTotal":number;
  "createAt":string;

  calcularGranTotal(): number {
    this.valorTotal = 0;
    this.items.forEach((item:ItemFactura) => {
      this.valorTotal += item.calcularImporte();
    });

    return this.valorTotal;
  }

}
