package Model;
import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public  class ControladorInscripciones {
    private Alumno alumno;
    private Materia materia;
    private static ControladorInscripciones instancia;
    private ControladorInscripciones() {

    }
    public static ControladorInscripciones getInstancia() {
        if (instancia == null){
            instancia = new ControladorInscripciones();
        }
        return instancia;
    }
    public Void inscribir(int matricula, String nombre_materia ) {
        Scanner scanner = new Scanner(System.in);
        Carrera ingieneria = Carrera.getInstancia();
        ingieneria.setCargaHorariaMaximaPorCuatrimestre(50);

        Alumno alumno = obtenerAlumnoPorMatricula(matricula);
        Materia materia = obtenerMateria(nombre_materia);

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
       if (cursoSeleccionado == null){
           System.out.println("El curso seleccionado no existe, volver a realizar el proceso de inscripcion");
           return null;
       }
       System.out.print("Se te rediccionara al modulo de pagos para realizar el pago de las inscripcion\n");


       return null;
    }
    public Void getInscriptosCurso(String nombre_materia){
        Materia materia = obtenerMateria(nombre_materia);
        List<Curso> cursos = materia.getCurso();
        System.out.println("A continuacion se mostraran los inscriptos por curso para la materia " + materia.getNombre());
        for (Curso curso : cursos) {
            System.out.println("Total de inscriptos para el curso " + curso.getId() + ": " + curso.getInscriptos());
        }
        return null;

    }
    private boolean chequearCorrelativa(Alumno alumno, Materia materia){
        Materia anterior = materia.getCorrelativaAnterior();
        List<Materia> listaMateriasAprobadas  = alumno.getMateriasAprobadas();
        if (!listaMateriasAprobadas.contains(anterior)){
            System.out.println("El alumno no aprobo la correlativa anterior " + anterior.getNombre() + ", se detiene el proceso de inscripcion");
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
            int mes = fechaInscripcion.getMonth() + 1;
            System.out.println("Fecha maxima de inscripcion: " + fechaInscripcion.getDate() +"/"+mes);
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
    private Alumno obtenerAlumnoPorMatricula(int matricula){
        if (this.alumno.getMatricula() == matricula) {
            return alumno;
        }
        else {
            return null;
        }
    }
    private Materia obtenerMateria(String nombre){
        if (this.materia.getNombre() == nombre) {
           return materia;
        }
        else {
            return null;
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
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}