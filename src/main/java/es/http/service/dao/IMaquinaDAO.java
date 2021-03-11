package es.http.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import es.http.service.dto.Maquina;

/**
 * @author David
 *
 */
public interface IMaquinaDAO extends JpaRepository<Maquina, Integer>{
	
}
