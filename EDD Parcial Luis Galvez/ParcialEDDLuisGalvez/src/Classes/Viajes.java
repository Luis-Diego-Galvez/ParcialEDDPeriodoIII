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

public class Viajes {
    private Conex db;
    
    public Viajes(Conex ndb) {this.db = ndb;}
    
    public int CountViajes(int dia) {
        int cv = 0;
        try{
            Statement stmt = db.getConnection().createStatement();
            String query = "SELECT COUNT(*) FROM viajes WHERE dia="+String.valueOf(dia);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                cv  = rs.getInt(0);
            }
        }catch (Exception e) {}
        return cv;
    }
    
    public double TotalCosts(int dia) {
        double total = 0;
        try{
            Statement stmt = db.getConnection().createStatement();
            String query = "SELECT SUM(costo) FROM viajes WHERE dia="+String.valueOf(dia);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                total = rs.getDouble(0);
            }
        }catch (Exception e) {}
        return total;
    }
    
    public double AverageCosts(int dia) {
        double avgc = 0;
        try {
            Statement stmt = db.getConnection().createStatement();
            String query = "SELECT AVG(costo) FROM viajes WHERE dia="+String.valueOf(dia);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                avgc = rs.getDouble(0);
            }
        }catch (Exception e) {}
        return avgc;
    }
}
