import { Autor } from "./autor";
import { OrdenAutor } from "./orden-autor";
import { Produccion } from "./produccion";

export interface GrupoAutores{
    id : number;
    produccion : Produccion;
    orden : OrdenAutor;
    autor : Autor;
    activo : boolean;
}