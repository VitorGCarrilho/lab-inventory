package br.unisal.labinventory.labinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisal.labinventory.labinventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
