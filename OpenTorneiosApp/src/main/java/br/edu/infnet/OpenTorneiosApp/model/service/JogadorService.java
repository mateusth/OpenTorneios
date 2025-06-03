package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Jogador;
import br.edu.infnet.OpenTorneiosApp.model.repository.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	public Jogador incluir(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}
	
	public Iterable<Jogador> obterLista() {
		return jogadorRepository.findAll();
	}
}