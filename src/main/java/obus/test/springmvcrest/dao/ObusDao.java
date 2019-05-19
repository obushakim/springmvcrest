package obus.test.springmvcrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import obus.test.springmvcrest.model.Obus;

@Repository("obusDao")
public class ObusDao {

	@Autowired
	@Qualifier(value = "getSessionFactory")
	private SessionFactory sessionFactory;

	@PersistenceContext(unitName = "myJpaPersistenceUnit")
	@Qualifier(value = "entityManagerFactory")
	private EntityManager entityManager;

	public List<Obus> getObuses() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Obus> cq = cb.createQuery(Obus.class);
		Root<Obus> root = cq.from(Obus.class);
		cq.select(root);
		Query<Obus> query = session.createQuery(cq);

		return query.getResultList();

	}

	public List<Obus> getObusData() {
		javax.persistence.Query query = entityManager.createQuery("FROM Obus as obus ORDER BY obus.id");

		return query.getResultList();
	}
}
