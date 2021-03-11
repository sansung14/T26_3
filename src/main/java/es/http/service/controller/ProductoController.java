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

import es.http.service.dto.Producto;
import es.http.service.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listaProductos(){
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	
	@GetMapping("/productos/{id}")
	public Producto productoXID(@PathVariable(name="id") int id) {
		
		Producto Producto_xid= new Producto();
		
		Producto_xid=productoServiceImpl.productoXID(id);
		
		//System.out.println("Producto XID: "+Producto_xid);
		
		return Producto_xid;
	}
	
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id")int id,@RequestBody Producto producto) {
		
		Producto Producto_seleccionado= new Producto();
		Producto Producto_actualizado= new Producto();
		
		Producto_seleccionado= productoServiceImpl.productoXID(id);
		
		Producto_seleccionado.setNombre(producto.getNombre());
		Producto_seleccionado.setPrecio(producto.getPrecio());

		Producto_actualizado = productoServiceImpl.actualizarProducto(Producto_seleccionado);
		
		//System.out.println("El Producto actualizado es: "+ Producto_actualizado);
		
		return Producto_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public void eleiminarProducto(@PathVariable(name="id")int id) {
		productoServiceImpl.eliminarProducto(id);
	}
	
	
}
