package com.skilldistillery.jpakatsknittingstuff.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.skilldistillery.jpakatsknittingstuff.data.CRUDDAO;
import com.skilldistillery.jpakatsknittingstuff.data.CRUDDAOImpl;
import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class CRUDDAOImplTest 
{
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static CRUDDAO dao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		emf = Persistence.createEntityManagerFactory("KatsKnittingStuff");
		em = emf.createEntityManager();
		dao = new CRUDDAOImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		em = emf.createEntityManager();
		dao = null;
		em.close();
		emf.close();
	}

	@Test
	void test_addNeedleOrHook_ModifyNeedleOrHook_deleteNeedleOrHook() {
		
		
		
		NeedlesAndHooks toAddNeedlesAndHooks = new NeedlesAndHooks();
		NeedlesAndHooks newlyAddedNeedlesAndHooks = new NeedlesAndHooks();
		NeedlesAndHooks updatedNeedlesAndHooks = new NeedlesAndHooks();
		
		toAddNeedlesAndHooks.setLength(9.5);
		toAddNeedlesAndHooks.setMaterial("bamboo");
		toAddNeedlesAndHooks.setUsSize("7");
		toAddNeedlesAndHooks.setMetricSize("4.5mm");
		toAddNeedlesAndHooks.setType("Straight");
		toAddNeedlesAndHooks.setQuantity(6);
		newlyAddedNeedlesAndHooks = dao.addNewHooksNeedlesOrCables(toAddNeedlesAndHooks);
		assertNotNull(newlyAddedNeedlesAndHooks);
		assertEquals("bamboo", newlyAddedNeedlesAndHooks.getMaterial());
		
		
		updatedNeedlesAndHooks = em.find(NeedlesAndHooks.class, newlyAddedNeedlesAndHooks.getId());
		updatedNeedlesAndHooks.setMaterial("rosewood");
		updatedNeedlesAndHooks.setQuantity(2);
		int didItUpdate = dao.updateHooksNeedlesOrCables(newlyAddedNeedlesAndHooks.getId(), updatedNeedlesAndHooks);
		assertEquals(didItUpdate, 1);
		
		boolean deleted = dao.destroyHooksNeedlesCables(newlyAddedNeedlesAndHooks.getId());
		assertTrue(deleted);
	}

}