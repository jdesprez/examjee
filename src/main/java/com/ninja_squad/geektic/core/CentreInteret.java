package com.ninja_squad.geektic.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CentreInteret
{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	@Column(name="nom")
	String nom;
	
	public CentreInteret()
	{
		
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
}
