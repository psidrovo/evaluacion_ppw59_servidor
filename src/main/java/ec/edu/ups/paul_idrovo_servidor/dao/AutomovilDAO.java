package ec.edu.ups.paul_idrovo_servidor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.paul_idrovo_servidor.model.Automovil;

@Stateless
public class AutomovilDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void  insert(Automovil a) {
		em.persist(a);
	}
	
	public void  update(Automovil a) {
		em.merge(a);
	}
	
	public Automovil read(String placa) {
		Automovil p = em.find(Automovil.class, placa);
		return p;
	}
	
	public void  delete(String cedula) {
		Automovil a = em.find(Automovil.class, cedula);
		em.remove(a);
	}
	
	public List<Automovil> getList(){
		String jpql = "Select a From Automovil a";
		
		Query q = em.createQuery(jpql, Automovil.class);
		
		return q.getResultList();
	}
	
	public List<Automovil> getListNombre(String filtro){
		String jpql = "Select a From Persona a" + " where placa LIKE ?1";
		
		Query q = em.createQuery(jpql, Automovil.class);
		q.setParameter(1,filtro);
		return q.getResultList();
	}
}
