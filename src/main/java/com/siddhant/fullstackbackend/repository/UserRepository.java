package com.siddhant.fullstackbackend.repository;

import com.siddhant.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	//	<name of model class, data type of primary key variable>


}
