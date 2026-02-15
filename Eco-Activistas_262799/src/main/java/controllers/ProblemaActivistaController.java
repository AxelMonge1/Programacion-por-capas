package controllers;

import daos.IProblemaActivistaDAO;
import daos.ProblemaActivistaDAO;
import java.util.List;
import models.ProblemaActivista;

/**
 *
 * @author axelm
 */
public class ProblemaActivistaController {
    private final IProblemaActivistaDAO paDAO;
    
    public ProblemaActivistaController(){
        this.paDAO = new ProblemaActivistaDAO();
    }
    
    public boolean asignarActivista(int idProblema, int idActivista){
        if(idProblema <= 0 || idActivista <= 0){
            System.err.println("IDs invalidos para asignacion");
            return false;
        }
        ProblemaActivista relacion = new ProblemaActivista();
        relacion.setIdProblema(idProblema);
        relacion.setIdActivista(idActivista);
        return paDAO.insertar(relacion);
    }
    
    public List<ProblemaActivista> obtenerPorProblema(int idProblema){
        if(idProblema <= 0){
            System.err.println("Id de problema invalido");
            return null;
        }
        return paDAO.obtenerPorProblema(idProblema);
    }
    
    public List<ProblemaActivista> obtenerPorActivista(int idActivista){
        if(idActivista <= 0){
            System.err.println("Id de activista invalido");
            return null;
        }
        return paDAO.obtenerPorActivista(idActivista);
    }
    
    public boolean eliminarAsignacion(int idProblema, int idActivista){
        if(idProblema <= 0 || idActivista <= 0){
            System.err.println("IDs invalidos para eliminacion");
            return false;
        }
        return paDAO.eliminar(idProblema, idActivista);
    }
}
