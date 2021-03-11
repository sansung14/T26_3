package es.http.service.service;

import java.util.List;

import es.http.service.dto.Venta;

public interface IVentaService {

	//Metodos del CRUD
		public List<Venta> listarVenta(); //Listar All 
		
		public Venta guardarVenta(Venta venta);	//Guarda un Venta CREATE
		
		public Venta ventaXID(int id); //Leer datos de un Venta READ
		
		public Venta actualizarVenta(Venta venta); //Actualiza datos del Venta UPDATE
		
		public void eliminarVenta(int id);// Elimina el Venta DELETE
	
}


