package br.unisal.labinventory.labinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisal.labinventory.labinventory.exception.SerialAlreadyExistException;
import br.unisal.labinventory.labinventory.model.Exclusion;
import br.unisal.labinventory.labinventory.model.Product;
import br.unisal.labinventory.labinventory.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void save(Product product) throws SerialAlreadyExistException{
		if (productRepository.findOne(product.getSerialNumber()) != null) {
			throw new SerialAlreadyExistException(product.getSerialNumber()+" already exists");
		}
		product.setAvailable(true);
		product.setActive(true);
		productRepository.save(product);
	}

	public Product find(String serialNumber) {
		return productRepository.findOne(serialNumber);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public List<Product> findActives() {
		return productRepository.findByActive(true);
	}

	public void exclude(String serialNumber, Exclusion exclusion) {
		Product product = this.find(serialNumber);
		product.setExclusion(exclusion);
		product.setActive(false);
		product.setAvailable(false);
		productRepository.save(product);
	}

}
