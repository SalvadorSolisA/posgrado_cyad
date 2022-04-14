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
	fechaExamen: string;
	fechaTitulacion: string;
	activo: boolean;
	nivel: Nivel;
	plan: PlanEstudios;
	areac: AreaConcentracion;
	estado: EstadoAcademico;
}