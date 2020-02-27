package com.fdm.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fdm.project.models.User;



@Component
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
