package com.skilldistillery.bootknit.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class KnitDAOImpl implements KnitDAO {
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public NeedlesAndHooks findById(int id)
	{
		NeedlesAndHooks needleAndHook = em.find(NeedlesAndHooks.class, id);
		return needleAndHook;
	}
	
	@Override
	public List<NeedlesAndHooks> findAllNeedlesAndHooks()
	{
		List<NeedlesAndHooks> needleAndHookList = new ArrayList<>();
		String jpql = "Select needlesAndHooks from NeedlesAndHooks needlesAndHooks";
		
		needleAndHookList = em.createQuery(jpql, NeedlesAndHooks.class).getResultList();
		System.out.println(needleAndHookList.toString());
		return needleAndHookList;
	}
	
	@Override
	public List<NeedlesAndHooks> findItemsByKeyword(String keyword)
	{
		List<NeedlesAndHooks> needleAndHookList = new ArrayList<>();
		Query query = null;
		String jpql = "Select needlesAndHooks from NeedlesAndHooks needlesAndHooks where type like :keyword";
		
		query = em.createQuery(jpql, NeedlesAndHooks.class);
		query.setParameter("keyword", "%" +  keyword + "%");
	
		needleAndHookList = query.getResultList();
		
		return needleAndHookList;
	}
	
	@Override
	public Boolean updateHooksNeedlesOrCables(int id, NeedlesAndHooks newHookOrNeedle) {

		NeedlesAndHooks managed = em.find(NeedlesAndHooks.class, id);
		managed.setMaterial(newHookOrNeedle.getMaterial());
		managed.setType(newHookOrNeedle.getType());
		managed.setLength(newHookOrNeedle.getLength());
		managed.setUsSize(newHookOrNeedle.getUsSize());
		managed.setMetricSize(newHookOrNeedle.getMetricSize());
		managed.setQuantity(newHookOrNeedle.getQuantity());

		// update item
		em.persist(managed);

		return true;

	}

	@Override
	public NeedlesAndHooks addNewHooksNeedlesOrCables(NeedlesAndHooks newHookOrNeedle) {

		// write the new Address to the database
		em.persist(newHookOrNeedle);

		newHookOrNeedle = em.find(NeedlesAndHooks.class, newHookOrNeedle.getId());

		// return the Address object
		return newHookOrNeedle;

	}

	@Override
	public Boolean destroyHooksNeedlesCables(int id) {

		boolean wasDeleted = false;

		// find the address by id
		NeedlesAndHooks managed = em.find(NeedlesAndHooks.class, id);

		if (managed != null) {

			// remove the actor from the database
			em.remove(managed);

		}

		wasDeleted = !em.contains(managed);

		// return the Address deleted
		return wasDeleted;

	}
	
	

}