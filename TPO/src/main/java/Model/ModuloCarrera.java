package Model;

import java.util.List;

/**
 * 
 */
public class ModuloCarrera {

    private Carrera carrera;
    public ModuloCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    public List<Materia> getMaterias() {
        return carrera.getMaterias();
    }


    public void agregarMateria(Materia materia) {

    }

}