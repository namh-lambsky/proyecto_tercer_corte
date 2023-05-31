import { Factura } from "../facturas/models/factura";

export class Cliente {
  "id":number;
  "nombre":string;
  "apellido":string;
  "createdAt":string;
  "facturas":Factura[]=[];
}
