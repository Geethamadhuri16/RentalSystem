package com.rental.rental.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.rental.Model.Two_wheeler;

public interface Two_wheelerRepo extends JpaRepository<Two_wheeler, Long> {
	public Two_wheeler findByRegistrationNumber(String num);

}
