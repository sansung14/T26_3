package es.http.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.dao.ICajeroDAO;
import es.http.service.dto.Cajero;

@Service
public class CajeroServiceImpl implements ICajeroService {
	
	@Autowired
	ICajeroDAO iCajeroDAO;

	@Override
	public List<Cajero> listarCajeros() {
		return iCajeroDAO.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		return iCajeroDAO.save(cajero);
	}

	@Override
	public Cajero cajeroXID(int id) {
		return iCajeroDAO.findById(id).get();
	}

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		return iCajeroDAO.save(cajero);
	}

	@Override
	public void eliminarCajero(int id) {
		iCajeroDAO.deleteById(id);
	}

}
