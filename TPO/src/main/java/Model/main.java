package Model;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        //test.verInfoMateriasParaUnaCarreraTest(); //Administración de cursos
        //test.verInfoCursosParaUnaMateriaTest(); //Administración de cursos y Inscripción a cursos
        //test.verInforCursosPorTurno(); //Administración de cursos y Inscripción a cursos
        //test.inscripcionCasoCorrelativasDesaprobadas(); //Inscripción a cursos
        //test.inscripcionCasoPasadoDiaLimiteInscripcion(); //Inscripción a cursos
        //test.cargaHorariaSuperada(); //Inscripción a cursos
        //test.inscribirse(); // Inscripción a cursos
        //test.verCursoAsignadoDocente(); //Administración docente
        //test.asignarCursoPorPreferenciaTurnoDocente(); //Programacion
        //test.asignarCursoPorPreferenciaTurnoDocenteCasoNoDisponible(); //Programacion
        //test.asignarCursoPorPreferenciaHorariaDocente(); //Programacion
        //test.asignarCursoPorPreferenciaHorariaDocenteCasoNoDisponible(); //Programacion
        //test.verCronograma(); //Administración docente
        //test.generarInforme(); //Administración docente
        //test.getHorasDocentesMensuales(); //Integracion
        //test.getInscriptosCurso(); //Integracion
    }

    //El test inscribir pide por pantalla que se mande el id de curso, se contemplo los casos en donde el curso mandado no existe.
    //Se realizaron los test de casos feos en donde el alumno no puede inscribirse, ya sea por correlativa, fecha limite o carga horaria.
    //Para correr cada test, simplemente descomentar uno por uno.

    //Para la segunda entrega se añadieron mas casos de Test y se modificaron algunos originales.
    //Test agregados: verInforCursosPorTurno(), asignarCursoPorPreferenciaTurnoDocente(), asignarCursoPorPreferenciaTurnoDocenteCasoNoDisponible()
    //                asignarCursoPorPreferenciaHorariaDocente(), asignarCursoPorPreferenciaHorariaDocenteCasoNoDisponible()
    //                getHorasDocentesMensuales(), getInscriptosCurso().

    //Test modficados: inscribirse() (multiples metodos de pago), generarInforme() (ahora genera PDF o Excel).

}