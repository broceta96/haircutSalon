package com.haircut.haircutsalon.service;

import java.util.List;

import com.haircut.haircutsalon.entity.Haircut;

public interface HaircutService {
		
	public void saveHaircuts(Haircut haircut);
	
	public List<Haircut> findAll();
		
}
