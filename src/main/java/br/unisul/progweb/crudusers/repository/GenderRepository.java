package br.unisul.progweb.crudusers.repository;

import br.unisul.progweb.crudusers.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Serializable> {

}
