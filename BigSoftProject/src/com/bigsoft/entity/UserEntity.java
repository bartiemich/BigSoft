/**
 * 
 */
package com.bigsoft.entity;

import javax.persistence.*;

/**
 * @author Mishchuk_AA
 *
 */
@Entity
@Table(name="user")
public class UserEntity {
	
	public UserEntity(int id, String name, int roleId, String login,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.roleId = roleId;
		this.login = login;
		this.password = password;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="login")
	private String login;	
	
	@Column(name="password")
	private String password;

	public UserEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + "]";
	}

	
}
