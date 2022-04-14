import { Requisito } from "./requisito";

export interface Adeudo{
    id: number;
    documento: string;
    tipo: string;
    activo: boolean;
}