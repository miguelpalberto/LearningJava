package modelo;

import java.util.LinkedList;

public class Aula extends Identificador {
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;
    private Sala sala;


    public Aula(String nome, long numero, Horario horario, Sala sala) {
        this(nome, numero, horario, null, new LinkedList<>(), sala);
    }

    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos, Sala sala) {
        super(nome,numero);
        this.horario = horario;
        setProfessor(professor);
        sumario = new StringBuilder();
        //this.professor = professor;
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
       setSala(sala);
    }



    public void adicionar(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno) ) {
            return;
        }
        alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno) {
        if (aluno == null || !alunos.contains(aluno)) {
            return;
        }
        alunos.remove(aluno);
        aluno.remover(this);
    }

    public void adicionarLinhaSumario(String linha) {
        if (linha == null) {
            return;
        }
        sumario.append(linha).append('\n');
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null || this.professor == professor) {
            return;
        }
        if (this.professor != null) {
            this.professor.remover(this);
        }

        this.professor = professor;
        professor.adicionar(this);
    }

    public void  desassociarProfessor() {
        if (professor == null) {
            return;
        }

        Professor professorARemover = professor;
        professor = null;
        professorARemover.remover(this);
    }

    public String getSumario() {
        return sumario.toString();
    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    }

    public Horario getHorario() {
        return horario;
    }


    public boolean isSobre(Horario horario){
        return this.horario.isSobre(horario);
    }

    public boolean isSobre(Aula aula) {
        return isSobre(aula.horario);
    }

    public Sala getSala() {///////////devolver sala como pedido
        return sala;
    }

    public void setSala(Sala sala) {
        if (sala == null || this.sala == sala) {
            return;
        }
        if (this.sala != null) {
            this.sala.remover(this);
        }

        sala.adicionar(this);
        this.sala = sala;
    }

    public void desassociarSala() {
        if (sala == null) {
            return;
        }
        Sala salaARemover = sala;
        this.sala = null;
        salaARemover.remover(this);

    }

    @Override
    public String toString() {
        return super.toString() + " Aula{" +
                "sumario=" + sumario +
                ", professor=" + professor +
                ", alunos=" + alunos +
                ", horario=" + horario +
                ", sala=" + sala +
                '}';
    }
}
