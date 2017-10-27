package br.unisal.labinventory.labinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisal.labinventory.labinventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	List<Product> findByActive(boolean active);
}
