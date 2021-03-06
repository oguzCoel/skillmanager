package ch.business.quickline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Abteilung;
import ch.business.quickline.repository.AbteilungRepository;

@Service("abteilungService")
@Transactional
public class AbteilungServiceImpl implements AbteilungService {
	
	@Autowired
	AbteilungRepository abteilungRepository;

	public Abteilung save(Abteilung abteilung) {
		
		return abteilungRepository.save(abteilung);
	}
	

	public List<Abteilung> findALL() {
		// TODO Auto-generated method stub
		return abteilungRepository.findAll();
	}
	
	
	public Abteilung findByAbteilungId(Integer id){
		
		return abteilungRepository.findByAbteilungId(id);
	}
	
	public Abteilung findByAbteilungName(String name){
		
		return abteilungRepository.findByAbteilungName(name);
	}

}
