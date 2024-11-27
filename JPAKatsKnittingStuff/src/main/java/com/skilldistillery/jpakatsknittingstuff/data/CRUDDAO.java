package com.skilldistillery.jpakatsknittingstuff.data;

import java.util.List;

import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;


public interface CRUDDAO 
{
	public NeedlesAndHooks addNewHooksNeedlesOrCables(NeedlesAndHooks newHookOrNeedle);

	public Boolean destroyHooksNeedlesCables(int id);

	int updateHooksNeedlesOrCables(int id,NeedlesAndHooks newHookOrNeedle);
	
}
