package com.example.warehouserestaurant.crud;

import com.example.warehouserestaurant.connect.ConnectionDB;
import com.example.warehouserestaurant.pojo.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CRUDFactura {

    public Boolean create(Factura factura){
        String createQuery = "INSERT INTO Factura VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(createQuery)){

            pstm.setString(1, factura.getNumeroFactura());
            pstm.setDate(2, factura.getFecha());
            pstm.setDouble(3, factura.getTotal());
            pstm.setDouble(4, factura.getIgic3());
            pstm.setDouble(5, factura.getIgic7());
            pstm.setDouble(6, factura.getIgic15());
            pstm.setString(7, factura.getNifEmpresa());

            pstm.execute();
            pstm.close();
            connection.close();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage()+"\n" + ex.getErrorCode()+"\n" + ex.getSQLState());
            return false;
        }
    }

    public String read(String factura){
        String readQuery = "SELECT * FROM Factura WHERE numero_factura = ?";
        String result = "";

        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(readQuery)){

            pstm.setString(1, factura);
            pstm.execute();

            ResultSet rs = pstm.getResultSet();
            if(rs.next()) {
                    result += "Numero de Factura:   " + rs.getString("numero_factura");
                    result += "\nFecha:     " + rs.getDate("fecha");
                    result += "\nTotal:     " + rs.getDouble("precio_total");
                    result += "\nIgic 3%:   " + rs.getDouble("igic_3");
                    result += "\nIgic 7%:   " + rs.getDouble("igic_7");
                    result += "\nIgic 15%:  " + rs.getDouble("igic_15");
                    result += "\nNIF empresa:   " + rs.getString("empresa");
            }else result += "No se ha encontrado la factura";

            pstm.close();
            connection.close();
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }

        return result;
    }

    public Boolean update(String factura, String setQuery){
        String updateQuery = "UPDATE Factura " + setQuery + " WHERE numero_factura = ?";
        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(updateQuery)){

            pstm.setString(1, factura);
            pstm.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return false;
        }
    }

    public Boolean delete(String factura){
        String deleteQuery = "DELETE FROM factura where numero_factura = ?";
        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(deleteQuery)){

            pstm.setString(1, factura);
            pstm.execute();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return false;
        }

    }
}
