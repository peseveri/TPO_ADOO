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
    private int horas_mensuales;
    private int inscriptos;
    private String turno;
    private static int lastId = 0;
    public Curso(String aula, int capacidadAula, String horario, int dia, List<Docente> docente, Float precio,String turno,int horas_mensuales) {
        this.aula = aula;
        this.capacidadAula = capacidadAula;
        this.horario = horario;
        this.dia = dia;
        this.docente = docente;
        this.precio = precio;
        this.turno = turno;
        this.horas_mensuales = horas_mensuales;
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
    public String getTurno() {
        return turno;
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
    public int getHoras_mensuales() {
        return horas_mensuales;
    }
    public int getInscriptos() {
        return inscriptos;
    }
    public void setInscriptos(int inscriptos) {
        this.inscriptos = inscriptos;
    }
    public int getId() {
        return id;
    }
}