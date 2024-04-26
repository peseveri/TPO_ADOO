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

}