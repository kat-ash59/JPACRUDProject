package com.skilldistillery.bootknit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.bootknit.data.KnitDAO;
import com.skilldistillery.jpakatsknittingstuff.entities.NeedlesAndHooks;

@Controller
public class KnitController 
{
	private final KnitDAO dao;

	public KnitController(KnitDAO dao)
	{
		this.dao = dao;
	}
	
	@GetMapping(path = { "/", "home.do", "index.do" })
	public String index(Model model) {
		List<NeedlesAndHooks> needlesAndHooksList = dao.findAllNeedlesAndHooks();
		model.addAttribute("needlesAndHooksList",needlesAndHooksList);
		return "home";
	}
	
	@GetMapping("getNeedleOrHookById.do")
	public ModelAndView findById(@RequestParam("needleOrHook" ) int id ) 
	{
		ModelAndView mv = new ModelAndView();
		NeedlesAndHooks theNeedle = dao.findById(id);
		mv.addObject("needleOrHook", theNeedle);
		mv.setViewName("show");
		return mv;
	}
	
	@GetMapping("getAllNeedlesAndHooks.do")
	public ModelAndView findAllFilms() {
		ModelAndView mv = new ModelAndView();
		List<NeedlesAndHooks> needleAndHookList = new ArrayList<>();
		needleAndHookList = dao.findAllNeedlesAndHooks();
		
		mv.addObject("needlesAndHooks", needleAndHookList);
		mv.setViewName("showNeedlesAndHooks");
		return mv;
	}
	
	@GetMapping("updateNeedleOrHook.do")
	public ModelAndView updateHooksNeedlesOrCables(NeedlesAndHooks theNeedle)
	{
		ModelAndView mv = new ModelAndView();
		Boolean successfulUpdate = false;
		
		try
		{
			NeedlesAndHooks needle = dao.findById(theNeedle.getId());
			
			if ((theNeedle.getMaterial() != null) && (!theNeedle.getMaterial().isEmpty()) || (!theNeedle.getMaterial().isBlank()))
			{
				needle.setMaterial(theNeedle.getMaterial());
			}
			
			if ((theNeedle.getType() != null) && (!theNeedle.getType().isEmpty()) || (!theNeedle.getType().isBlank()))
			{
				needle.setType(theNeedle.getType());
			}
			
			if(theNeedle.getLength() != 0)
			{
				needle.setLength(theNeedle.getLength());
			}
			
			if ((theNeedle.getUsSize() != null) && (!theNeedle.getUsSize().isEmpty()) && (!theNeedle.getUsSize().isBlank()))
			{
				needle.setUsSize(theNeedle.getUsSize());
			}
			
			if ((theNeedle.getMetricSize() != null) && (!theNeedle.getMetricSize().isEmpty()) && (!theNeedle.getMetricSize().isBlank()))
			{
				needle.setMetricSize(theNeedle.getMetricSize());
			}
			
			if(theNeedle.getQuantity() != 0)
			{
				needle.setQuantity(theNeedle.getQuantity());
			}
			
			successfulUpdate = dao.updateHooksNeedlesOrCables(needle.getId(), needle);
			
			if (successfulUpdate)
			{
				mv.addObject("isSuccess", successfulUpdate);
				mv.addObject("needleOrHook", needle);
				mv.setViewName("confirmNeedleOrHookUpdate");
			}
			else
			{
				mv.addObject("isSuccess", false);
				mv.setViewName("confirmNeedleOrHookUpdate");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		return mv;
	}
	
	@GetMapping(path="updateNeedleOrHookGetInfo.do")
	public ModelAndView updateNeedleOrHookGetInfo(@RequestParam("id") int id   )
	{
		NeedlesAndHooks theNeedle = null;
		ModelAndView mv = new ModelAndView();
		
		if (id != 0)
		{
			try
			{
				theNeedle = dao.findById(id);
				mv.addObject("needleOrHook", theNeedle);
				mv.setViewName("updateNeedleOrHook");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
			}
		}
		else
		{
			mv.addObject("needleOrHook", theNeedle);
			mv.setViewName("updateNeedleOrHook");
		}
		
		return mv;
	}  // end get info for edit update Needle Hook or Cable by id
	
	

	
	@GetMapping(path="deleteHookOrNeedle.do", params="id")
	public ModelAndView deleteFilm(@RequestParam("id") int id)
	{
		Boolean successfulDelete = false;
		ModelAndView mv = new ModelAndView();
		
		
		try
		{
			successfulDelete = dao.destroyHooksNeedlesCables(id);
			if (successfulDelete)
			{
				mv.addObject("isSuccess", successfulDelete);
				mv.setViewName("confirmNeedleOrHookDelete");
			}
			else
			{
				mv.addObject("isSuccess", false);
				mv.setViewName("confirmNeedleOrHookDelete");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		return mv;
	}  // end delete needle, hook or cable
	
	@GetMapping(path="createNeedleHookOrCable.do")
	public ModelAndView addNewHooksNeedlesOrCables(@RequestParam("material") String material,
													@RequestParam("type") String type,
													@RequestParam("length") double length,
													@RequestParam("usSize") String usSize,
													@RequestParam("metricSize") String metricSize,
													@RequestParam("quantity") int quantity)
	{
		ModelAndView mv = new ModelAndView();
		Boolean successfulUpdate = false;
		NeedlesAndHooks theNeedle = new NeedlesAndHooks();
		NeedlesAndHooks theNewNeedle = null;
		
		try
		{

			
			if ((material != null) && (!material.isEmpty()) || (!material.isBlank()))
			{
				theNeedle.setMaterial(material);
			}
			
			if ((type != null) && (!type.isEmpty()) || (!type.isBlank()))
			{
				theNeedle.setType(type);
			}
			
			if(length != 0)
			{
				theNeedle.setLength(length);
			}
			
			if ((usSize != null) && (!usSize.isEmpty()) || (!usSize.isBlank()))
			{
				theNeedle.setUsSize(usSize);
			}
			
			if ((metricSize != null) && (!metricSize.isEmpty()) || (!metricSize.isBlank()))
			{
				theNeedle.setMetricSize(metricSize);
			}
			
			if(quantity != 0)
			{
				theNeedle.setQuantity(quantity);
			}
			
			theNewNeedle = dao.addNewHooksNeedlesOrCables(theNeedle);
			mv.addObject("needleOrHook", theNewNeedle);
			mv.setViewName("show");
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		return mv;
	}  // end add needle, hook or cable to database
	
	
	@GetMapping(path="findItemsByKeyword.do", params="keyword")
	public ModelAndView findItemsByKeyword(@RequestParam("keyword") String keyword)
	{
		List<NeedlesAndHooks> itemList = null;
		ModelAndView mv = new ModelAndView();
		
		if ((keyword != null) && (!keyword.isEmpty()) || (!keyword.isBlank()))
		{
		
			try
			{
				itemList = dao.findItemsByKeyword(keyword);
				mv.addObject("needlesAndHooks", itemList);
				mv.setViewName("showNeedlesAndHooks");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
			}
		}
		else
		{
			mv.addObject("needlesAndHooks", itemList);
			mv.setViewName("showNeedlesAndHooks");
		}
		
		return mv;
	}  // end search for film by keyword
	

}
