package com.cdac.dao;

import com.cdac.entities.User;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getFactory;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		//user - transient
		String mesg = "Sign up failed!!!!!!!!";
		// 1. Get Hibernate Session from SessionFactory
		/*
		 * API of org.hibernate.SessionFactory public Session getCurrentSession() throws
		 * HibExc - Hibernate's SF chks if there is already existing Session - no ,
		 * creates the Session obj n rets it. - yes - rets existing session to the
		 * caller.
		 */
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2);// t
		/*
		 * 2. Begin a Transaction Session API public Transaction beginTransaction()
		 * throws HibExc
		 */
		Transaction tx = session.beginTransaction();
		System.out.println(session.isOpen() + " " + session.isConnected());// t t
		try {
			/*
			 * Session API public void persist(Object transientObj) throws HibExc
			 */
			session.persist(user);// user : PERSISTENT - exists in L1 cache
			// not yet in db
			// => success
			tx.commit();
			/*
			 * Internals - tx.commit 1. session.flush() - triggers auto dirty checking -
			 * Hibernate checks the state of L1 cache with DB - new entity in L1 cache -
			 * insert - existing entity but with updated state - update - entity marked for
			 * removal - delete - no change - no DML quries ! 2. session.close() - L1 cache
			 * is destroyed(removed) from heap - Pooled out DB cn rets to DBCP (inc re
			 * usability -> inc scalability)
			 */
			mesg = "User signed up !" + user.getUserId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			/*
			 * Internals - session.close() -> 
			 * pooled out DB cn rets to the DBCP n L1 cache
			 * is destroyed
			 * 
			 */
			// re throw the exception to caller - so that caller knows about it !
			throw e;
		}
		//user - DETACHED (from L1 cache , but corresponding rec exists in db)
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		User user=null;
		//1. Get Session from SessionFactory
		Session session=getFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
			user=session.get(User.class, userId);//select
			/*
			 * Hibernate checks if entity already exists in L1 cache 
			 * with given id ?
			 * - if not - select query -> RST processing 
			 * -> rets null | persistent entity
			 */
			user=session.get(User.class, userId);
			user=session.get(User.class, userId);
			user=session.get(User.class, userId);//reading from cache 
			/*
			 * in case of valid id - user - PERSISTENT(exists in L1 cache n DB)
			 */
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw exc to the caller
			throw e;
		}
		return user;//user - Detached  from L1 cache
	}
	

}
