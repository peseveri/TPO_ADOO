package Model;

import java.io.IOException;
import java.util.*;

public class test {

    public static void verInfoMateriasParaUnaCarreraTest(){
        // Given
        Materia fundamentos_informatica = new Materia("Fundamentos de informatica",30,null,null,null,null);
        Materia programacion = new Materia("Programacion",20,null,null,null,null);
        Materia programacionII = new Materia("Programacion II",25,null,null,null,null);
        Materia Poo = new Materia("Programacion Orientado a Objetos",40,null,null,null,null);
        Materia Adoo = new Materia("Proceso de Desarrollo de Software",30,null,null,null,null);

        List<Materia> materias = new ArrayList<>();
        materias.add(fundamentos_informatica);
        materias.add(programacion);
        materias.add(programacionII);
        materias.add(Poo);
        materias.add(Adoo);

        fundamentos_informatica.setCorrelativaPosterior(materias.get(1));
        programacion.setCorrelativaAnterior(materias.get(0));
        programacion.setCorrelativaPosterior(materias.get(2));
        programacionII.setCorrelativaAnterior(materias.get(1));
        Poo.setCorrelativaPosterior(materias.get(4));
        Adoo.setCorrelativaAnterior(materias.get(3));

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
        Docente juan = new Docente("juan",null,null,null,0);
        Docente carlos  = new Docente("carlos",null,null,null, 0);
        Docente lucia  = new Docente("lucia",null,null,null, 0);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(juan);
        docentes.add(carlos);

        List<Docente> docentes2 = new ArrayList<>();
        docentes2.add(juan);
        docentes2.add(lucia);

        Curso curso1 = new Curso("Aula magna",65,"7:45 a 10",2,docentes,450F,"mañana", 0);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes2, 150F,"mañana", 0);
        Curso curso3 = new Curso("Aula 45",21,"14 a 16",1,docentes, 100F,"tarde", 0);
        Curso curso4 = new Curso("Aula Sur",45,"15 a 17",1,docentes2, 90F,"tarde", 0);
        Curso curso5 = new Curso("Aula 34",80,"18:30 a 20:30",1,docentes, 350F,"noche", 0);
        Curso curso6 = new Curso("Aula 86",70,"20 a 22",1,docentes2, 250F,"noche", 0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);


        Materia materia = new Materia("Fundamentos de informatica",30,null,null,cursos,null);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");

        ModuloAlumno alumnoFacade = new ModuloAlumno(alumno);
        alumnoFacade.verCursos(materia);
    }

    public static void verInforCursosPorTurno(){
        Docente juan = new Docente("juan",null,null,null,0);
        Docente carlos  = new Docente("carlos",null,null,null,0);
        Docente lucia  = new Docente("lucia",null,null,null,0);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(juan);
        docentes.add(carlos);

        List<Docente> docentes2 = new ArrayList<>();
        docentes2.add(juan);
        docentes2.add(lucia);

        Curso curso1 = new Curso("Aula magna",65,"7:45 a 10",2,docentes,450F,"mañana",0);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes2, 150F,"mañana",0);
        Curso curso3 = new Curso("Aula 45",21,"14 a 16",1,docentes, 100F,"tarde",0);
        Curso curso4 = new Curso("Aula Sur",45,"15 a 17",1,docentes2, 90F,"tarde",0);
        Curso curso5 = new Curso("Aula 34",80,"18:30 a 20:30",1,docentes, 350F,"noche",0);
        Curso curso6 = new Curso("Aula 86",70,"20 a 22",1,docentes2, 250F,"noche",0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);

        Materia materia = new Materia("Fundamentos de informatica",30,null,null,cursos,null);

        Alumno alumno = Alumno.getInstancia();
        alumno.setNombre("Leo");

        ModuloAlumno alumnoFacade = new ModuloAlumno(alumno);
        alumnoFacade.verCursosPorTurno(materia,"noche");
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
        controlador.setAlumno(alumno);
        controlador.setMateria(programacion);
        controlador.inscribir(alumno.getMatricula(),programacion.getNombre());

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
        controlador.setAlumno(alumno);
        controlador.setMateria(programacion);
        controlador.inscribir(alumno.getMatricula(),programacion.getNombre());
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
        controlador.setAlumno(alumno);
        controlador.setMateria(programacion);
        controlador.inscribir(alumno.getMatricula(),programacion.getNombre());
    }
    public static void inscribirse(){

        Docente juan = new Docente("juan",null,null,null,0);
        Docente carlos  = new Docente("carlos",null,null,null,0);
        Docente lucia  = new Docente("lucia",null,null,null,0);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(juan);
        docentes.add(carlos);

        List<Docente> docentes2 = new ArrayList<>();
        docentes2.add(juan);
        docentes2.add(lucia);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,docentes,450F,"mañana",0);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes2, 150F,"mañana",0);

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
        controlador.setAlumno(alumno);
        controlador.setMateria(programacion);
        controlador.inscribir(alumno.getMatricula(),programacion.getNombre());

        ControladorPagos controladorPagos = ControladorPagos.getInstancia();
        controladorPagos.abonarCuota();
    }
    public static void verCursoAsignadoDocente(){
        ControladorDocente controlador = ControladorDocente.getInstancia();
        Docente docente = new Docente("juan",null,null,null,0);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,docentes,450F,"mañana",0);
        Curso curso2 = new Curso("Aula 234",65,"9 a 11",1,docentes, 150F,"mañana",0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);

        controlador.setDocente(docente);
        controlador.setCursos(cursos);
        controlador.asignarCursoADocente("juan",1);
        controlador.asignarCursoADocente("juan",2);
        docenteFacade.verCursos();

    }

    public static void asignarCursoPorPreferenciaTurnoDocente(){
        ControladorDocente controlador = ControladorDocente.getInstancia();
        Docente docente = new Docente("juan",null,null,"tarde",0);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula 234",65,"14 a 17",1,docentes, 150F,"tarde",0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);

        System.out.println("Se te asignara un curso que cumpla con tu preferencia de turno " + docente.getTurnoPreferido());
        controlador.setDocente(docente);
        controlador.setCursos(cursos);
        controlador.asignarCursoADocentePorPreferenciaTurno("juan",1);
        docenteFacade.verCursos();
    }

    public static void asignarCursoPorPreferenciaTurnoDocenteCasoNoDisponible(){
        ControladorDocente controlador = ControladorDocente.getInstancia();
        Docente docente = new Docente("juan",null,null,"tarde",0);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,docentes,450F,"mañana",0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);

        System.out.println("Se te asignara un curso que cumpla con tu preferencia de turno " + docente.getTurnoPreferido());
        controlador.setDocente(docente);
        controlador.setCursos(cursos);
        controlador.asignarCursoADocentePorPreferenciaTurno("juan",1);

    }

    public  static void asignarCursoPorPreferenciaHorariaDocente(){
        ControladorDocente controlador = ControladorDocente.getInstancia();
        Docente docente = new Docente("juan",null,"9 a 11",null,0);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula 234",65,"9 a 11",1,docentes, 150F,"mañana",0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);

        System.out.println("Se te asignara un curso que cumpla con tu preferencia horaria de " + docente.getHorarioPreferido());
        controlador.setDocente(docente);
        controlador.setCursos(cursos);
        controlador.asignarCursoADocentePorPreferenciaHoraria("juan",1);
        docenteFacade.verCursos();
    }

    public  static void asignarCursoPorPreferenciaHorariaDocenteCasoNoDisponible(){
        ControladorDocente controlador = ControladorDocente.getInstancia();
        Docente docente = new Docente("juan",null,"9 a 11",null,0);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula 234",65,"15 a 17:30",1,docentes, 150F,"tarde",0);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);

        System.out.println("Se te asignara un curso que cumpla con tu preferencia horaria de " + docente.getHorarioPreferido());
        controlador.setDocente(docente);
        controlador.setCursos(cursos);
        controlador.asignarCursoADocentePorPreferenciaHoraria("juan",1);
    }
    public static void verCronograma(){
        Docente docente = new Docente("Joaquin",null,null,null,0);
        ModuloDocente docenteFacade = new ModuloDocente(docente);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"18 a 22",5,docentes, null,"noche",0);
        Curso curso2 = new Curso("Aula este",25,"15 a 19",4,docentes, null,"tarde",0);
        Curso curso3 = new Curso("Aula sur",15,"09 a 11",3,docentes, null,"mañana",0);
        Curso curso4 = new Curso("Aula campus",40,"10 a 13",5,docentes, null,"mañana",0);
        Curso curso5 = new Curso("Aula norte",80,"08 a 12",1,docentes, null,"mañana",0);

        docente.setCursos(curso1);
        docente.setCursos(curso2);
        docente.setCursos(curso3);
        docente.setCursos(curso4);
        docente.setCursos(curso5);

        docenteFacade.verCronograma();





    }
    public static void generarInforme() throws IOException {
        ControladorDocente controlador = ControladorDocente.getInstancia();
        Docente docente = new Docente("Maria",null,null,null,0);

        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula magna",65,"18 a 22",5,docentes, null,"noche",0);
        Curso curso2 = new Curso("Aula este",25,"15 a 19",4,docentes, null,"tarde",0);
        Curso curso3 = new Curso("Aula sur",15,"09 a 11",3,docentes, null,"mañana",0);
        Curso curso4 = new Curso("Aula campus",40,"10 a 13",5,docentes, null,"mañana",0);
        Curso curso5 = new Curso("Aula norte",80,"08 a 12",1,docentes, null,"mañana",0);

        docente.setCursos(curso1);
        docente.setCursos(curso2);
        docente.setCursos(curso3);
        docente.setCursos(curso4);
        docente.setCursos(curso5);

        controlador.setDocente(docente);
        controlador.generarInforme("Maria");


    }

    public static void getHorasDocentesMensuales(){
        ControladorDocente controlador = ControladorDocente.getInstancia();
        ModuloIntegracion integracionFacade = new ModuloIntegracion(controlador,null);

        Docente docente = new Docente("juan",null,"9 a 11",null,0);
        List<Docente> docentes = new ArrayList<>();
        docentes.add(docente);

        Curso curso1 = new Curso("Aula 234",65,"15 a 17:30",1,docentes, 150F,"tarde",10);
        Curso curso2 = new Curso("Aula 29",35,"09 a 12:30",3,docentes, 450F,"mañana",14);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);

        docente.setHorasAsignadas(curso1.getHoras_mensuales() + curso2.getHoras_mensuales());
        controlador.setDocente(docente);

        int horas_mensuales = integracionFacade.getHorasAsignadasMensualmente("juan");

        System.out.println("A continuacion de mostraran las horas asignadas mensualmente para el docente " + docente.getNombre() +"\n");
        System.out.println("Horas asignadas mensuales: " + horas_mensuales);

    }

    public static void getInscriptosCurso(){

        ControladorInscripciones controlador = ControladorInscripciones.getInstancia();
        ModuloIntegracion integracionFacade = new ModuloIntegracion(null,controlador);

        Curso curso1 = new Curso("Aula magna",65,"10 a 13",2,null,450F,"mañana",20);
        Curso curso2 = new Curso("Aula 234",65,"14 a 17",1,null, 500F,"tarde",15);
        Curso curso3 = new Curso("Aula 212",65,"20 a 22",4,null, 150F,"noche",18);
        Curso curso4 = new Curso("Aula 231",65,"9 a 11",3,null, 2500F,"mañana",12);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);

        curso1.setInscriptos(43);
        curso2.setInscriptos(23);
        curso3.setInscriptos(61);
        curso4.setInscriptos(50);

        Materia fundamentos_de_informatica = new Materia("Fundamentos de informatica",30,null,null,cursos,null);

        controlador.setMateria(fundamentos_de_informatica);
        integracionFacade.getInscriptosCurso("Fundamentos de informatica");



    }
}





