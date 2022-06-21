package com.haircut.haircutsalon.haircut;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.haircut.haircutsalon.entity.Haircut;
import com.haircut.haircutsalon.repository.HaircutRepository;
import com.haircut.haircutsalon.service.HaircutServiceImpl;

@ExtendWith(MockitoExtension.class)
public class HaircutTest {

	@Mock
	private HaircutRepository repository;
	
	@InjectMocks
	private HaircutServiceImpl service;

	@Test	
	public void canFindAllHaircuts() {
		service.findAll();		
		verify(repository).findAll();		
	}
	
	@Test
	public void canSaveHaircut() {
		Haircut haircut = new Haircut("Mohawk");
		
		service.saveHaircuts(haircut);
		
		ArgumentCaptor<Haircut> haircutCaptor = ArgumentCaptor.forClass(Haircut.class);
		
		verify(repository).save(haircutCaptor.capture());
		
		Haircut captured = haircutCaptor.getValue();
		assertThat(captured).isEqualTo(haircut);
	}
}
