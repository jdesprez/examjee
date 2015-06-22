package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.core.Genre;

@RestController
@Transactional
@RequestMapping("/api/listgeeks")
public class ListGeeksService
{

//	@RequestMapping(method = GET)
//	public ListGeeksDisplay printList()
//	{
//		return new ListGeeksDisplay();
//	}


	@RequestMapping(method = GET)
	public List<Geek> printList()
	{
		Geek g1 = new Geek("Nom","Prenom","toto@gmail.com", Genre.HOMME);
		Geek g2 = new Geek("Quelqun","Dautre","personne@gmail.com", Genre.HOMME);
		Geek g3 = new Geek("toto","tata","tototata@gmail.com", Genre.FEMME);
		
		ArrayList<Geek> listRet = new ArrayList<Geek>();
		
		listRet.add(g1);
		listRet.add(g2);
		listRet.add(g3);
		
		return listRet;
	}
}
