package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario<GabineteSeguranca, Divisao> {

    private GestorFuncionario<GabineteSeguranca, Divisao> gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {

        super(nome, numero);
        gestorFuncionario = new GestorFuncionario<>(this);
        setGabinete(gabinete);
    }


    @Override
    public void abrir(Divisao divisao){
        gestorFuncionario.abrir(divisao);
    }
    ///
    @Override
    public void fechar(Divisao divisao){
        gestorFuncionario.fechar(divisao);
    }



    @Override
    public GabineteSeguranca getGabinete() {
        return gestorFuncionario.getGabinete();
    }

    @Override
    public void setGabinete (GabineteSeguranca gabinete){
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
        if(gestorFuncionario.isSobre(horario)) {
            return;
        }
        gestorFuncionario.adicionar(horario);

    }

    @Override
    public void remover(Horario horario){
        gestorFuncionario.remover(horario);
    }


}