package com.ninja_squad.geektic.dao;

import com.ninja_squad.geektic.core.Geek;

public interface IGeekDao
{
	public Geek findById(Long id);

	public void persist(Geek g);
}
