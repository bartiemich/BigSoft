/**
 * 
 */
package com.bigsoft.model;

import java.util.List;

import com.bigsoft.dao.UserDAO;
import com.bigsoft.entity.UserEntity;

/**
 * @author Mishchuk_AA
 * 
 */
public class User {

	/**
	 * @return
	 */
	public List<UserEntity> getAllUsers() {
		UserDAO dao = new UserDAO();
		return dao.getAllUsers();
	}

	/**
	 * @param login
	 * @param password
	 * @return
	 */
	public String checkUser(String login, String password) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		return dao.checkUser(login, password);
	}

	/**
	 * @param id
	 */
	public void removeUser(String id) {
		UserDAO dao = new UserDAO();
		dao.removeUser(id);

	}

	/**
	 * @param id
	 * @return
	 */
	public UserEntity getUser(String id) {
		UserDAO dao = new UserDAO();
		return dao.getUser(id);
	}

	/**
	 * @param name
	 * @param login
	 * @param password
	 * @param role
	 */
	public void addUser(String name, String login, String password, String role) {
		UserDAO dao = new UserDAO();
		dao.addUser(name, login, password, role);
	}

	/**
	 * @param id
	 * @param name
	 * @param login
	 * @param password
	 * @param role
	 */
	public void editUser(String id, String name, String login, String password,
			String role) {
		UserDAO dao = new UserDAO();
		dao.editUser(id, name, login, password, role);
	}

}
