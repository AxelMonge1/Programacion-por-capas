package daos;

import java.util.List;
import models.Activista;

/**
 *
 * @author axelm
 */
public interface IActivistaDAO {
    boolean insertar(Activista activista);
    Activista obtenerPorId(int idActivista);
    List<Activista> obtenerTodos();
    boolean actualizar(Activista activista);
    boolean eliminar(int idActivista);
}
