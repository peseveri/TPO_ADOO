package Model;
import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public  class ControladorInscripciones {

    private Alumno alumno;

    private AdapterMercadoPago adaptadorMP;

    private static ControladorInscripciones instancia;

    private Docente docente;

    private AdapterPDF adaptadorPDF;

    private ControladorInscripciones() {
    }

    public Void inscribir(Alumno alumno, Materia materia ) {
        Scanner scanner = new Scanner(System.in);
        Carrera ingieneria = Carrera.getInstancia();
        ingieneria.setCargaHorariaMaximaPorCuatrimestre(50);

        if (!this.chequearCorrelativa(alumno,materia)){
            return null;
        }
       else if (!this.chequearFechaLimite(materia)){
           return null;
        }
        else if (!this.chequearCargaHoraria(ingieneria,materia)){
            return null;
        }

       System.out.println("Perfecto, ya casi estas a punto de inscribirte, a continuacion te voy a mostrar los cursos disponibles para cada materia");
       alumno.verCursos(materia);
       System.out.print("Por favor, selecciona el id de curso a inscribirse: ");
       int idCurso = scanner.nextInt();

       List<Curso> cursos = new ArrayList<>();
       Curso cursoSeleccionado = this.obtenerCursoPorId(materia,idCurso);
       System.out.print("Se te rediccionara a Mercado Pago para realizar el pago de la inscripcion \n ");
       this.abonarCuota(cursoSeleccionado);
       cursos.add(cursoSeleccionado);
       alumno.setCursoInscripto(cursos);
       scanner.close();

       System.out.println("Inscripcion correcta al curso: " + cursoSeleccionado.getId());
       alumno.setCargaHoraria(materia.getCarga_horaria());
       this.mostrarCursosInscriptos(alumno);
       return null;
    }

    public Void asignarCursoADocente(List<Curso> curso, Docente docente){
        docente.setCursos(curso);
        return null;
    }

    public static ControladorInscripciones getInstancia() {
       if (instancia == null){
           instancia = new ControladorInscripciones();
       }
        return instancia;
    }

    private Void abonarCuota(Curso curso) {
        AdapterMercadoPago adaptadorMP =  new AdapterMercadoPago();
        adaptadorMP.abonarCuota(curso);
        return null;
    }

    public Void generarInforme(Docente docente) throws IOException {
        AdapterPDF adaptadorPDF = new AdapterPDF();

        Collections.sort(docente.getCursos(), Comparator
                .comparingInt(Curso::getDia)
                .thenComparing(Curso::getHorario)
        );

        adaptadorPDF.generarInforme(docente);
        return null;
    }

    private boolean chequearCorrelativa(Alumno alumno, Materia materia){
        Materia anterior = materia.getCorrelativaAnterior();
        List<Materia> listaMateriasAprobadas  = alumno.getMateriasAprobadas();
        if (!listaMateriasAprobadas.contains(anterior)){
            System.out.println("El alumno no aprobo la correlativa anterior, se detiene el proceso de inscripcion");
            return false;
        }
        else{
            System.out.println("El alumno aprobo la correlativa anterior, ahora se verificara la fecha limite");
            return  true;
        }
    }

    private boolean chequearFechaLimite(Materia materia){
        Date fechaActual = new Date();
        Date fechaInscripcion = materia.getUltimoDiaInscripcion();

        if (fechaActual.getMonth() > fechaInscripcion.getMonth() || (fechaActual.getMonth() == fechaInscripcion.getMonth() && fechaActual.getDate() > fechaInscripcion.getDate())){
            System.out.println("Fecha maxima de inscripcion: " + fechaInscripcion );
            System.out.println("No se puede llevar a cabo el proceso ya que ya paso la fecha limite, se detiene el proceso de inscripcion");
            return false;
        }
        else{
            System.out.println("Fecha maxima de inscripcion: " + fechaInscripcion );
            System.out.println("Todavia esta a tiempo de inscribirse para la materia " + materia.getNombre());
            return true;
        }
    }

    private boolean chequearCargaHoraria(Carrera carrera, Materia materia){
        if (materia.getCarga_horaria()> carrera.getCargaHorariaMaximaPorCuatrimestre()){
            System.out.println("La materia supera la carga horaria maxima estipulada por la carrera, se detiene el proceso de inscripcion");
            return false;
        }
        else{
            System.out.println("Tenes " + materia.getCarga_horaria() + " horas de clase de " + carrera.getCargaHorariaMaximaPorCuatrimestre() + " disponibles");
            return true;
        }
    }
    private Curso obtenerCursoPorId(Materia materia, int id){
        for (int i = 0; i < materia.getCurso().size(); i++) {
            Curso curso = materia.getCurso().get(i);
            if (curso.getId() == id){
                return curso;
            }
        }
        return null;
    }

    private void mostrarCursosInscriptos(Alumno alumno){
        for (int i = 0; i < alumno.getCursoInscripto().size(); i++) {
            Curso curso = alumno.getCursoInscripto().get(i);
            String mensaje = String.format("ID Curso: %d, Aula: %s , Capacidad: %s, Horario: %s, Precio: %.2f $", curso.getId(), curso.getAula(), curso.getCapacidadAula(), curso.getHorario(), curso.getPrecio());
            System.out.println(mensaje);
        }
    }
}