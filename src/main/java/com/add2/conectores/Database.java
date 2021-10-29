package com.add2.conectores;

import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

public class Database {
	 public static void main(String args[]) {
		 
		 try {
			 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root123");
			 
			 Statement stmt = con.createStatement();
			 System.out.println("BASE DE DATOS: pelicula");
			 System.out.println("");
			 
			 ResultSet rs = stmt.executeQuery("select * from pelicula");
			 while(rs.next())
				System.out.println("id: "+rs.getInt(1) + " " +" Titulo: "+ rs.getString(2) + " " + " Duracion: "+rs.getInt(3) + " " + " Genero: "+rs.getString(4));
			 System.out.println("-----------------------");
			 System.out.println("- Nueva base de datos -");
			 System.out.println("-----------------------");
			 System.out.println("BASE DE DATOS: sala");
			 
			 stmt.execute("DROP TABLE IF EXISTS sala");
			 stmt.execute("CREATE TABLE sala(asiento tinyint, fila int)");
			 stmt.execute("INSERT INTO sala VALUES" + "('5','6'),"
					 								+ "('15','2'),"
					 								+"('16','2')");
			
			 rs = stmt.executeQuery("select * from sala");
			 System.out.println("");
			 while(rs.next())
				 System.out.println("asiento: "+ rs.getInt(1) + " " + "fila: " + rs.getInt(2));
			
			 
			 con.close();
			 
		 }catch (Exception e){
			 e.printStackTrace();
		 }
		 
		 
		 
		 
		 
		 
	 }
}
