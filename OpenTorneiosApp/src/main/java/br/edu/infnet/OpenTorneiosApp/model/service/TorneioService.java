package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Torneio;
import br.edu.infnet.OpenTorneiosApp.model.repository.TorneioRepository;

@Service
public class TorneioService {
    
    @Autowired
	private TorneioRepository torneioRepository;
	
	public Torneio incluir(Torneio torneio) {
		return torneioRepository.save(torneio);
	}
	
	public Iterable<Torneio> obterLista() {
		return torneioRepository.findAll();
	}
}
