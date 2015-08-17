package com.ejemplo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.model.User;

@Controller
public class UserRestController {
	private User getUser() {
		User user = new User();
		user.setName("Nombre Usuario");
		user.setId(123);
		return user;
	}

	private List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setName("Nombre Usuario");
		user.setId(123);
		User user2 = new User();
		user2.setName("Nombre Usuario 2");
		user2.setId(1234);
		users.add(user);
		users.add(user2);
		return users;
	}

	@RequestMapping(value = "/user")
	public String getUserJSON(Model model) {
		model.addAttribute("user", getUser());
		//jsonTemplate se configura en spring-servlet.xml
		return "jsonTemplate";
	} 
	 
	@RequestMapping(value = "/users")
	public String getUsersJSON(Model model) {
		model.addAttribute("user", getUsers());
		return "jsonTemplate";
	}

}
