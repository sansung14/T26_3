package es.http.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.http.service.dao.IMaquinaDAO;
import es.http.service.dto.Maquina;

@Service
public class MaquinaServiceImpl implements IMaquinaService {
	
	@Autowired
	IMaquinaDAO iMaquinaDAO;

	@Override
	public List<Maquina> listarMaquinas() {
		return iMaquinaDAO.findAll();
	}

	@Override
	public Maquina guardarMaquina(Maquina maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public Maquina maquinaXID(int id) {
		return iMaquinaDAO.findById(id).get();
	}

	@Override
	public Maquina actualizarMaquina(Maquina maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public void eliminarMaquina(int id) {
		iMaquinaDAO.deleteById(id);
	}

}
