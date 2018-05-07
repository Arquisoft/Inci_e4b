package com.uniovi.incidenceManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Operario;
import com.uniovi.incidenceManager.repositories.OperarioRepository;

/**
 * Servicio encargado de comunicarse con el repositorio de operarios.
 */
@Service
public class OperarioService {

	/**
	 * Repositorio de operarios, lo usaremos para ejecutar las operaciones necesarias
	 * sobre la base de datos.
	 */
	@Autowired
	private OperarioRepository operarioRepository;
	
	/**
	 * Encoder de contraseñas, se usara para encriptar las contraseñas de los usuarios.
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * Llama al método findAll del repositorio y devuelve su resultado.
	 * @return Retorna una lista con todos los operarios de la base de datos.
	 */
	public List<Operario> findAll(){
		return operarioRepository.findAll();
	}
	
	/**
	 * Llama al método findByDni del repositorio y devuelve su resultado.
	 * @param dni -> Dni del operario a buscar.
	 * @return Retorna al operario con el dni dado.
	 */
	public Operario findByDni(String dni) {
		return operarioRepository.findByDni(dni);
	}
	
	/**
	 * Llama al método findById del repositorio y devuelve su resultado.
	 * @param id -> Id del operario a buscar.
	 * @return Retorna al operario con el id dado.
	 */
	public Operario findById(long id) {
		return operarioRepository.findById(id);
	}
	
	/**
	 * Añade un operario a la base de datos, pero antes de eso encripta su contraseña.
	 * @param operario -> Operario a añadir.
	 */
	public void addOperario(Operario operario) {
		operario.setPassword(bCryptPasswordEncoder.encode(operario.getPasswordConfirm()));
		operarioRepository.save(operario);
	}
	
	/**
	 * Elimina a un operario de la base de datos.
	 * @param operario -> Operario a eliminar.
	 */
	public void removeOperario(Operario operario) {
		operarioRepository.delete(operario);
	}
	
}
