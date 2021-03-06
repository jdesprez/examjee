package com.ninja_squad.geektic.core;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="geek")
public class Geek
{
	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	@Column(name="nom")
	String nom;
	@Column(name="prenom")
	String prenom;
	@Column(name="adrmail")
	String adrMail;
	@ManyToMany
	@JoinTable(name="centreinteretgeek",
	joinColumns = @JoinColumn(name="idgeek"),
	inverseJoinColumns = @JoinColumn(name="idcentreinteret"))
	List<CentreInteret> listInterets;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	Genre genre;	
	@Formula("(select Count(*) from audit join geek on (audit.geek = geek.id) where geek.id = id)")
	private int consult; // nombre de fois que le profil de ce geek � �t� consult�
	
	public Geek()
	{
		this.nom = "na";
		this.prenom = "na";
		this.adrMail = "na";
		this.genre = Genre.HOMME;
	}
	
	public Geek(String nom, String prenom, String adrMail, Genre genre)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adrMail = adrMail;
		this.genre = genre;
	}
	
	public boolean addCentreInteret(CentreInteret ci)
	{
		return listInterets.add(ci);
	}
	
	public boolean removeCentreInteret(CentreInteret ci)
	{
		return listInterets.remove(ci);
	}
	
	public void incrementConsult()
	{
		consult++;
	}
	
	public int getConsult()
	{
		return consult;
	}

	public void setConsult(int consult)
	{
		this.consult = consult;
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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public String getAdrMail()
	{
		return adrMail;
	}

	public void setAdrMail(String adrMail)
	{
		this.adrMail = adrMail;
	}

	public List<CentreInteret> getListInterets()
	{
		return listInterets;
	}

	public void setListInterets(List<CentreInteret> listInterets)
	{
		this.listInterets = listInterets;
	}

	public Genre getGenre()
	{
		return genre;
	}

	public void setGenre(Genre genre)
	{
		this.genre = genre;
	}	
}