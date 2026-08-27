/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.programadoreschidos.abarroteria.kinal.repository;

import javafx.collections.ObservableList;
import main.java.com.programadoreschidos.abarroteria.kinal.config.DataBaseConnection;
import main.java.com.programadoreschidos.abarroteria.kinal.model.Producto;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author informatica
 */
public class ProductoRepository {
    
    public ObservableList<Producto> findAll(){
     String sql = "select * from productos";
     try(PreparedStatement pstm = DataBaseConnection.getDataBaseConnection().prepareStatement(sql))
    ResulSet rs = pstm.executeQuery();
    ObservableList<Producto> Lista = FXCollections.ObservableList
         if(rs.next()){
            lista.add(new Producto(
            rs.getString("id_producto"),
            rs.getString("nombre_producto"),
            rs.getInt(),
            
            )
         }
         }catch(SQLException e){
        
    }
}
