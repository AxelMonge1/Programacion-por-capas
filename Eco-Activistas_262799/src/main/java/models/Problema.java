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
public class Problema {
    private int idProblema;
    private Date fchIni;
    private Date fchFin;
    private String estado;
    private int idCliente;

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public void setFchIni(Date fchIni) {
        this.fchIni = fchIni;
    }

    public void setFchFin(Date fchFin) {
        this.fchFin = fchFin;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public Date getFchIni() {
        return fchIni;
    }

    public Date getFchFin() {
        return fchFin;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
