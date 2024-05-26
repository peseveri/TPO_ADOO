package Model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private static Carrera instancia;
    private List<Materia> materias;
    private String nombre;
    private int cargaHorariaMaximaPorCuatrimestre;
    private Carrera(List<Materia> materias, String nombre, int cargaHorariaMaximaPorCuatrimestre) {
        this.materias = materias;
        this.nombre = nombre;
        this.cargaHorariaMaximaPorCuatrimestre = cargaHorariaMaximaPorCuatrimestre;
    }
    public static Carrera getInstancia(){
        if (instancia == null){

            instancia = new Carrera(new ArrayList<>(), "NombrePorDefecto", 0);
        }
        return instancia;
    }
    public List<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCargaHorariaMaximaPorCuatrimestre() {
        return cargaHorariaMaximaPorCuatrimestre;
    }
    public void setCargaHorariaMaximaPorCuatrimestre(int cargaHorariaMaximaPorCuatrimestre) {
        this.cargaHorariaMaximaPorCuatrimestre = cargaHorariaMaximaPorCuatrimestre;
    }
}
