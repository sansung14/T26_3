package es.http.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.http.service.dto.Maquina;
import es.http.service.service.MaquinaServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaController {
	
	@Autowired
	MaquinaServiceImpl maquinaServiceImpl;
	
	@GetMapping("/maquinas")
	public List<Maquina> listarMaquinas(){
		return maquinaServiceImpl.listarMaquinas();
	}
	
	
	@PostMapping("/maquinas")
	public Maquina salvarMaquina(@RequestBody Maquina maquina) {
		
		return maquinaServiceImpl.guardarMaquina(maquina);
	}
	
	
	@GetMapping("/maquinas/{id}")
	public Maquina MaquinaXID(@PathVariable(name="id") int id) {
		
		Maquina Maquina_xid= new Maquina();
		
		Maquina_xid=maquinaServiceImpl.maquinaXID(id);
		
		//System.out.println("Maquina XID: "+Maquina_xid);
		
		return Maquina_xid;
	}
	
	@PutMapping("/maquina/{id}")
	public Maquina actualizarMaquina(@PathVariable(name="id")int id,@RequestBody Maquina Maquina) {
		
		Maquina Maquina_seleccionado= new Maquina();
		Maquina Maquina_actualizado= new Maquina();
		
		Maquina_seleccionado= maquinaServiceImpl.maquinaXID(id);
		
		Maquina_seleccionado.setPiso(Maquina.getPiso());

		
		Maquina_actualizado = maquinaServiceImpl.actualizarMaquina(Maquina_seleccionado);
		
		//System.out.println("El Maquina actualizado es: "+ Maquina_actualizado);
		
		return Maquina_actualizado;
	}
	
	@DeleteMapping("/maquina/{id}")
	public void eleiminarMaquina(@PathVariable(name="id")int id) {
		maquinaServiceImpl.eliminarMaquina(id);
	}
	
	
}
