package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.core.CentreInteret;
import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.core.Genre;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class ExampleDaoTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
     @Autowired
     private GeekDao exampleDao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(CommonOperations.DELETE_ALL, CommonOperations.INSERT_REFERENCE_DATA);
        
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void findByIdTest() {
		Geek g = exampleDao.findById(1L);
		
		assertEquals(1L, g.getId().longValue());
    }
    
    @Test
    public void insertTest() {
		Geek g = new Geek("Nom", "Prenom", "toto@gmail.com", Genre.HOMME);

		g.setId(42L);
		
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

		g.setListInterets(listRet);
		
		// on enregistre en BDD
		exampleDao.persist(g);
		
		// on essaie de le recup
		Geek g2 = exampleDao.findById(42L);
		
		assertEquals(42L, g2.getId().longValue());
    }
    
    @Test
    public void testFindAll() {
        List<Long> expected = Arrays.asList(1L, 2L);
        Collections.sort(expected);
        List<Geek> response = exampleDao.findAll();
        Collections.sort(response);

        assertEquals(expected, response);
    }
}
