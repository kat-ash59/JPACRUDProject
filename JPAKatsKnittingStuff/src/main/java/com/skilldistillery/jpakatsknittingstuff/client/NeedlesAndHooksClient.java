package com.skilldistillery.jpakatsknittingstuff.client;

import com.skilldistillery.jpakatsknittingstuff.data.CRUDDAOImpl;
import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NeedlesAndHooksClient 
{
	private static EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("KatsKnittingStuff");
	
	public static void main(String[] args) 
	{
	   
		CRUDDAOImpl dao = new CRUDDAOImpl();
		NeedlesAndHooks initialHookOrNeedle = new NeedlesAndHooks();
		NeedlesAndHooks newlyAddedHookOrNeedle =  new NeedlesAndHooks(); 
		NeedlesAndHooks updatedHookOrNeedle =  new NeedlesAndHooks(); 
		Boolean didItDelete = false;
		int newId = 0;
		int didItUpdate = 0;
		  
		initialHookOrNeedle.setLength(9.5);
		initialHookOrNeedle.setMaterial("bamboo");
		initialHookOrNeedle.setUsSize("7");
		initialHookOrNeedle.setMetricSize("4.5mm");
		initialHookOrNeedle.setType("Straight");
		initialHookOrNeedle.setQuantity(6);
			  
		newlyAddedHookOrNeedle = dao.addNewHooksNeedlesOrCables(initialHookOrNeedle);
			  
		System.out.println("\n\nNewly added knitting Needle = " + newlyAddedHookOrNeedle.toString());
			  
			  
		newId = newlyAddedHookOrNeedle.getId();
		updatedHookOrNeedle = newlyAddedHookOrNeedle;
		updatedHookOrNeedle.setMaterial("rosewood");
		updatedHookOrNeedle.setQuantity(2);
			  
		didItUpdate  = dao.updateHooksNeedlesOrCables(newId, updatedHookOrNeedle);
			  
		if (didItUpdate == 1)
		{
			System.out.println("\n\nnewly updated needle = " + updatedHookOrNeedle.toString());
		}
			  
			  
		didItDelete = dao.destroyHooksNeedlesCables(newId);
			  
		if (didItDelete)
		{
			System.out.println("\n\nsuccessfully deleted needle");
		}
		
		emf.close();
	}
}