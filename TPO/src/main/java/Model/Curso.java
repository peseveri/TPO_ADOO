package Model;

import java.util.List;


public class Curso implements Comparable<Curso>{

    private int id;
    private String aula;
    private int capacidadAula;
    private String horario;

    private List<Docente> docente;
    private Float precio;

    private int dia;
    private static int lastId = 0;

    public Curso(String aula, int capacidadAula, String horario, int dia, List<Docente> docente, Float precio) {
        this.aula = aula;
        this.capacidadAula = capacidadAula;
        this.horario = horario;
        this.dia = dia;
        this.docente = docente;
        this.precio = precio;
        this.id = ++lastId;
    }
    @Override
    public int compareTo(Curso otroCurso) {
        return Integer.compare(this.dia, otroCurso.dia);
    }

    public String getAula() {
        return aula;
    }

    public int getCapacidadAula() {
        return capacidadAula;
    }

    public String getHorario() {
        return horario;
    }

    public int getDia() {
        return dia;
    }

    public List<Docente> getDocente() {
        return docente;
    }

    public Float getPrecio() {
        return precio;
    }
    public int getId() {
        return id;
    }
}