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

import es.http.service.dto.Venta;
import es.http.service.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/ventas")
	public List<Venta> listarVenta(){
		return ventaServiceImpl.listarVenta();
	}
	
	
	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/ventas/{id}")
	public Venta VentaXID(@PathVariable(name="id") int id) {
		
		Venta Venta_xid= new Venta();
		
		Venta_xid=ventaServiceImpl.ventaXID(id);
		
		//System.out.println("Venta XID: "+Venta_xid);
		
		return Venta_xid;
	}
	
	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")int id,@RequestBody Venta Venta) {
		
		Venta Venta_seleccionado= new Venta();
		Venta Venta_actualizado= new Venta();
		
		Venta_seleccionado= ventaServiceImpl.ventaXID(id);
		
		
		Venta_seleccionado.setCajero(Venta.getCajero());
		Venta_seleccionado.setMaquina(Venta.getMaquina());
		Venta_seleccionado.setProducto(Venta.getProducto());

		Venta_actualizado = ventaServiceImpl.actualizarVenta(Venta_seleccionado);
		
		//System.out.println("El Venta actualizado es: "+ Venta_actualizado);
		
		return Venta_actualizado;
	}
	
	@DeleteMapping("/ventas/{id}")
	public void eleiminarVenta(@PathVariable(name="id")int id) {
		ventaServiceImpl.eliminarVenta(id);
	}
	
	
}
