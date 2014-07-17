/**
 * 
 */
package com.bigsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bigsoft.config.HibernateUtil;
import com.bigsoft.entity.UserEntity;

/**
 * @author Mishchuk_AA
 *
 */
public class UserDAO {

	/**
	 * @return
	 */
	public Object getAllUsers() {
		SessionFactory sf = HibernateUtil.createSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();    
		List<UserEntity> result =(List<UserEntity>) session.createQuery( "from User u" ).list();   
	    session.close();
	    return result;

	}

}
