package br.unisal.labinventory.labinventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public ModelAndView userForm(User user){
		ModelAndView mv = new ModelAndView("user/register-user-form").addObject("userTypes", UserType.values()).addObject("user",user);
		return mv;
	}
	
	@PostMapping
	public ModelAndView saveUser(@Valid User user, BindingResult result){
		if(result.hasErrors()){
			return userForm(user);
		}
		userService.save(user);
		return new ModelAndView("redirect:/");
	}
}
