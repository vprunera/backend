package com.gastos.Gastos.service;

import java.util.List;

import com.gastos.Gastos.model.User;

public interface UserService {

	/**
	 * Guarda un usuario
	 * @param user
	 * @return el usuario guardado
	 */
	User save(User user);

	/**
	 * Recupera la lista de usuario
	 * @return lista de usuarios
	 */
	List<User> findAll();

	/**
	 * Elimina un usuario con el id recibido
	 * @param id
	 */
	void deleteUser(Long id);

}
