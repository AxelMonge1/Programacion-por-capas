package controllers;

import daos.ActivistaDAO;
import daos.IActivistaDAO;
import java.sql.Date;
import java.util.List;
import models.Activista;
import models.Cliente;

/**
 *
 * @author axelm
 */
public class ActivistaController {
    private final IActivistaDAO activistaDAO;
    
    public ActivistaController(){
        this.activistaDAO = new ActivistaDAO();
    }
    
    public boolean agregarActivista(String nombre, String telefono, Date fchIngreso) {
        if(nombre == null || nombre.trim().isEmpty()){
            System.err.println("El nombre del activista no puede estar vacio");
            return false;
        }
        if(fchIngreso == null){
            System.err.println("La fecha de ingreso es obligatoria");
        }
        if(telefono == null || telefono.trim().isEmpty()){
            telefono = "";
        }
        Activista activista = new Activista();
        activista.setNombre(nombre.trim());
        activista.setTelefono(telefono.trim());
        activista.setFchIngreso(fchIngreso);
        return activistaDAO.insertar(activista);
    }
    
    public Activista obtenerActivista(int idActivista){
        if(idActivista <=0){
            System.err.println("ID de activista invalido");
            return null;
        }
        return activistaDAO.obtenerPorId(idActivista);
    }
    
    public List<Activista> listarActivistas(){
            return activistaDAO.obtenerTodos();
    }
    
    public boolean actualizar(int idActivista, String nombre, String telefono, Date fchIngreso){
        if(idActivista <= 0){
            System.err.println("ID de activista invalido");
            return false;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            System.err.println("El nombre del activista no puede estar vacio");
            return false;
        }
        if(fchIngreso == null){
            System.err.println("La fecha de ingreso es obligatoria");
            return false;
        }
        if(telefono == null) telefono = "";
        Activista activista = new Activista();
        activista.setIdActivista(idActivista);
        activista.setNombre(nombre.trim());
        activista.setFchIngreso(fchIngreso);
        activista.setTelefono(telefono.trim());
        return activistaDAO.actualizar(activista);
    }
    
    public boolean eliminarActivista(int idActivista){
        if(idActivista <= 0){
            System.err.println("ID de activista invalido");
            return false;
        }
        return activistaDAO.eliminar(idActivista);
    }
}
