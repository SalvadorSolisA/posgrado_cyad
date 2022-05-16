import { GrupoProtocolo } from "./grupo-protocolo";
import { TipoProyecto } from "./tipo-proyecto";

export interface Proyecto{
    id: number;
    clave: string;
    titulo: string;
    descripcion: string;
    fecha_inicio:string;
    fecha_termino: string;
    lgac: string;
    tipo: TipoProyecto;
    grupo : GrupoProtocolo;
    activo: boolean;
}