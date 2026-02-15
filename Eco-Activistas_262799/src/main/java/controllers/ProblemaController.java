package controllers;

import daos.IProblemaDAO;
import daos.ProblemaDAO;
import java.sql.Date;
import java.util.List;
import models.Cliente;
import models.Problema;

/**
 *
 * @author axelm
 */
public class ProblemaController {
    private final IProblemaDAO problemaDAO;
    
    public ProblemaController(){
        this.problemaDAO = new ProblemaDAO();
    }
    
    public boolean agregar(Date fchIni, Date fchFin, String estado, int idCliente) {
        if(fchIni == null){
            System.err.println("La fecha de inicio es obligatoria");
            return false;
        }
        if(estado == null || !estado.toLowerCase().equals("pendiente") || !estado.toLowerCase().equals("concluido") || !estado.toLowerCase().equals("cancelado")){
            System.err.println("Estado invalido. Debe ser: pendiente, concluido o cancelado");
            return false;
        }
        if(idCliente <= 0){
            System.err.println("ID de cliente invalido");
            return false;
        }
        Problema problema = new Problema();
        problema.setFchIni(fchIni);
        problema.setFchFin(fchFin);
        problema.setEstado(estado.trim());
        problema.setIdCliente(idCliente);
        return problemaDAO.insertar(problema);
    }
    
    public Problema obtenerProblema(int idProblema){
        if(idProblema <=0){
            System.err.println("ID de problema invalido");
            return null;
        }
        return problemaDAO.obtenerPorId(idProblema);
    }
    
    public List<Problema> listarProblemas(){
            return problemaDAO.obtenerTodos();
    }
    
    public boolean actualizar(int idProblema, Date fchIni, Date fchFin, String estado, int idCliente){
        if(idProblema <= 0){
            System.err.println("ID de problema invalido");
            return false;
        }
        if(fchIni == null){
            System.err.println("La fecha de inicio es obligatoria");
            return false;
        }
        if(estado == null || !estado.toLowerCase().equals("pendiente") || !estado.toLowerCase().equals("concluido") || !estado.toLowerCase().equals("cancelado")){
            System.err.println("estado invalido. Debe ser: pendiente, concluido o cancelado");
            return false;
        }
        if(idCliente <= 0){
            System.err.println("ID de cliente invalido");
            return false;
        }
        Problema problema = new Problema();
        problema.setIdProblema(idProblema);
        problema.setFchIni(fchIni);
        problema.setFchFin(fchFin);
        problema.setEstado(estado);
        problema.setIdCliente(idCliente);
        return problemaDAO.actualizar(problema);
    }
    
    public boolean eliminarProblema(int idProblema){
        if(idProblema <= 0){
            System.err.println("ID de problema invalido");
            return false;
        }
        return problemaDAO.eliminar(idProblema);
    }
}
