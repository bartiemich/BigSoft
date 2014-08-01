/**
 * 
 */
package com.bigsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bigsoft.config.HibernateUtil;
import com.bigsoft.entity.RoleEntity;
import com.bigsoft.entity.UserEntity;


/**
 * @author Mishchuk_AA
 *
 */
public class UserDAO {

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
		List<UserEntity> result =(List<UserEntity>) session.createQuery( "from UserEntity u" ).list();   
	    session.close();
	    return result;

	}

	/**
	 * @param login
	 * @param password
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public String checkUser(String login, String password) {
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
		List<UserEntity> result =(List<UserEntity>) session.createQuery( "from UserEntity u where login='" + login + "' and password='" + password + "'" ).list();   
	    session.close();
	    if(result.isEmpty()) return "INVALID LOGIN/PASSWORD";
	    else  return new Integer(result.get(0).getRole().getId()).toString();
		
	}

	/**
	 * @param id
	 * @return
	 */
	public void removeUser(String id) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
	    UserEntity ent = (UserEntity) session.get(UserEntity.class, Integer.parseInt(id));
	    session.delete(ent);
	    session.getTransaction().commit();
	    session.close();
	   

	}

	/**
	 * @param name
	 * @param login
	 * @param password
	 * @param role
	 */
	public void addUser(String name, String login, String password, String role) {
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
	    UserEntity ent = new UserEntity();
	    ent.setName(name);
	    ent.setLogin(login);
	    ent.setPassword(password);
	    ent.setRole((RoleEntity) session.get(RoleEntity.class, Integer.parseInt(role)));
	    ent.setStatus(false);
	    session.save(ent);
	    session.getTransaction().commit();
	    session.close();

	}

	/**
	 * @param id
	 * @return 
	 */
	public UserEntity getUser(String id) {
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
	    UserEntity ent = (UserEntity) session.get(UserEntity.class, Integer.parseInt(id));
	    session.close();
	    return ent;
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
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
	    UserEntity ent = new UserEntity();
	    ent.setId(Integer.parseInt(id));
	    ent.setName(name);
	    ent.setLogin(login);
	    ent.setPassword(password);
	    ent.setRole((RoleEntity) session.get(RoleEntity.class, Integer.parseInt(role)));
	    ent.setStatus(false);
	    session.update(ent);
	    session.getTransaction().commit();
	    session.close();
	}

}
