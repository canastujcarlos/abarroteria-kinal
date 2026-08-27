package main.java.com.programadoreschidos.abarroteria.kinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.java.com.programadoreschidos.abarroteria.kinal.dto.request.LoginDTORequest;
import main.java.com.programadoreschidos.abarroteria.kinal.dto.response.LoginDTOResponse;
import main.java.com.programadoreschidos.abarroteria.kinal.service.AuthService;
import main.java.com.programadoreschidos.abarroteria.kinal.util.SceneManager;

public class LoginController implements Initializable {
    
    private final AuthService authService;
    private final SceneManager sceneManager;

    @FXML
    private Button btnIniciarSesion;
    @FXML
    private TextField txtFieldEmail;
    @FXML
    private TextField txtFieldPassword;
    
    public LoginController(AuthService authService, SceneManager sceneManager) {
        this.authService = authService;
        this.sceneManager = sceneManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleLogin()throws Exception{
    if(txtFieldEmail.getText().isEmpty() || txtFieldPassword.getText().isEmpty()){
        sceneManager.showAlertInfo("Hay campos sin llenar", "No puedes dejar espacios en blanco", "Intenta de nuevo", Alert.AlertType.INFORMATION);
    } else {
        try{
            // 1. Intentamos iniciar sesión
            LoginDTOResponse response = authService.login(new LoginDTORequest(txtFieldEmail.getText(), txtFieldPassword.getText()));
            
            // 2. Mostramos la alerta de éxito
            sceneManager.showAlertInfo("Bienvenido: " + response.getNombre(), "Es bueno verte:", "Inicio de Sesión correcto", Alert.AlertType.INFORMATION);
            
            // 3. CAMBIO DE ESCENA: Llamamos al dashboard
            // Como este método lanza Exception, lo metemos en un try-catch local
            try {
                sceneManager.showDashboardView();
            } catch (Exception e) {
                sceneManager.showAlertInfo("Error", "Error de navegación", "No se pudo cargar el dashboard: " + e.getMessage(), Alert.AlertType.ERROR);
            }
            
        } catch(RuntimeException e){
            // Si el servicio de Auth falla (credenciales incorrectas)
            sceneManager.showAlertInfo("Error al iniciar sesión", "Verificar campos", "No se ha podido iniciar sesión", Alert.AlertType.WARNING);
        }
    }
}
}