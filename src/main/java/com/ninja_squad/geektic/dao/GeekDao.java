package com.ninja_squad.geektic.dao;

import javax.persistence.EntityManager;

import com.ninja_squad.geektic.core.Geek;

public class GeekDao
{

	public EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public GeekDao(EntityManager em)
	{
		this.em = em;
	}

	public Geek findById(Long id)
	{
		return em.find(Geek.class, id);
	}

	public void persist(Geek g)
	{
		em.persist(g);
	}

}
