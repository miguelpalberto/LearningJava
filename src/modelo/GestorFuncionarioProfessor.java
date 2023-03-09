package modelo;

import java.util.LinkedList;

public class GestorFuncionarioProfessor extends GestorFuncionario<GabineteProfessor, Sala> {

    public GestorFuncionarioProfessor(Professor professor) {
        super(professor);
    }


    public boolean isSobreAulas(Horario horario) {
        for (Aula aula : ((Professor)funcionario).getAulas()) {
            if(aula.isSobre(horario)){
                return true;
            }
        }
        return false;
    }
}
