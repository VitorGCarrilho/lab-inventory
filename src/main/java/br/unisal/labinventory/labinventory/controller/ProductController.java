package br.unisal.labinventory.labinventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unisal.labinventory.labinventory.exception.SerialAlreadyExistException;
import br.unisal.labinventory.labinventory.model.Exclusion;
import br.unisal.labinventory.labinventory.model.Product;
import br.unisal.labinventory.labinventory.service.ProductService;

@Controller
@RequestMapping("produto")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("novo")
	public ModelAndView  registerForm(Product product){
		ModelAndView mv = new ModelAndView("product/register-product-form");
		mv.addObject("product", product);
		return mv;
	}
	
	@PostMapping("novo")
	public ModelAndView save(@Valid Product product, BindingResult result){
		if(result.hasErrors()){
			return registerForm(product);
		}
		try {
			productService.save(product);
		} catch (SerialAlreadyExistException e) {
			ObjectError obj = new ObjectError("error", product.getSerialNumber() + " já existe");
			result.addError(obj);
			return registerForm(product);
		}
		return new ModelAndView("redirect:/produto/"+product.getSerialNumber());
	}
	
	@GetMapping("{serialNumber}")
	public ModelAndView details(@PathVariable String serialNumber){
		Product product = productService.find(serialNumber);
		return new ModelAndView("product/product-details").addObject("product",product);
	}
	
	@GetMapping("baixa")
	public ModelAndView exclusion(){
		List<Product> products = productService.findActives();
		return new ModelAndView("product/product-list-exclusion").addObject("products",products);
	}
	
	@GetMapping("baixa/{serialNumber}")
	public ModelAndView doExclude(@PathVariable String serialNumber) {
		Product product = productService.find(serialNumber);
		return new ModelAndView("product/product-exclusion").addObject("product", product);
	}
	
	@PostMapping("baixa/{serialNumber}")
	public ModelAndView doExclude(@PathVariable String serialNumber, @RequestBody @Valid Exclusion exclusion) {
		Product product = productService.find(serialNumber);
		return new ModelAndView("product/product-exclusion").addObject("product", product);
	}

}
