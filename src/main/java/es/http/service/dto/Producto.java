package es.http.service.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="producto")//en caso que la tabala sea diferente
public class Producto {

	//Atributos de entidad estudiante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Column(name = "precio")//no hace falta si se llama igual
	private int precio;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Venta> venta;
	
	//Constructores
	
	public Producto() {
	
	}


	public Producto(int id, String nombre, int precio, List<Venta> venta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.venta = venta;
	}


	/**
	 * @return the venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getPrecio() {
		return precio;
	}




	public void setPrecio(int precio) {
		this.precio = precio;
	}




	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", venta=" + venta + "]";
	}















	
	
	
	
	
	
	
	

	
	
	
	
	
	
}
