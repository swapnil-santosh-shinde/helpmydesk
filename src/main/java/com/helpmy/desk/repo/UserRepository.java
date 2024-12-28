package com.helpmy.desk.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpmy.desk.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
	
	 Optional<UserDetails> findByEmail(String email);

}
