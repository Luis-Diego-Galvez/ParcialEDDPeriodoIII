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
    private int dia;
    
    //CONSTRUCTOR
    public Transportaciones() {}
    public Transportaciones(String pInicio, String pDestino, String pMateriales, double pCosto, int pDia) {
        this.Inicio = pInicio;
        this.Destino = pDestino;
        this.Materiales = pMateriales;
        this.Costo = pCosto;
        this.dia = pDia;
    }
        //CONSTRUCTOR DATABASE CONNECTION
    public Transportaciones(int pID, Conex ndb) {
        try {
            Statement stmt = ndb.getConnection().createStatement();
            String query = "SELECT inicio, destino, material, costo, dia FROM viajes WHERE id="+String.valueOf(pID);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                this.setID(pID);
                this.setInicio(rs.getString(0));
                this.setDestino(rs.getString(1));
                this.setMaterial(rs.getString(2));
                this.setCosto(rs.getDouble(3));
                this.setDia(rs.getInt(4));
            }
        }catch (Exception e) {}
    }
    
    //GETTERS
    public int getID() {return this.id;}
    public String getInicio() {return this.Inicio;}
    public String getDestino() {return this.Destino;}
    public String getMaterial() {return this.Materiales;}
    public double getCosto() {return this.Costo;}
    public int getDia() {return this.dia;}
    
    //SETTERS
    public void setID(int pID) {this.id = pID;}
    public void setInicio(String pInicio) {this.Inicio = pInicio;}
    public void setDestino(String pDestino) {this.Destino = pDestino;}
    public void setMaterial(String pMaterial) {this.Materiales = pMaterial;}
    public void setCosto(double pCosto) {this.Costo = pCosto;}
    public void setDia(int pDia) {this.dia = pDia;}
    
    //DATABASE CALLS
    public void InsertIn(Conex db) {
        try {
            String query = "INSERT INTO viajes(inicio, destino, material, costo, dia) VALUES(?,?,?,?,?)";
            PreparedStatement pst = db.getConnection().prepareStatement(query);
            pst.setString(0,this.getInicio());
            pst.setString(1, this.getDestino());
            pst.setString(2, this.getMaterial());
            pst.setDouble(3, this.getCosto());
            pst.setInt(4, this.getDia());
            pst.execute();
        }catch (Exception e) {}
    }
    
    public void UpdateIn(Conex db) {
        try {
            String query = "UPDATE viajes SET inicio=?, destino=?, material=?, costo=? WHERE id="+String.valueOf(this.getID());
            PreparedStatement pst = db.getConnection().prepareStatement(query);
            pst.setString(0,this.getInicio());
            pst.setString(1, this.getDestino());
            pst.setString(2, this.getMaterial());
            pst.setDouble(3, this.getCosto());
            pst.setInt(4, this.getDia());
            pst.execute();
        }catch (Exception e) {}
    }
    
   
}
