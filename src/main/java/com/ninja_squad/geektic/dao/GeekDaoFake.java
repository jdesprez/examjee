package com.ninja_squad.geektic.dao;

import java.util.ArrayList;

import com.ninja_squad.geektic.core.CentreInteret;
import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.core.Genre;

public class GeekDaoFake implements IGeekDao
{

	@Override
	public Geek findById(Long id)
	{
		Geek g = null;
		if (id == 22)
		{
			g = new Geek("Nom", "Prenom", "toto@gmail.com", Genre.HOMME);

			g.setId(22L);
			
			CentreInteret ci1 = new CentreInteret();
			ci1.setNom("JAVA");
			CentreInteret ci2 = new CentreInteret();
			ci2.setNom("C#");
			CentreInteret ci3 = new CentreInteret();
			ci3.setNom("Archi N-Tiers");

//			ArrayList<CentreInteret> listRet = new ArrayList<CentreInteret>();
//
//			listRet.add(ci1);
//			listRet.add(ci2);
//			listRet.add(ci3);
//
//			g.setListInterets(listRet);
		}
		return g;
	}

	@Override
	public void persist(Geek g)
	{
		// TODO Auto-generated method stub

	}

}
