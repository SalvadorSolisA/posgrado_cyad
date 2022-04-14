import { Autor } from "./autor";
import { TipoProduccion } from "./tipo-produccion";

export interface Produccion {
    id: number;
    clave_producto: String;
    titulo: String;
    fecha_publicacion: String;
    descripcion: String;
    lgac: String;
    tipo: TipoProduccion;
    activo: boolean;
    autores: Autor[];
}