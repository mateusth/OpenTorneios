package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Organizador;
import br.edu.infnet.OpenTorneiosApp.model.domain.Time;
import br.edu.infnet.OpenTorneiosApp.model.repository.TimeRepository;

@Service
public class TimeService {

	@Autowired
	private TimeRepository timeRepository;
	
	public Time incluir(Time time) {
		return timeRepository.save(time);
	}
	
	public void excluir(Integer id) {
		if(!timeRepository.existsById(id)) {
			throw new RuntimeException("Time nao encontrado com o id: " + id);
		}
		timeRepository.deleteById(id);
	}
	
	public Time alterar(Integer id, Time time ) {
		if(!timeRepository.existsById(id)) {
			throw new RuntimeException("Time nao encontrado com o id: " + id);
		}
		time.setId(id);
		return timeRepository.save(time);
	}
	
	public Iterable<Time> obterLista() {
		return timeRepository.findAll();
	}
	
	public Time obterPorId(Integer id) {
		return timeRepository.findById(id).orElseThrow(() -> new RuntimeException("Time nao encontrado com o id: " + id));
	}
}