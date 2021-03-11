package es.http.service.service;

import java.util.List;

import es.http.service.dto.Cajero;

public interface ICajeroService {

	//Metodos del CRUD
		public List<Cajero> listarCajeros(); //Listar All 
		
		public Cajero guardarCajero(Cajero cajero);	//Guarda un Cajero CREATE
		
		public Cajero cajeroXID(int id); //Leer datos de un Cajero READ
		
		public Cajero actualizarCajero(Cajero cajero); //Actualiza datos del cajero UPDATE
		
		public void eliminarCajero(int id);// Elimina el cajero DELETE
	
}


