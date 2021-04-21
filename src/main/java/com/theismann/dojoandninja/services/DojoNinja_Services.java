package com.theismann.dojoandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.theismann.dojoandninja.models.Dojo;
import com.theismann.dojoandninja.models.Ninja;
import com.theismann.dojoandninja.repositories.DojoRepository;
import com.theismann.dojoandninja.repositories.NinjaRepository;

@Service
public class DojoNinja_Services {
	
	private DojoRepository dojoRepository;
	private NinjaRepository ninjaRepository;
	

	public DojoNinja_Services(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		super();
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	// Creating dojos and ninjas
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	// display
	public List<Dojo> getAllDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}
	public List<Ninja> getAllNinjas() {
		return (List<Ninja>) ninjaRepository.findAll();
	}
	
	//display one
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public Ninja getNinja(Long id) {
		Optional<Ninja> optionalNinja = this.ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
