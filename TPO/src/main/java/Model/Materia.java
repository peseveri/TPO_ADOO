package Model;

import java.util.Date;
import java.util.List;


public class Materia {
    private String nombre;
    private int carga_horaria;
    private Materia correlativaPosterior;
    private Materia correlativaAnterior;
    private List<Curso> curso;
    private Date ultimoDiaInscripcion;


    public Materia(String nombre, int carga_horaria, Materia correlativaPosterior, Materia correlativaAnterior, List<Curso> curso, Date ultimoDiaInscripcion) {
        this.nombre = nombre;
        this.carga_horaria = carga_horaria;
        this.correlativaPosterior = correlativaPosterior;
        this.correlativaAnterior = correlativaAnterior;
        this.curso = curso;
        this.ultimoDiaInscripcion = ultimoDiaInscripcion;
    }

    public Materia getCorrelativaPosterior() {
        if (correlativaPosterior == null){
            correlativaPosterior = new Materia("No tiene correlativa",0,null,null,null,null);
        }
        return correlativaPosterior;
    }

    public void setCorrelativaPosterior(Materia correlativaPosterior) {
        this.correlativaPosterior = correlativaPosterior;
    }

    public Materia getCorrelativaAnterior() {
        if (correlativaAnterior == null){
           correlativaAnterior = new Materia("No tiene correlativa",0,null,null,null,null);
        }
        return correlativaAnterior;
    }

    public void setCorrelativaAnterior(Materia correlativaAnterior) {
        this.correlativaAnterior = correlativaAnterior;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public Date getUltimoDiaInscripcion() {
        return ultimoDiaInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}