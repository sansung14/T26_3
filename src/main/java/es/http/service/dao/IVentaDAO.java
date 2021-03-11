package es.http.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import es.http.service.dto.Venta;

/**
 * @author David
 *
 */
public interface IVentaDAO extends JpaRepository<Venta, Integer>{
	
}
