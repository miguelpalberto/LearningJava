package modelo;

import java.util.LinkedList;

public interface Funcionario<TGabinete extends Gabinete, TDivisao extends Divisao>{


    void abrir(TDivisao divisao);

    void fechar(TDivisao divisao);


    LinkedList<Horario> getHorarios();

    void adicionar(Horario horario);

    void remover(Horario horario);

    TGabinete getGabinete();

    void setGabinete(TGabinete gabinete);

    void desassociarGabinete();
}