/**
 * 
 */
package com.bigsoft.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.bigsoft.entity.RoleEntity;
import com.bigsoft.entity.UserEntity;
import com.bigsoft.model.Role;
import com.bigsoft.model.User;



@Controller
public class AdminController {
	
	@RequestMapping(value="/auth", method=RequestMethod.GET)
	public ModelAndView administrating(Model model){
		ModelAndView view = new ModelAndView();
		User users = new User();
		view.addObject("listOfUsers", users.getAllUsers());
		view.setViewName("Admin");
		return view;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(Model model){
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public ModelAndView addUser(Model model){
		Role role = new Role();
		ModelAndView view = new ModelAndView();
		
		ArrayList<Role> roles = new ArrayList<Role>();
		for(RoleEntity ent : role.getAllRoles()){
			String select = "";
			roles.add(new Role(ent.getId(), ent.getName(), select));
		}

		view.addObject("listOfRoles", roles);
		view.addObject("button", "Add user");
		view.addObject("action", "/BigSoftProject/adduser/save");
		view.setViewName("User");
		return view;
	}

	@RequestMapping(value="/adduser/save", method=RequestMethod.POST)
	public ModelAndView adduser(@RequestParam(value="name", required=true, defaultValue="") String name, 
			@RequestParam(value="login", required=true, defaultValue="") String login, 
			@RequestParam(value="password", required=true, defaultValue="") String password,
			@RequestParam(value="cmd", required=true, defaultValue="") String role,
			Model model){
		ModelAndView view = new ModelAndView();
		User users = new User();
		users.addUser(name, login, password, role);
		view.addObject("listOfUsers", users.getAllUsers());
		view.setViewName("Admin");
		return view;
}

	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ModelAndView remove(@RequestParam(value="cmd", required=true, defaultValue="") String id, 
			Model model){
		System.out.println("id = " + id);
		ModelAndView view = new ModelAndView();
		User users = new User();
		users.removeUser(id);
		view.addObject("listOfUsers", users.getAllUsers());
		view.setViewName("Admin");
		return view;
	}
	
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView edit(@RequestParam(value="cmd", required=true, defaultValue="") String id, 
			Model model){
		System.out.println("id = " + id);
		User users = new User();
		Role role = new Role();
		UserEntity ue = users.getUser(id);
		ArrayList<Role> roles = new ArrayList<Role>();
		for(RoleEntity ent : role.getAllRoles()){
			String select = "";
			if(ent.getId() == ue.getRole().getId())
				select = "SELECTED";
			else select = "";
			roles.add(new Role(ent.getId(), ent.getName(), select));
		}
		ModelAndView view = new ModelAndView();
		
		view.addObject("user", ue);
		view.addObject("button", "Save user");
		view.addObject("listOfRoles", roles);
		view.addObject("action", "/BigSoftProject/edit/save");
		view.setViewName("User");
		return view;
	}
	
	@RequestMapping(value="/edit/save", method=RequestMethod.POST)
	public ModelAndView editCurrentuser(@RequestParam(value="userId", required=true, defaultValue="") String id, 
			@RequestParam(value="name", required=true, defaultValue="") String name, 
			@RequestParam(value="login", required=true, defaultValue="") String login, 
			@RequestParam(value="password", required=true, defaultValue="") String password,
			@RequestParam(value="cmd", required=true, defaultValue="") String role,
			Model model){
		ModelAndView view = new ModelAndView();
		User users = new User();
		users.editUser(id, name, login, password, role);
		view.addObject("listOfUsers", users.getAllUsers());
		view.setViewName("Admin");
		return view;
}

	
	@RequestMapping(value="/auth", method=RequestMethod.POST)
		public ModelAndView authtorisation(@RequestParam(value="login", required=true, defaultValue="") String login, 
				@RequestParam(value="password", required=true, defaultValue="") String password,
				Model model){
			ModelAndView view = new ModelAndView();
			System.out.println("login = " + login);
			System.out.println("password = " + password);
			User users = new User();
			String request = users.checkUser(login, password);
			switch (request) {
			case "INVALID LOGIN/PASSWORD":
				view.setViewName("index");
				break;
     		case "1":
     			view.addObject("listOfUsers", users.getAllUsers());
				view.setViewName("Admin");
				break;
    		case "4":
				view.setViewName("Casher");
				break;
    		case "5":
				view.setViewName("Casher");
				break;
    		case "6":
				view.setViewName("Manager");
				break;
    		case "7":
				view.setViewName("Director");
				break;
			default:
				view.setViewName("index");
				break;
			}
			return view;
	}
}
