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
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conex {
    //PROPERTIES
    private Connection Conn;
    
    //CONSTRUCTOR
    public Conex(String IP, String Port, String DB, String User, String Pssw) {
        try {
            Class.forName("org.postgresql.Driver");
            this.Conn = DriverManager.getConnection("jdbc:postgresql://"+IP+":"+Port+"/"+ DB, User, Pssw) ;
        }catch (Exception e) { this.Conn = null; }
    }
    
    public Connection getConnection() {     return this.Conn;   }
}
