package Model;

import java.util.ArrayList;
import java.util.List;


public class Alumno {
    private String nombre;
    private int matricula;
    private List<Curso> cursoInscripto;
    private static Alumno instancia;
    private List<Materia> materiasAprobadas;
    private Carrera carrera;
    private int cargaHoraria;
    private Alumno(String nombre, int matricula, Carrera carrera, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.materiasAprobadas = new ArrayList();
    }

    public static Alumno getInstancia() {
        if (instancia == null){

            instancia = new Alumno(null,0,null,new ArrayList<>());
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getCursoInscripto() {
        return cursoInscripto;
    }

    public void setCursoInscripto(List<Curso> cursoInscripto) {
        this.cursoInscripto = cursoInscripto;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Void verCursos(Materia materia) {
        System.out.println("Hola " + this.nombre + "! a continuacion veras los cursos disponibles para " + materia.getNombre());
        for (int i = 0; i < materia.getCurso().size(); i++) {
            Curso curso = materia.getCurso().get(i);
            List<Docente> docente = curso.getDocente();
            String mensaje = String.format("ID Curso: %d, Aula: %s , Capacidad: %s, Horario: %s, Precio: %.2f $", curso.getId(), curso.getAula(), curso.getCapacidadAula(), curso.getHorario(), curso.getPrecio());
            System.out.println(mensaje);
            for (int j = 0; j < docente.size(); j++) {
                System.out.println("Docente asignado: " + docente.get(j).getNombre());
            }
        }
        return null;
    }
}