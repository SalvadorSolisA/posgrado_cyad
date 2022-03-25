import { Correo } from "./correo";
import { Direccion } from "./direccion";

export interface Alumno {
    id : number;
    matricula : number;
    nombre : string;
    ap_paterno : string;
    ap_materno : string;
    curp : string;
    rfc: string;
    cvu: number;
    orcid : string;
    fecha_nacimiento : string;
    edad : number;
    genero : string;
    telefono : string;
    nacionalidad : string;
    correo: Correo;
    direccion: Direccion;
    activo : boolean;
}