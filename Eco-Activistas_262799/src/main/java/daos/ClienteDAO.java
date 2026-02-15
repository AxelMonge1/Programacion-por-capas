/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.Cliente;

/**
 *
 * @author LABORATORIOS
 */
public class ClienteDAO implements iClienteDAO{

    @Override
    public boolean insertar(Cliente cliente) {
        String query = "INSERT INTO Cliente(nombre, direccion, telefonos) VALUES(?, ?, ?)";
        try(Connection con = ConexionDB.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            System.err.println("Error al insertar el cliente: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Cliente obtenerPorId(int idCliente) {
        String query = "SELECT * FROM Cliente WHERE idCliente = ?";
        Cliente cliente;
        try(Connection con = ConexionDB.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefonos(rs.getString("telefonos"));
                return cliente;
            }
            throw new RuntimeException("No se puso obtener el cliente");
        }catch(SQLException ex){
            throw new RuntimeException("No se encontro ningun cliente con el ID: " + idCliente);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
