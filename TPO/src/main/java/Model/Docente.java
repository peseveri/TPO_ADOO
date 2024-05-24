package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */
public class Docente {
    private String nombre;
    private List<Curso> cursos;
    private String horarioPreferido;
    private String turnoPreferido;

    private int horasAsignadas;

    public Docente(String nombre, List<Curso> cursos, String horarioPreferido, String turnoPreferido, int horasAsignadas ) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
        this.horarioPreferido = horarioPreferido;
        this.turnoPreferido = turnoPreferido;
        this.horasAsignadas = horasAsignadas;
    }

    public Void verCursos() {
        System.out.println("Hola docente " + this.nombre + "! a continuacion veras los cursos en donde estas asignado");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            String mensaje = String.format(" Curso: %d, Aula: %s , Horario: %s , Turno: %s", curso.getId(), curso.getAula(), curso.getHorario(), curso.getTurno());
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
            int diaSemana = curso.getDia();
            switch (diaSemana) {
                case 1:
                    dia = "Lunes";
                    break;
                case 2:
                    dia = "Martes";
                    break;
                case 3:
                    dia = "Miercoles";
                    break;
                case 4:
                    dia = "Jueves";
                    break;
                case 5:
                    dia = "Viernes";
                    break;
            }
            String mensaje = String.format("Dia: %s, Curso: %d, Aula: %s , Horario: %s , Turno: %s", dia, curso.getId(), curso.getAula(), curso.getHorario(), curso.getTurno());
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

    public String getHorarioPreferido() {
        return horarioPreferido;
    }

    public String getTurnoPreferido() {
        return turnoPreferido;
    }

    public void setCursos(Curso curso) {
        if (curso != null) {
            this.cursos.add(curso);
        }
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }
}