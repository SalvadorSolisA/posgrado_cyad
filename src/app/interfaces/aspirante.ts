import { Adeudo } from "./adeudo";
import { EstadoAspirante } from "./estado-aspirante";

export interface Aspirante{
    id: number;
    curp: string;
    rfc:string;
	fecha_nacimiento:string;
	edad: number;
	genero: string;
	telefono: string;
	nacionalidad: string;
	nombre: string;
	ap_paterno: string;
	ap_materno: string;
	trayectoria: string;
	anio_ingreso: number;
	trimestre_ingreso: string;
    estado: EstadoAspirante;
	correo: string;
	adeudos: Adeudo[];
	activo: boolean;
}