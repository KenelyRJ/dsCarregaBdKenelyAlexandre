package carregabanco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import carregabanco.model.AlunoModel;

public class AlunoDao <Model>{

	private static AlunoDao instance;
	protected EntityManager entityManager;

	private AlunoDao() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public static AlunoDao getInstance() {
		if (instance == null) {
			instance = new AlunoDao();
		}
		return instance;
	}

	public AlunoModel getById(final long id) {
		return entityManager.find(AlunoModel.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AlunoModel> findAll(Class<Model> c) {
		return entityManager.createQuery("FROM " + AlunoModel.class.getName()).getResultList();
	}
//salvar
	public void persist(AlunoModel model) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(model);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
//update
	public void merge(AlunoModel model) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(model);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(AlunoModel model) {
		try {
			entityManager.getTransaction().begin();
			model = entityManager.find(AlunoModel.class, model.getIdPessoa());
			entityManager.remove(model);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final long id) {
		try {
			AlunoModel model = getById(id);
			remove(model);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}