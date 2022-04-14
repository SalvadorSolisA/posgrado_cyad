import { TipoClaveAutor } from "./tipo-clave-autor";

export interface Autor {
    id : number;
    nombre : string;
    ap_paterno : string;
    ap_materno : string;
    clave : number;
    tipo_clave : TipoClaveAutor;
    nacionalidad : string;
    activo : boolean;
}