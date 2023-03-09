    package modelo;

    import java.util.LinkedList;

    public class Sala extends Divisao implements RepositorioAulas, AssociavelAulas {

        private GestorAulas gestorAulas;

        public Sala(String nome, boolean portaAberta) {
            super(nome, portaAberta);
            gestorAulas = new GestorAulas(this);
        }



    @Override
    public LinkedList<Aula> getAulas() {
            return gestorAulas.getAulas();
        }
      @Override
      public LinkedList<Aula> getAulas(Horario horario) {
          return gestorAulas.getAulas(horario);
     }

    @Override
    public void adicionar(Aula aula){
        gestorAulas.adicionar(aula);
    }

    @Override
    public void remover(Aula aula){
        gestorAulas.remover(aula);
    }

    public boolean contem(Aula aula) {
        return gestorAulas.contem(aula);
    }

    @Override
    public void associar(Aula aula){
            aula.setSala(this);
    }
    @Override
    public void desassociar(Aula aula){
            aula.desassociarSala();
    }


    }






//////////////////
    /*CODIGO PARA CLASSE DIVISAO:
        public void abrir(){
        portaAberta = true;
        }

        public void fechar(){
        portaAberta = false;
        }
        //estado da porta (?) (alinea a)
        public boolean isPortaAberta(){
        return portaAberta;
        }
 ////////////
 //Tirado com gestor:

    public LinkedList<Aula> getAulas() {return new LinkedList<Aula>;}

     public void adicionarAula(Aula aula){
        gestorAulas.adicionar(aula);                //delegacao completa porque tudo fica para este
            if(aula==null || aulas.contains(aula)){
                return;
            }
            aulas.add(aula);
            aula.associarSala(this);                        //associar(aula); alteracao desta linha para: (alinea b)
    }

    protected abstract void associar(Aula aula);

    public void removerAula(Aula aula){
            gestorAulas.remover(aula);              //delegacao completa porque tudo fica para este
            if(aula == null || !aulas.contains(aula)){
                return;
            }
            aulas.remove(aula);
            aula.desassociarSala();                     //desassociar(aula);///alterar este para: (alinea b)
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

*/