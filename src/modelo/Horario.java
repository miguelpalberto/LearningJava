package modelo;

public class Horario {
    private DiaSemana diaSemana;
    private int horaInicio;
    private int duracao;

    public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario) {
        return diaSemana == horario.diaSemana &&
                horaInicio + duracao > horario.horaInicio &&
                horario.horaInicio + horario.duracao > horaInicio;
    }

    @Override
    public String toString() {                          //ultimo ex - fiz sozinho - rever
        return diaSemana + " " + horaInicio + "h - " + (horaInicio + duracao) + "h";
    }
}
