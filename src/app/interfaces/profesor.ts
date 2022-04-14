import { AreaInvestigacion } from "./areaInvestiongacion";
import { Departamento } from "./departamento";
import { Division } from "./division";
import { Institucion } from "./institucion";

export interface Profesor {
    id : number;
    numero_economico : number;
    nombre : string;
    ap_paterno : string;
    ap_materno : string;
    cvu : number;
    institucion: Institucion;
    division: Division;
    departamento: Departamento;
    area_investigacion: AreaInvestigacion;
    activo : boolean;
}