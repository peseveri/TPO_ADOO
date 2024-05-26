package Model;

public class ModuloIntegracion {
    private ControladorDocente docente;
    private ControladorInscripciones inscripcion;
    public ModuloIntegracion(ControladorDocente docente, ControladorInscripciones inscripcion) {
        this.docente = docente;
        this.inscripcion = inscripcion;
    }
    public int getHorasAsignadasMensualmente(String nombre){
        return docente.getHorasAsignadasMensualmente(nombre);
    }
    public Void getInscriptosCurso(String materia){
        return inscripcion.getInscriptosCurso(materia);
    }
}
