package Model;

import java.io.IOException;
import java.util.*;

public class test {
    public static void verInfoMateriasParaUnaCarreraTest(){
        // Given
        Materia fundamentos_informatica = new Materia("Fundamentos de informatica",30,null,null,null,null);
        Materia programacion = new Materia("Programacion",20,null,null,null,null);
        Materia programacionII = new Materia("Programacion II",25,null,null,null,null);

        List<Materia> materias = new ArrayList<>();
        materias.add(fundamentos_informatica);
        materias.add(programacion);
        materias.add(programacionII);

        fundamentos_informatica.setCorrelativaPosterior(materias.get(1));
        programacion.setCorrelativaAnterior(materias.get(0));
        programacion.setCorrelativaPosterior(materias.get(2));
        programacionII.setCorrelativaAnterior(materias.get(1));

        Carrera ingieneria = Carrera.getInstancia();
        ingieneria.setNombre("Ingieneria en Informatica");
        ingieneria.setMaterias(materias);

        //when
        ModuloCarrera carreraFacade = new ModuloCarrera(ingieneria);
        System.out.println("Carrera: " + ingieneria.getNombre());
        System.out.println("Materias disponibles para la carrera:");

        //then
        for(int i = 0; i < carreraFacade.getMaterias().size(); i++) {
            Materia materia = carreraFacade.getMaterias().get(i);
            String mensaje = String.format("%s, Carga horaria: %d, Correlativas anteriores: %s, Correlativas posteriores: %s",materia.getNombre(),materia.getCarga_horaria(),materia.getCorrelativaAnterior().getNombre(),materia.getCorrelativaPosterior().getNombre());
            System.out.println(mensaje);
        }
    }
    public static void verInfoCursosParaUnaMateriaTest(){
        Docente juan = new Docente("juan",null);
        Docente carlos  = new Docente("carlos",null);
        Docente lucia  = new Docente("lucia",null);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(juan);
        docentes.add(carlos);

        List<Docente> docentes2 = new ArrayList<>();
        docentes2.add(juan);
        docentes2.add(lucia);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,docentes,450F);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes2, 150F);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);


        Materia materia = new Materia("Fundamentos de informatica",30,null,null,cursos,null);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");

        ModuloAlumno alumnoFacade = new ModuloAlumno(alumno);
        alumnoFacade.verCursos(materia);
    }
    public static void inscripcionCasoCorrelativasDesaprobadas() {
        Materia fundamentos_de_informatica = new Materia("Fundamentos de informatica",30,null,null,null,null);
        List<Materia> materias = new ArrayList<>();
        materias.add(fundamentos_de_informatica);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");

        Date fechaDeInscripcion = new Date();
        fechaDeInscripcion.setMonth(3);
        fechaDeInscripcion.setDate(10);
        Materia programacion = new Materia("Programacion",20,null,fundamentos_de_informatica,null,fechaDeInscripcion);

        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        controlador.inscribir(alumno,programacion);

    }
    public static void inscripcionCasoPasadoDiaLimiteInscripcion(){
        Materia fundamentos_de_informatica = new Materia("Fundamentos de informatica",30,null,null,null,null);
        List<Materia> materias = new ArrayList<>();
        materias.add(fundamentos_de_informatica);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");
        alumno.setMateriasAprobadas(materias);

        Date fechaDeInscripcion = new Date();
        fechaDeInscripcion.setMonth(3);
        fechaDeInscripcion.setDate(22);
        Materia programacion = new Materia("Programacion",20,null,fundamentos_de_informatica,null,fechaDeInscripcion);

        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        controlador.inscribir(alumno,programacion);
    }
    public static void cargaHorariaSuperada(){

        Materia fundamentos_de_informatica = new Materia("Fundamentos de informatica",30,null,null,null,null);
        List<Materia> materias = new ArrayList<>();
        materias.add(fundamentos_de_informatica);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");
        alumno.setMateriasAprobadas(materias);

        Date fechaDeInscripcion = new Date();
        fechaDeInscripcion.setMonth(10);
        fechaDeInscripcion.setDate(22);
        Materia programacion = new Materia("Programacion",200,null,fundamentos_de_informatica,null,fechaDeInscripcion);

        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        controlador.inscribir(alumno,programacion);
    }
    public static void inscribirse(){

        Docente juan = new Docente("juan",null);
        Docente carlos  = new Docente("carlos",null);
        Docente lucia  = new Docente("lucia",null);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(juan);
        docentes.add(carlos);

        List<Docente> docentes2 = new ArrayList<>();
        docentes2.add(juan);
        docentes2.add(lucia);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,docentes,450F);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes2, 150F);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);

        Materia fundamentos_de_informatica = new Materia("Fundamentos de informatica",30,null,null,null,null);
        List<Materia> materias = new ArrayList<>();
        materias.add(fundamentos_de_informatica);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");
        alumno.setMateriasAprobadas(materias);

        Date fechaDeInscripcion = new Date();
        fechaDeInscripcion.setMonth(10);
        fechaDeInscripcion.setDate(22);
        Materia programacion = new Materia("Programacion",20,null,fundamentos_de_informatica,cursos,fechaDeInscripcion);

        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        controlador.inscribir(alumno,programacion);
    }
    public static void verCursoAsignadoDocente(){
        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        Docente docente = new Docente("juan",null);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,docentes,450F);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes, 150F);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);

        controlador.asignarCursoADocente(cursos,docente);

        docenteFacade.verCursos();

    }
    public static void verCronograma(){
        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        Docente docente = new Docente("Joaquin",null);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"18 a 22",5,docentes, null);
        Curso curso2 = new Curso("Aula este",25,"15 a 19",4,docentes, null);
        Curso curso3 = new Curso("Aula sur",15,"09 a 11",3,docentes, null);
        Curso curso4 = new Curso("Aula campus",40,"10 a 13",5,docentes, null);
        Curso curso5 = new Curso("Aula norte",80,"08 a 12",1,docentes, null);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);

        controlador.asignarCursoADocente(cursos,docente);
        docenteFacade.verCronograma();

    }
    public static void generarInformePDF() throws IOException {
        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        Docente docente = new Docente("Maria",null);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"18 a 22",5,docentes, null);
        Curso curso2 = new Curso("Aula este",25,"15 a 19",4,docentes, null);
        Curso curso3 = new Curso("Aula sur",15,"09 a 11",3,docentes, null);
        Curso curso4 = new Curso("Aula campus",40,"10 a 13",5,docentes, null);
        Curso curso5 = new Curso("Aula norte",80,"08 a 12",1,docentes, null);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);

        controlador.asignarCursoADocente(cursos,docente);

        controlador.generarInforme(docente);
    }
}





