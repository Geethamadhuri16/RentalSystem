package com.rental.rental.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rental.Model.Four_wheeler;
import com.rental.rental.Model.Two_wheeler;

public interface Four_wheelerRepo extends JpaRepository<Four_wheeler, Long> {

	public Four_wheeler findByRegistrationNumber(String num);

}
