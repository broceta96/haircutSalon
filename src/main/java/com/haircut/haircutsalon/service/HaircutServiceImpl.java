package com.haircut.haircutsalon.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haircut.haircutsalon.entity.Haircut;
import com.haircut.haircutsalon.repository.HaircutRepository;

@Service
public class HaircutServiceImpl implements HaircutService{

	
	@Autowired
	private HaircutRepository haircutRepository;
	
	
	@Override
	public void saveHaircuts(Haircut haircut) {
		haircutRepository.save(haircut);
	}
	
	public List<Haircut> findAll(){
		return haircutRepository.findAll();
	}
	
}
