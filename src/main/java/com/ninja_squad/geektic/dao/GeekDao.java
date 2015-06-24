package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.ninja_squad.geektic.core.Geek;

@Repository
public class GeekDao implements IGeekDao
{
	@PersistenceContext
	public EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
//	public GeekDao(EntityManager em)
//	{
//		this.em = em;
//	}
	
	public GeekDao()
	{
	}

	public Geek findById(Long id)
	{
		return em.find(Geek.class, id);
	}

	public void persist(Geek g)
	{
		em.persist(g);
	}
	
    public List<Geek> findAll(){
        String query = "SELECT g FROM geek g";
        return em.createQuery(query, Geek.class).getResultList();
    }
}
