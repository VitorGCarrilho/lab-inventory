package br.unisal.labinventory.labinventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LabInventoryController {
	
	@GetMapping("")
	public String home(){
		return "home/index";
	}
}
