package com.divya.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.divya.dao.UserDao;
import com.divya.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	/*
	 * Lists all the Users.
	 */
	public List<UserDetails> getUserDetails() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserDetails.class);
		return criteria.list();
	}

	/*
	 * Adds the User to User table
	 * Param: UserDetails
	 */
	public void saveOrUpdate(UserDetails User) {
		session().saveOrUpdate(User);
	}

	/*
	 * Finds the User based on id.
	 * Param: id
	 */
	public UserDetails findById(String id) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(UserDetails.class);
    criteria.add(Restrictions.idEq(id));

    return (UserDetails) criteria.uniqueResult();
	}
}
