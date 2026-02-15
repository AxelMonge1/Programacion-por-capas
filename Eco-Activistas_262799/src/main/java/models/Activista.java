/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author axelm
 */
public class Activista {
    private int idActivista;
    private String nombre;
    private String telefono;
    private Date fchIngreso;

    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFchIngreso(Date fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    public int getIdActivista() {
        return idActivista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFchIngreso() {
        return fchIngreso;
    }
}
