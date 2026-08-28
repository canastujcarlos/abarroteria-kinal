/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.com.programadoreschidos.abarroteria.kinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.java.com.programadoreschidos.abarroteria.kinal.service.DashboardService;
import main.java.com.programadoreschidos.abarroteria.kinal.util.SceneManager;


public class DashboardController {

    private final DashboardService dashboardService;
    private final SceneManager sceneManager;

    @FXML
    private Label lblWelcome;
    @FXML
    private Button btnLogout;

    // Recibe ambos por inyección de dependencias
    public DashboardController(DashboardService dashboardService, SceneManager sceneManager) {
        this.dashboardService = dashboardService;
        this.sceneManager = sceneManager;
    }

    @FXML
    public void initialize() {
        // Usamos el servicio para poner un texto en la etiqueta
        if (lblWelcome != null) {
            lblWelcome.setText(dashboardService.obtenerMensajeBienvenida());
        }
    }

    @FXML
    public void handleLogout() {
        try {
            sceneManager.showLoginView();
        } catch (Exception e) {
            sceneManager.showAlertInfo("Error", "Error de navegación", e.getMessage(), AlertType.ERROR);
        }
    }
}