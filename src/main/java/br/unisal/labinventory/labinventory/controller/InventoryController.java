package br.unisal.labinventory.labinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unisal.labinventory.labinventory.model.Product;
import br.unisal.labinventory.labinventory.service.ProductService;

@Controller
@RequestMapping("inventario")
public class InventoryController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("inventory/inventory");
		List<Product> products = productService.findAll();
		mv.addObject("products", products);
		return mv;
	}
}
