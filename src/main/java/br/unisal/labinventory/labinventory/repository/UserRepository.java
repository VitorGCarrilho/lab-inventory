package br.unisal.labinventory.labinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisal.labinventory.labinventory.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
