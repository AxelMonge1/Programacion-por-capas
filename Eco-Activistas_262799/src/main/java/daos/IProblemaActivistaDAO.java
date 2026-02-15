package daos;

import java.util.List;
import models.ProblemaActivista;

/**
 *
 * @author axelm
 */
public interface IProblemaActivistaDAO {
    boolean insertar(ProblemaActivista relacion);
    List<ProblemaActivista> obtenerPorProblema(int idProblema);
    List<ProblemaActivista> obtenerPorActivista(int idActivista);
    boolean eliminar(int idProblema, int idActivista);
}
