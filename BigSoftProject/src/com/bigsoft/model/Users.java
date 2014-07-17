/**
 * 
 */
package com.bigsoft.model;

import com.bigsoft.dao.UserDAO;

/**
 * @author Mishchuk_AA
 *
 */
public class Users {

	/**
	 * @return
	 */
	public Object getAllUsers() {
		UserDAO dao = new UserDAO();		
		return dao.getAllUsers();
	}

}
