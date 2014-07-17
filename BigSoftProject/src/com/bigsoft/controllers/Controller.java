/**
 * 
 */
package com.bigsoft.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigsoft.model.Users;

/**
 * @author Mishchuk_AA
 *
 */
public class Controller {
	
	@RequestMapping(value="/auth", method=RequestMethod.GET)
	public ModelAndView administrating(Model model){
		ModelAndView view = new ModelAndView();
		Users users = new Users();
		view.addObject("listOfUsers", users.getAllUsers());
		view.setViewName("Admin");
		return view;
	}
}
