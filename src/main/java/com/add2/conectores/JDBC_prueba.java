package com.add2.conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBC_prueba {
	
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL codigo especifico: " + e.getErrorCode());
	  }
	  
	  public static void main(String[] args) {

	    String basedatos = "prueba";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "root123";

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery("SELECT * FROM PELICULA")) {

	      int i=1;
	      while (rs.next()) {
	        System.out.println("[" + (i++) + "]");        
	        System.out.println("ID pelicula: " + rs.getString("IdPelicula"));
	        System.out.println("Titulo pelicula: " + rs.getString("Titulo"));
	        System.out.println("Duracion pelicula: " + rs.getString("Duracion")+" minutos");
	        System.out.println("Genero pelicula: " + rs.getString("Genero"));
	      }

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  }
}
