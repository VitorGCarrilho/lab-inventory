package br.unisal.labinventory.labinventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unisal.labinventory.labinventory.model.User;
import br.unisal.labinventory.labinventory.model.enumeration.UserType;
import br.unisal.labinventory.labinventory.service.UserService;

@Controller
@RequestMapping("usuario")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView userForm(){
		ModelAndView mv = new ModelAndView("user/register-user-form").addObject("userTypes", UserType.values());
		return mv;
	}
	
	@PostMapping
	public ModelAndView saveUser(User user){
		userService.save(user);
		return new ModelAndView("redirect:/");
	}
}
