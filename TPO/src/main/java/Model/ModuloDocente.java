package Model;

/**
 * 
 */
public class ModuloDocente {
    private Docente docente;

    public ModuloDocente(Docente docente) {
        this.docente = docente;
    }

    public Void verCursos() {
        docente.verCursos();
        return null;
    }

    public Void verCronograma() {
        docente.verCronograma();
        return null;
    }

}