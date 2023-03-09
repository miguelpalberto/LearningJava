package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor, Sala>{

    private GabineteProfessor gabinete;
    private GestorFuncionarioProfessor gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        gestorFuncionario = new GestorFuncionarioProfessor(this);
        setGabinete(gabinete);
    }




    @Override
    public void associar(Aula aula) {                   //ficha 6 passou de protected a public
        aula.setProfessor(this);
    }

    @Override
    public void desassociar(Aula aula) {                   //ficha 6 passou de protected a public
        aula.desassociarProfessor();
    }

    @Override
    public void escreverSumario(Aula aula) {

        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));

        assinar(aula);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }

    }



    @Override
    public void abrir(Sala sala){

        gestorFuncionario.abrir(sala);
    }

    @Override
    public void fechar(Sala sala){

        gestorFuncionario.fechar(sala);
    }


    @Override
    public GabineteProfessor getGabinete(){
        return gestorFuncionario.getGabinete();
    }

    @Override
    public void setGabinete(GabineteProfessor gabinete){
        gestorFuncionario.setGabinete(gabinete);
    }

    @Override
    public void desassociarGabinete() {
        gestorFuncionario.desassociarGabinete();

    }




    @Override
    public LinkedList<Horario> getHorarios() {
        return gestorFuncionario.getHorarios();
    }

    @Override
    public void adicionar(Horario horario){
        if(gestorFuncionario.isSobreAulas(horario) || gestorFuncionario.isSobre(horario)) {
            return;
        }
        gestorFuncionario.adicionar(horario);


    }

    @Override
    public void remover(Horario horario){
        gestorFuncionario.remover(horario);
    }

}







