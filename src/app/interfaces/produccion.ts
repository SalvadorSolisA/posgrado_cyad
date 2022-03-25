import { TipoProduccion } from "./tipoproduccion";

export interface Produccion {
    id: number;
    clave_producto: String;
    titulo: String;
    fecha_publicacion: String;
    descripcion: String;
    lgac: String;
    tipo: TipoProduccion;
}