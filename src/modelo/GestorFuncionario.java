package modelo;

import java.util.LinkedList;

public class GestorFuncionario<TGabinete extends Gabinete, TDivisao extends Divisao> {

    protected Funcionario<TGabinete, TDivisao> funcionario;
    private TGabinete gabinete;
    private LinkedList<Horario> horarios;



    public GestorFuncionario(Funcionario<TGabinete, TDivisao> funcionario) {
        this.funcionario = funcionario;
        gabinete = null;
        horarios = new LinkedList<>();
    }






    public TGabinete getGabinete(){
        return gabinete;
    }


    public void setGabinete(TGabinete gabinete){
        if (gabinete == null || this.gabinete == gabinete) {
            return;
        }
        if (this.gabinete != null) {
            this.gabinete.remover(funcionario);
        }

        gabinete.adicionar(funcionario);
        this.gabinete = gabinete;
    }


    public void desassociarGabinete() {
        if (gabinete == null) {
            return;
        }
        TGabinete gabineteARemover = gabinete;
        gabinete = null;
        gabineteARemover.remover(funcionario);

    }






public void abrir(TDivisao divisao){                                          //mudado de abrirSala para abrirDivisao quando fizemos a classe Divisao

    if (divisao == null || divisao.isPortaAberta()){//se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
        return;
    }
    divisao.abrir();
}
    public void fechar(TDivisao divisao){

        if (divisao == null || !divisao.isPortaAberta()){//se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        divisao.fechar();
    }







    public LinkedList<Horario> getHorarios() {
        return new LinkedList<>(horarios);   //para geeestor?
    }

    public void adicionar(Horario horario){
        if (horario == null || horarios.contains(horario)) {
            return;
        }
        for (Horario horario1 : horarios) {             //correto confirmado pelo prof
            if(horario.isSobre(horario1)){
                return;
            }
        }

        horarios.add(horario);
    }

    /*
    //DESCOMENTAR E RESOLVER PROBLEMA:
    //para gestor funcionario professor:
    public boolean isSobreAulas(Horario horario) {
        for (Aula aula : GestorAulas.getAulas()) {
            if(aula.isSobre(horario)){
                return true;
            }
        }
        return false;
    }*/

    public boolean isSobre(Horario horario){                    //funcao para ver se horario está a coincidir (tudo ou em parte) com o outro horario
        return horario.isSobre(horario);                   //this.horario é o recetor e horario é o parametro(/mensagem enviada))
    }


    public void remover(Horario horario){
        if (horario == null || !horarios.contains(horario)) {
            return;
        }
        horarios.remove(horario);
    }


}







/*
    public void abrirGabinete(){

        if (gabinete == null || gabinete.isPortaAberta()){//se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        gabinete.abrir();
    }
    ///
    public void fecharGabinete(){

        if (gabinete == null || !gabinete.isPortaAberta()){//se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        gabinete.fechar();
    }*/






//  NAO DA PARA USAR O ABRIR E FECHAR GABINETE AQUI PORQUE NAO SABEMOS QUAL DOS DOIS GABINETE  NOS REFERIMOS
    /*

    @Override
    public void abrirGabinete(){//copiado de Professor

        if (gabinete == null || gabinete.isPortaAberta()){      //se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        gabinete.abrir();
    }
    ///


    @Override
    public void fecharGabinete(){//copaido de Professor

        if (gabinete == null || !gabinete.isPortaAberta()){     //se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        gabinete.fechar();
    }
*//*
    @Override
    public LinkedList<>)(Horario) getHorarios() {
        return new LinkedList<>(horarios);
    }

    public void abrirDivisao(){//mudado de abrirSala para abrirDivisao quando fizemos a classe Divisao

        if (divisao == null || divisao.isPortaAberta()){//se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        divisao.abrir();
    }
    public void fecharDivisao(){

        if (divisao == null || !divisao.isPortaAberta()){//se porta estiver aberta ou se prof nao tiver gabinete "nao ha nada para abrir"
            return;
        }
        divisao.fechar();
    }

    public GabineteProfessor getGabinete(){
        return gabinete;
    }

    public void GabineteProfessor setGabinete(){
        this.gabinete = gabinete;
    }

    /*public void GabineteProfessor desassociarGabinete(){
        ///////compeltar
    }*/
