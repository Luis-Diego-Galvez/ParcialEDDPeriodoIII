/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author LuisD
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class Transportaciones {
    //PROPERTIES
    private int id;
    private String Inicio;
    private String Destino;
    private String Materiales;
    private double Costo;
    
    //CONSTRUCTOR
    public Transportaciones() {}
    public Transportaciones(String pInicio, String pDestino, String pMateriales, double pCosto) {
        this.Inicio = pInicio;
        this.Destino = pDestino;
        this.Materiales = pMateriales;
        this.Costo = pCosto;
    }
        //CONSTRUCTOR DATABASE CONNECTION
    public Transportaciones(int pID, Connection ndb) {
        try {
            Statement stmt = ndb.createStatement();
            String query = "SELECT inicio, destino, material, costo FROM viajes WHERE id="+String.valueOf(pID);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                this.setID(pID);
                this.setInicio(rs.getString(0));
                this.setDestino(rs.getString(1));
                this.setMaterial(rs.getString(2));
                this.setCosto(rs.getDouble(3));
            }
        }catch (Exception e) {}
    }
    
    //GETTERS
    public int getID() {return this.id;}
    public String getInicio() {return this.Inicio;}
    public String getDestino() {return this.Destino;}
    public String getMaterial() {return this.Materiales;}
    public double getCosto() {return this.Costo;}
    
    //SETTERS
    public void setID(int pID) {this.id = pID;}
    public void setInicio(String pInicio) {this.Inicio = pInicio;}
    public void setDestino(String pDestino) {this.Destino = pDestino;}
    public void setMaterial(String pMaterial) {this.Materiales = pMaterial;}
    public void setCosto(double pCosto) {this.Costo = pCosto;}
    
    //DATABASE CALLS
    public void InsertIn(Connection db) {
        try {
            String query = "INSERT INTO viajes(id, inicio, destino, material, costo) VALUES(null,?,?,?,?)";
            PreparedStatement pst = db.prepareStatement(query);
            pst.setString(0,this.getInicio());
            pst.setString(1, this.getDestino());
            pst.setString(2, this.getMaterial());
            pst.setDouble(3, this.getCosto());
            pst.execute();
        }catch (Exception e) {}
    }
    
    public void UpdateIn(Connection db) {
        try {
            String query = "UPDATE viajes SET inicio=?, destino=?, material=?, costo=? WHERE id="+String.valueOf(this.getID());
            PreparedStatement pst = db.prepareStatement(query);
            pst.setString(0,this.getInicio());
            pst.setString(1, this.getDestino());
            pst.setString(2, this.getMaterial());
            pst.setDouble(3, this.getCosto());
            pst.execute();
        }catch (Exception e) {}
    }
    
    public double AverageCost(Connection db) {
        double AVGC = 0;
        try {
            String query = "SELECT  FROM ";
        }catch (Exception e) {}
        return AVGC;
    }
}
