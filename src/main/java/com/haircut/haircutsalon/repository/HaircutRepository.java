package com.haircut.haircutsalon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haircut.haircutsalon.entity.Haircut;

@Repository
public interface HaircutRepository extends JpaRepository<Haircut, Integer>{
	
}
