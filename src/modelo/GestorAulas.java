package modelo;

import java.util.LinkedList;

public class GestorAulas{

    private LinkedList<Aula> aulas;

    private AssociavelAulas associavelAulas;

    public GestorAulas(AssociavelAulas associavelAulas) {
        aulas = new LinkedList<>();
        this.associavelAulas = associavelAulas;
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }


    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasSobreHorario = new LinkedList<>();
        for (Aula aula : aulas) {
            if (aula.isSobre(horario)) {
                aulasSobreHorario.add(aula);
            }

        }
        return aulasSobreHorario;
    }


    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associavelAulas.associar(aula);

    }



    public void remover(Aula aula) {
        if (aula == null || !contem(aula)) {
            return;
        }
        aulas.remove(aula);
        associavelAulas.desassociar(aula);
    }


    public boolean contem(Aula aula){                           //ficha6
        return aulas.contains(aula);
    }




}