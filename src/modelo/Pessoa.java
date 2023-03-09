package modelo;

import java.util.LinkedList;
                                                                    //ESTA E UMA CLASSE DIFERENTE DA ANTIGA PESSOA - ESSA PASSOU A PESSOACOMAULAS E ESTA SERVIRA PARA PESSOACOMAULA E O SEGURANCA
                                                                    // Serve apenas para estar correto semanticamente
public abstract class Pessoa extends Identificador {

    public Pessoa(String nome, long numero) {
        super(nome, numero);
    }

}

