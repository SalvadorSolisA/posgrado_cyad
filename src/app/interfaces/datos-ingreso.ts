import { Adeudo } from "./adeudo";

export interface DatosIngreso{
    id: number;
    escuelaProcedencia: string;
    promedio: number;
    nivelStudios: string
    activo: boolean;
    adeudos: Adeudo[];
}