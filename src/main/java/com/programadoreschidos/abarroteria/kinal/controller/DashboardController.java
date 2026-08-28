/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.com.programadoreschidos.abarroteria.kinal.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.programadoreschidos.abarroteria.kinal.model.Producto;
import main.java.com.programadoreschidos.abarroteria.kinal.service.DashboardService;
import main.java.com.programadoreschidos.abarroteria.kinal.util.SceneManager;


public class DashboardController implements Initializable {
    private DashboardService dashboardService;
    private SceneManager sceneManager;
    @FXML
    private TableView<Producto> tableProducto;
    @FXML
    private TableColumn<Producto, String> tableColumnIdProducto;
    @FXML
    private TableColumn<Producto, String> tableColumnNombreProducto;
    @FXML
    private TableColumn<Producto, Integer> tableColumnStock;
    
    @FXML
    private Button btnEliminar;
    
    @FXML
    private TableColumn<Producto, BigDecimal> tableColumnPrecio;
    public DashboardController(DashboardService dashboardService, SceneManager sceneManager){
        this.dashboardService = dashboardService;
        this.sceneManager = sceneManager;
    }
    

 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleLoadDataTableView();
    }    
    @FXML
    private void handleLoadDataTableView(){
        tableColumnIdProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        tableColumnNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        tableColumnStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableColumnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tableProducto.setItems(dashboardService.findProducto());
    }
    
    @FXML
private void handleEliminarProducto() {
    // 1. Obtener el producto seleccionado en la tabla
    Producto productoSeleccionado = tableProducto.getSelectionModel().getSelectedItem();
    
    if (productoSeleccionado == null) {
        // Usa tu SceneManager para mostrar una alerta de advertencia
        sceneManager.showAlertInfo("Atención", "Ningún producto seleccionado", "Por favor selecciona un producto de la tabla para eliminar.", Alert.AlertType.WARNING);
        return;
    }
    
    try {
        // 2. Eliminar de la base de datos usando el servicio
        dashboardService.eliminarProducto(productoSeleccionado.getIdProducto());
        
        // 3. Removerlo de la tabla visualmente
        tableProducto.getItems().remove(productoSeleccionado);
        
        // 4. Notificar éxito
        sceneManager.showAlertInfo("Éxito", "Producto eliminado", "El producto se ha eliminado correctamente.", Alert.AlertType.INFORMATION);
        
    } catch (Exception e) {
        sceneManager.showAlertInfo("Error", "Error al eliminar", "No se pudo eliminar el producto de la base de datos: " + e.getMessage(), Alert.AlertType.ERROR);
    }
  }
}