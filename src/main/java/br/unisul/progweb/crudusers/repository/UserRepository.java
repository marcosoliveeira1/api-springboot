package br.unisul.progweb.crudusers.repository;

import br.unisul.progweb.crudusers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    @Transactional(readOnly = true)
    User findByLogin(String login);
}
