package br.com.ideias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ideias.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
