package com.skilldistillery.bootknit.data;

import java.util.List;

import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;


public interface KnitDAO 
{
	public NeedlesAndHooks addNewHooksNeedlesOrCables(NeedlesAndHooks newHookOrNeedle);

	public Boolean destroyHooksNeedlesCables(int id);

	Boolean updateHooksNeedlesOrCables(int id,NeedlesAndHooks newHookOrNeedle);

	public NeedlesAndHooks findById(int id);

	public List<NeedlesAndHooks> findAllNeedlesAndHooks();

	public List<NeedlesAndHooks> findItemsByKeyword(String keyword);
	
}
