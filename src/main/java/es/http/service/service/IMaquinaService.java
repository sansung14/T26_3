package es.http.service.service;

import java.util.List;

import es.http.service.dto.Maquina;

public interface IMaquinaService {

	//Metodos del CRUD
		public List<Maquina> listarMaquinas(); //Listar All 
		
		public Maquina guardarMaquina(Maquina maquina);	//Guarda un Maquina CREATE
		
		public Maquina maquinaXID(int id); //Leer datos de un Maquina READ
		
		public Maquina actualizarMaquina(Maquina maquina); //Actualiza datos del maquina UPDATE
		
		public void eliminarMaquina(int id);// Elimina el maquina DELETE
	
}


