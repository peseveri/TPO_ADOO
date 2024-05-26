package Model;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ControladorDocente {
    private Docente docente;
    private List<Curso> cursos;
    private static ControladorDocente instancia;
    private EstrategiaInforme estrategiaInforme;
    private ControladorDocente() {

    }
    public static ControladorDocente getInstancia() {
        if (instancia == null){
            instancia = new ControladorDocente();
        }
        return instancia;
    }
    public Void asignarCursoADocente(String nombre, int idcurso){
        Docente docente = obtenerDocente(nombre);
        Curso curso = obtenerCursoPorId(idcurso);
        docente.setCursos(curso);
        return null;
    }

    public Void asignarCursoADocentePorPreferenciaTurno(String nombre, int idcurso){
        Docente docente = obtenerDocente(nombre);
        Curso curso = obtenerCursoPorId(idcurso);

        if (curso.getTurno().equalsIgnoreCase(docente.getTurnoPreferido())){
            docente.setCursos(curso);
        }
        else{
            System.out.println("No se pudo asignar el curso "  + curso.getId() + " ya que el docente no se encuentra disponible en el turno " + curso.getTurno() );
        }
        return null;
    }

    public Void asignarCursoADocentePorPreferenciaHoraria(String nombre, int idcurso){
        Docente docente = obtenerDocente(nombre);
        Curso curso = obtenerCursoPorId(idcurso);

        if (curso.getHorario().equalsIgnoreCase(docente.getHorarioPreferido())){
            docente.setCursos(curso);
        }
        else{
            System.out.println("No se pudo asignar el curso "  + curso.getId() + " ya que el docente no se encuentra disponible en el horario de " + curso.getHorario() );
        }
        return null;
    }
    public Void generarInforme(String nombre) throws IOException {
        Scanner scanner = new Scanner(System.in);
        EstrategiaInforme pdf = new Pdf();
        setEstrategiaInforme(pdf);

        Docente docente = obtenerDocente(nombre);
        Collections.sort(docente.getCursos(), Comparator
                .comparingInt(Curso::getDia)
                .thenComparing(Curso::getHorario)
        );

        System.out.print("Por predeterminado el informe se realizara en formato PDF, pero puede cambiarlo a Excel\n");
        System.out.print("Seleccione 1 para usar Excel o 0 para seguir con el formato PDF\n");
        int tipoInforme = scanner.nextInt();

        switch (tipoInforme) {
            case 1:
                EstrategiaInforme excel = new Excel();
                setEstrategiaInforme(excel);
                excel.generarInforme(docente);
                break;
            case 0:
                pdf.generarInforme(docente);
                break;
        }
        scanner.close();
        return null;
    }
    public int getHorasAsignadasMensualmente (String nombre){
        Docente docente = obtenerDocente(nombre);
        return docente.getHorasAsignadas();
    }
    private Docente obtenerDocente(String nombre){
        if (this.docente.getNombre() == nombre) {
            return docente;
        }
        else {
            return null;
        }
    }
    private Curso obtenerCursoPorId(int id) {
        for (Curso curso : this.cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }
    private void setEstrategiaInforme(EstrategiaInforme estrategiaInforme) {
        this.estrategiaInforme = estrategiaInforme;
    }
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
