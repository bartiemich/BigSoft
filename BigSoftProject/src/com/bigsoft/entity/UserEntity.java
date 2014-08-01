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
	
	@Column(name="status")
	private boolean status;

	public UserEntity(int id, String name, RoleEntity role, String login,
			String password, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.login = login;
		this.password = password;
		this.status = status;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleEntity role;
	
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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
