import { AreaConcentracion } from "./area-concentracion";
import { EstadoAcademico } from "./estado-academico";
import { Nivel } from "./nivel";
import { PlanEstudios } from "./plan-estudios";

export interface DatosAcademicos{
    id: number;
    dedicacion: string;
    creditosCubiertos: number;
	creditosAcumulados: number;
	trimestreIngreso: string;
	ulimoTrimestreAa: string;
	ulimoTrimestreRe: string;
	anioIngreso: number;
	promedio: number;
	numTrimestres: number;
	trimestreExamen: string;
	anioExamen: number;
	fechaExamen: Date;
	fechaTitulacion: Date;
	activo: boolean;
	nivel: Nivel;
	plan: PlanEstudios;
	areac: AreaConcentracion;
	estado: EstadoAcademico;
	fecha_ingreso : Date;
    fecha_egreso : Date;
    fecha_titulacion : Date;
    fecha_disertacion : Date;
	id_alumno : number;
}