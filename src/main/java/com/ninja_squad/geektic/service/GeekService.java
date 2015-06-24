package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.dao.GeekDaoFake;
import com.ninja_squad.geektic.dao.IGeekDao;

//@org.springframework.stereotype.Service
@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService
{
	@Autowired
	public IGeekDao geekDao;
	
	public GeekService()
	{
		//geekDao = new GeekDaoFake();
		//geekDao = new GeekDao();
	}
	
	public boolean createGeek(Geek g)
	{
		boolean bRet = false;
		
		geekDao.persist(g);
		
		return bRet;
	}
	
	@RequestMapping(value="/{geekId}", method = GET)
	public Geek findGeek(@PathVariable("geekId") long id) 
	{
		System.out.print("findGeek");
		return geekDao.findById(id);
	}

//	
//	@RequestMapping(method = GET)
//	public Geek printGeek(@RequestParam(value = "id") Long id )
//	{
//		Geek g = new Geek("Nom","Prenom","toto@gmail.com", Genre.HOMME);
//		
//		return g;
//	}
	
//	@RequestMapping(method = GET)
//	public Geek printGeek()
//	{
//		Geek g = new Geek("Nom","Prenom","toto@gmail.com", Genre.HOMME);
//		
//		CentreInteret ci1 = new CentreInteret();
//		ci1.setNom("JAVA");
//		CentreInteret ci2 = new CentreInteret();
//		ci2.setNom("C#");
//		CentreInteret ci3 = new CentreInteret();
//		ci3.setNom("Archi N-Tiers");
//		
//		ArrayList<CentreInteret> listRet = new ArrayList<CentreInteret>();
//		
//		listRet.add(ci1);
//		listRet.add(ci2);
//		listRet.add(ci3);
//		
//		g.setListInterets(listRet);
//		
//		return g;
//	}
}
