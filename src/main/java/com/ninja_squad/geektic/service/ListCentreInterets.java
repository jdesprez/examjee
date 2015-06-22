package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.core.CentreInteret;

@RestController
@Transactional
@RequestMapping("/api/listci")
public class ListCentreInterets
{
		@RequestMapping(method = GET)
		public List<CentreInteret> printList()
		{
			CentreInteret ci1 = new CentreInteret();
			ci1.setNom("JAVA");
			CentreInteret ci2 = new CentreInteret();
			ci2.setNom("C#");
			CentreInteret ci3 = new CentreInteret();
			ci3.setNom("Archi N-Tiers");
			
			ArrayList<CentreInteret> listRet = new ArrayList<CentreInteret>();
			
			listRet.add(ci1);
			listRet.add(ci2);
			listRet.add(ci3);
			
			return listRet;
		}
}
