package modelo;

import java.util.LinkedList;


public abstract class Gabinete<TFuncionario extends Funcionario> extends Divisao{
    protected LinkedList<TFuncionario> funcionarios;


    public Gabinete(String nome, boolean portaAberta) {
        super(nome, portaAberta);
        funcionarios = new LinkedList<>();
    }



    public LinkedList<TFuncionario> getFuncionarios() {                                //Enunciado pede que seja possivel devolver lista professores da LinkedList
        return new LinkedList<>(funcionarios);
    }

    public void adicionar(TFuncionario funcionario) {
        if (funcionario == null || funcionarios.contains(funcionario)) {
            return;
        }
        funcionarios.add(funcionario);
        funcionario.setGabinete(this);                         //é sinonimo de associarGabinete
    }

    public void remover(TFuncionario funcionario) {
        if (funcionario == null || !funcionarios.contains(funcionario)) {
            return;
        }
        funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }


}
