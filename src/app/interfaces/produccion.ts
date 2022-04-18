import { Byte } from "@angular/compiler/src/util";
import { Autor } from "./autor";
import { TipoProduccion } from "./tipo-produccion";

export interface Produccion {
    id: number;
    clave_producto: String;
    titulo: String;
    fecha_publicacion: String;
    descripcion: String;
    lgac: String;
    nombre: String;
    tipo: TipoProduccion;
    documento : Byte[];
    activo: boolean;
    autores: Autor[];
}