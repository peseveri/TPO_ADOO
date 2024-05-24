package Model;

import java.io.IOException;

public interface EstrategiaInforme {

    default void generarInforme(Docente docente) throws IOException {}
}
