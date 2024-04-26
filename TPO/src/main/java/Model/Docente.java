package Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */
public class Docente {

    private String nombre;
    private List<Curso> cursos;

    public Docente(String nombre, List<Curso> cursos) {
        this.nombre = nombre;
        this.cursos = cursos;
    }

    public Void verCursos() {
        System.out.println("Hola docente " + this.nombre + "! a continuacion veras los cursos en donde estas asignado");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            String mensaje = String.format("ID Curso: %d, Aula: %s , Capacidad: %s, Horario: %s ", curso.getId(), curso.getAula(), curso.getCapacidadAula(), curso.getHorario());
            System.out.println(mensaje);
        }
        return null;
    }


    public Void verCronograma() {
        List<Curso> cursos = this.getCursos();
        Collections.sort(cursos, Comparator
                .comparingInt(Curso::getDia)
                .thenComparing(Curso::getHorario)
        );
        System.out.println("Hola docente " + this.nombre + "! a continuacion veras tu cronograma semanal");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            String dia = "";
            if (curso.getDia() == 1){
                dia = "Lunes";
            }
            if (curso.getDia() == 2){
                dia = "Martes";
            }
            if (curso.getDia() == 3){
                dia = "Miercoles";
            }
            if (curso.getDia() == 4){
                dia = "Jueves";
            }
            if (curso.getDia() == 5){
                dia = "Viernes";
            }
            String mensaje = String.format("Dia: %s, Curso: %d, Aula: %s , Horario: %s ", dia,curso.getId(), curso.getAula(), curso.getHorario());
            System.out.println(mensaje);
        }
        return null;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}