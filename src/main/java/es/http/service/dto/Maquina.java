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
@Table(name="maquina")//en caso que la tabala sea diferente
public class Maquina {

	//Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "piso")//no hace falta si se llama igual
	private int piso;
	@OneToMany
    @JoinColumn(name="id")
    private List<Venta> venta;
	
	//Constructores
	
	public Maquina() {
	
	}

	/**
	 * @param id
	 * @param piso
	 * @param venta
	 */



	public Maquina(int id, int piso, List<Venta> venta) {
		super();
		this.id = id;
		this.piso = piso;
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




	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Maquina [id=" + id + ", piso=" + piso + ", venta=" + venta + "]";
	}







	
	
	
}
