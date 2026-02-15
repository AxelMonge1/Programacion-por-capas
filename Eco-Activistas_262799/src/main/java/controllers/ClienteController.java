/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.ClienteDAO;
import daos.iClienteDAO;
import java.util.List;
import models.Cliente;

/**
 *
 * @author LABORATORIOS
 */
public class ClienteController{
    private final iClienteDAO clienteDAO;
    
    public ClienteController(){
        this.clienteDAO = new ClienteDAO();
    }
    
    public boolean agregar(String nombre, String direccion, String telefonos) {
        if(nombre == null || nombre.trim().isEmpty()){
            System.err.println("El nombre del cliente no puede estar vacio");
            return false;
        }
        if(direccion == null || direccion.trim().isEmpty()){
            direccion = "";
        }
        if(telefonos == null || telefonos.trim().isEmpty()){
            telefonos = "";
        }
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre.trim());
        cliente.setDireccion(direccion.trim());
        cliente.setTelefonos(telefonos.trim());
        return clienteDAO.insertar(cliente);
    }
    
    public Cliente obtenerCliente(int idCliente){
        if(idCliente <=0){
            System.err.println("ID de cliente invalido");
            return null;
        }
        return clienteDAO.obtenerPorId(idCliente);
    }
    
    public List<Cliente> listarClientes(){
            return clienteDAO.obtenerTodos();
    }
    
    public boolean actualizar(int idCliente, String nombre, String direccion, String telefonos){
        if(idCliente <= 0){
            System.err.println("ID de cliente invalido");
            return false;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            System.err.println("El nombre del cliente no puede estar vacio");
            return false;
        }
        if(direccion == null) direccion = "";
        if(telefonos == null) telefonos = "";
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNombre(nombre.trim());
        cliente.setDireccion(direccion.trim());
        cliente.setTelefonos(telefonos.trim());
        return clienteDAO.actualizar(cliente);
    }
    
    public boolean eliminarCliente(int idCliente){
        if(idCliente <= 0){
            System.err.println("ID de cliente invalido");
            return false;
        }
        return clienteDAO.eliminar(idCliente);
    }
}
