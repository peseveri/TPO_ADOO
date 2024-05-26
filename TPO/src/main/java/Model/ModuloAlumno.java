package Model;

/**
 * 
 */
public class ModuloAlumno {
    private Alumno alumno;
    public ModuloAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Void verCursos(Materia materia) {
        return alumno.verCursos(materia) ;
    }
    public Void verCursosPorTurno(Materia materia, String turno) {
        return alumno.verCursosPorTurno(materia,turno) ;
    }

}