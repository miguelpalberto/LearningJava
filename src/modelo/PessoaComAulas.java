package modelo;

import java.util.LinkedList;


public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas, AssociavelAulas {
    protected GestorAulas gestorAulas;

    public PessoaComAulas (String nome, long numero) {
        super(nome, numero);
        gestorAulas = new GestorAulas (this);
    }



    public void adicionar(Aula aula) {
        gestorAulas.adicionar(aula);
    }


    public void remover(Aula aula) {
        gestorAulas.remover(aula);
    }

    public void preencherSumario(Aula aula) {
        if (aula == null || !contem(aula)) {
            return;
        }
        escreverSumario(aula);
    }
    protected abstract void escreverSumario(Aula aula);
    public void assinar(Aula aula){
        aula.adicionarLinhaSumario(nome);
    }


    public LinkedList<Aula> getAulas() {
        return gestorAulas.getAulas();
    }


    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorAulas.getAulas(horario);
    }


    public boolean contem(Aula aula){
        return gestorAulas.contem(aula);
    }

}



