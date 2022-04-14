import { GrupoProtocolo } from "./grupo-protocolo";
import { RolParticipante } from "./rol-participante";

export interface Participante{
    id : number;
    id_profesor : number;
    grupo : GrupoProtocolo;
    rol : RolParticipante;
    activo : boolean;
}