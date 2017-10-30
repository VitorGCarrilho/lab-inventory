package br.unisal.labinventory.labinventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView userForm(@RequestParam(value = "success", required=false) boolean success, User user){
		ModelAndView mv = new ModelAndView("user/register-user-form").addObject("userTypes", UserType.values()).addObject("user",user);
		return mv.addObject("success",success);
	}
	
	@PostMapping
	public ModelAndView saveUser(@Valid User user, BindingResult result){
		if(result.hasErrors()){
			return userForm(false, user);
		}
		try {
			userService.save(user);
		} catch (DataIntegrityViolationException e){
			result.addError(new ObjectError("error", "A integridade de um dos campos foi violada"));
			return userForm(false, user);
		}
		return new ModelAndView("redirect:/usuario?success=true");
	}
}
