package com.example.warehouserestaurant.crud;

import com.example.warehouserestaurant.connect.ConnectionDB;
import com.example.warehouserestaurant.pojo.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDEmpresa {

    public boolean create(Empresa empresa){
        String createQuery = "INSERT INTO Empresa VALUES(?, ?)";

        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(createQuery)){

            pstm.setString(1, empresa.getNif());
            pstm.setString(2, empresa.getNombre());

            pstm.execute();
            pstm.close();
            connection.close();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage()+"\n" + ex.getErrorCode()+"\n" + ex.getSQLState());
            return false;
        }
    }

    public String read(String nif){
        String readQuery = "SELECT * FROM Empresa where nif = ?";
        String result = "";

        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(readQuery)){

            pstm.setString(1, nif);

            pstm.executeQuery();

            ResultSet rs = pstm.getResultSet();
            if(rs.next()) {
                result += "NIF Empresa: " + rs.getString("nif");
                result += "\nNombre: " + rs.getString("nombre");

            }else result += "No se ha encontrado la factura";

            pstm.close();
            connection.close();
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        return result;
    }

    public void update(String nif, String nombre){
        String updateQuery = "UPDATE Empresa SET nombre = ? WHERE nif = ?";
        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(updateQuery)){

            pstm.setString(1, nombre);
            pstm.setString(2, nif);
            pstm.executeUpdate();

            pstm.close();
            connection.close();
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public boolean delete(String nif){
        String deleteQuery = "DELETE FROM Empresa where nif = ?";
        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(deleteQuery)){

            pstm.setString(1, nif);
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return false;
        }
    }
}
