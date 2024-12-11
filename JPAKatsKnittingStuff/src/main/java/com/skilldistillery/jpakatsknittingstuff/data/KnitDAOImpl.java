package com.skilldistillery.jpakatsknittingstuff.data;


import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;

public class KnitDAOImpl implements KnitDAO 
{
	private EntityManagerFactory emf =
	        Persistence.createEntityManagerFactory("KatsKnittingStuff");

	  @Override
	  public int updateHooksNeedlesOrCables(int id, NeedlesAndHooks newHookOrNeedle) 
	  {
	    
	    EntityManager em = emf.createEntityManager();
	    
	    // start the transaction
	    em.getTransaction().begin();
	    
	    NeedlesAndHooks managed = em.find(NeedlesAndHooks.class, id);
	    managed.setMaterial(newHookOrNeedle.getMaterial());
	    managed.setType(newHookOrNeedle.getType());
	    managed.setLength(newHookOrNeedle.getLength());
	    managed.setUsSize(newHookOrNeedle.getUsSize());
	    managed.setMetricSize(newHookOrNeedle.getMetricSize());
	    managed.setQuantity(newHookOrNeedle.getQuantity());
	  
	        
	    // update item
	    em.persist(managed);
	    
	    // commit the changes (actually perform the operation)
	    em.getTransaction().commit();
	    	    
	    em.close();
	    return 1;
	    
	  }

	
	@Override
	public NeedlesAndHooks addNewHooksNeedlesOrCables(NeedlesAndHooks newHookOrNeedle) {
		
		EntityManager em = emf.createEntityManager();
	    
		 // start the transaction
	    em.getTransaction().begin();		
		
		// write the new Address to the database
	    em.persist(newHookOrNeedle);
   
	    // update the "local" Address object
		em.flush();

	    // commit the changes (actually perform the operation)
	    em.getTransaction().commit();

	    newHookOrNeedle = em.find(NeedlesAndHooks.class, newHookOrNeedle.getId());
	    
	    // return the Address object
	    em.close();
	    return newHookOrNeedle;

	}

	@Override
	public Boolean destroyHooksNeedlesCables(int id) 
	{
		
		    EntityManager em = emf.createEntityManager();
		    
		    boolean wasDeleted = false;

		    
		    // find the address by id
		    NeedlesAndHooks managed = em.find(NeedlesAndHooks.class, id);
		    
		    if (managed != null)
		    {
			    // start the transaction
			    em.getTransaction().begin();
			    
			    // remove the actor from the database
			    em.remove(managed);
			    
			    //wasDeleted = true;
			    
			    // commit the changes (actually perform the operation)
			    em.getTransaction().commit();
			    
			    
		    }

		    wasDeleted = !em.contains(managed);
		    
		    em.close();
		    // return the Address deleted
		    return wasDeleted;

	}

	
}