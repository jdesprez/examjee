package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import com.ninja_squad.geektic.core.CentreInteret;
import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.core.Genre;

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
    
    public List<Geek> findByInteret(String nomCentreInteret){
        String query = "SELECT DISTINCT g FROM geek g JOIN g.listInterets i WHERE i.nom = :centreinteret)";

        return em.createQuery(query, Geek.class)
                .setParameter("centreinteret", nomCentreInteret)
                .getResultList();
    }
    
    public List<Geek> findByGenre(Genre genre)
    {
        String query = "SELECT DISTINCT g FROM geek g WHERE g.genre = :genre";

        return em.createQuery(query, Geek.class)
                .setParameter("genre", genre.name())
                .getResultList();
    }
    
    public List<Geek> findByGenreAndInterest(Genre genre, String nomCentreInteret){
               String query = "SELECT DISTINCT g FROM geek g JOIN g.listInterets i WHERE g.genre = :genre AND i.nom = :nomCentreInteret";

        return em.createQuery(query, Geek.class)
                .setParameter("nomCentreInteret", nomCentreInteret)
                .setParameter("genre", genre.name())
                .getResultList();
    }
}
