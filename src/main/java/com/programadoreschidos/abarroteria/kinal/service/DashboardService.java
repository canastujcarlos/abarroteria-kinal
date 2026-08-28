/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.programadoreschidos.abarroteria.kinal.service;

import javafx.collections.ObservableList;
import main.java.com.programadoreschidos.abarroteria.kinal.model.Producto;
import main.java.com.programadoreschidos.abarroteria.kinal.repository.ProductoRepository;



   public class DashboardService {
    private final ProductoRepository productoRepository;
    
    // Sin repositorio, puedes dejarlo vacío o con métodos de prueba

    public DashboardService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
   
    public ObservableList<Producto> findProducto(){
    if(productoRepository.findAll()== null){
        throw new RuntimeException("Sin productos");
      }else{
        return productoRepository.findAll(); 
      }
    }

    public String obtenerMensajeBienvenida() {
        return "¡Bienvenido al sistema de la Abarrotería Kinal!";
    }
    
    public void eliminarProducto(String idProducto) {
    productoRepository.eliminar(idProducto); // O el método que tengas en tu repositorio para borrar en la BD
}
}
