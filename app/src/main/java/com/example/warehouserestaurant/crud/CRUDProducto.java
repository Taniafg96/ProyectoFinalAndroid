package com.example.warehouserestaurant.crud;

import com.example.warehouserestaurant.connect.ConnectionDB;
import com.example.warehouserestaurant.pojo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDProducto {

    public boolean create(Producto producto){
        String createQuery = "INSERT INTO Producto(nombre, categoria, stock) VALUES(?, ?, ?)";

        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(createQuery)){

            pstm.setString(1, producto.getNombre());
            pstm.setString(2, producto.getCategoria());
            pstm.setInt(3, producto.getStock());

            pstm.execute();
            pstm.close();
            connection.close();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage()+"\n" + ex.getErrorCode()+"\n" + ex.getSQLState());
            return false;
        }
    }

    public String read(int id){
        String readQuery = "SELECT * FROM Producto where id = ?";
        String result = "";

        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(readQuery)){

            pstm.setInt(1, id);
            pstm.execute();

            ResultSet rs = pstm.getResultSet();
            if(rs.next()) {
                result += "Id Producto: " + rs.getInt("id");
                result += "\nNombre: " + rs.getString("nombre");
                result += "\nCategoria: " + rs.getString("categoria");
                result += "\nStock: " + rs.getInt("stock");

            }else result = "No se ha encontrado ningun producto con ese nombre";

            pstm.close();
            connection.close();
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        return result;
    }

    public boolean update(int stock, int id){
        String updateQuery = "UPDATE Producto SET stock = ? WHERE id = ?";
        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(updateQuery)){

            pstm.setInt(1, stock);
            pstm.setInt(2, id);
            pstm.executeUpdate();

            pstm.close();
            connection.close();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return false;
        }
    }

    public Boolean delete(int id){
        String deleteQuery = "DELETE FROM Producto where id = ?";
        try(Connection connection = new ConnectionDB().getConnection();
            PreparedStatement pstm = connection.prepareStatement(deleteQuery)){

            pstm.setInt(1, id);

            pstm.execute();
            return true;
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
            return false;
        }
    }
}
