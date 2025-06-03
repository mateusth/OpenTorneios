package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Time;
import br.edu.infnet.OpenTorneiosApp.model.repository.TimeRepository;

@Service
public class TimeService {

	@Autowired
	private TimeRepository timeRepository;
	
	public Time incluir(Time time) {
		return timeRepository.save(time);
	}
	
	public Iterable<Time> obterLista() {
		return timeRepository.findAll();
	}
}