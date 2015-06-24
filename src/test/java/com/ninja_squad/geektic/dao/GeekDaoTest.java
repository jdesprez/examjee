package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.core.CentreInteret;
import com.ninja_squad.geektic.core.Geek;
import com.ninja_squad.geektic.core.Genre;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
@Transactional
public class GeekDaoTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
     @Autowired
     private GeekDao geekDao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
        		CommonOperations.DELETE_ALL_TABLE,
        		CommonOperations.INSERT_GEEK_DATA,
        		CommonOperations.INSERT_PREFENRENCE_DATA,
        		CommonOperations.INSERT_PREFENRENCE_GEEK_DATA);
        
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void findByIdTest() {
		Geek g = geekDao.findById(1L);
		
		assertEquals(1L, g.getId().longValue());
    }

    @Test
    public void testFindAll()
    {
    	List<Long> expected = new ArrayList<>();
    	expected.add(1L);
    	expected.add(2L);
    	Collections.sort(expected);
    	
    	List<Geek> listGeeks = geekDao.findAll();
    	List<Long> response = new ArrayList<>();
    	for(Geek g : listGeeks)
    		response.add(g.getId());
    	Collections.sort(response);
    	
    	assertEquals(expected, response);
    }
    
    @Test
    public void findByCentreInteret()
    {
    	CentreInteret ci = new CentreInteret();
    	ci.setId(1L);
    	ci.setNom("C#");
    	
        List<Long> expected = new ArrayList<>();
    	expected.add(1L);
    	expected.add(2L);
    	Collections.sort(expected);
    	
    	List<Geek> listGeeks = geekDao.findByInteret("C#");
    	List<Long> response = new ArrayList<>();
    	for(Geek g : listGeeks)
    		response.add(g.getId());
    	Collections.sort(response);
    	
    	assertEquals(expected, response);
    }
    
//    @Test
//    public void addNewGeekTest()
//    {
//    	int iLenList = geekDao.findAll().size();
//    	
//    	Geek g = new Geek("Nouveau", "ajout","nouveaugeek@geektic.com",Genre.HOMME);
//    	
//    	geekDao.persist(g);
//    	
//    	int iLenNewList = geekDao.findAll().size();
//    	
//    	assertEquals(iLenList + 1, iLenNewList);
//    }
}
