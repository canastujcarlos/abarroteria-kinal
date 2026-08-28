/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.programadoreschidos.abarroteria.kinal.service;

import main.java.com.programadoreschidos.abarroteria.kinal.repository.ProductoRepository;



   public class DashboardService {
    private final ProductoRepository productoRepository;
    
    // Sin repositorio, puedes dejarlo vacío o con métodos de prueba

    public DashboardService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
   
    public ObservableList<Producto>

    public String obtenerMensajeBienvenida() {
        return "¡Bienvenido al sistema de la Abarrotería Kinal!";
    }
}
