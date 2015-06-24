package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.core.Genre;
import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.dao.IGeekDao;

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

	@Autowired
	public GeekDao geekDao;

	@RequestMapping(method = GET)
	public List<Geek> printList()
	{	
		return geekDao.findAll();
	}
}
