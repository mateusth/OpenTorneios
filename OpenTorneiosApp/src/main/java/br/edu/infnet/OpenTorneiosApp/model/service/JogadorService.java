package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Jogador;
import br.edu.infnet.OpenTorneiosApp.model.domain.Organizador;
import br.edu.infnet.OpenTorneiosApp.model.domain.Torneio;
import br.edu.infnet.OpenTorneiosApp.model.repository.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	public Jogador incluir(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}
	
	public void excluir(Integer id) {
		if(!jogadorRepository.existsById(id)) {
			throw new RuntimeException("Jogador nao encontrado com o id: " + id);
		}
		jogadorRepository.deleteById(id);
	}
	
	public Jogador alterar(Integer id, Jogador jogador ) {
		if(!jogadorRepository.existsById(id)) {
			throw new RuntimeException("Jogador nao encontrado com o id: " + id);
		}
		jogador.setId(id);
		return jogadorRepository.save(jogador);
	}
		
	public Iterable<Jogador> obterLista() {
		return jogadorRepository.findAll();
	}
	
	public Jogador obterPorId(Integer id) {
		return jogadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogador nao encontrado com o id: " + id));
	}
	
	public Jogador obterPorNomeCapitao(String nomeCapitao) {
		return jogadorRepository.findByNomeCapitao(nomeCapitao).orElseThrow(() -> new RuntimeException("Capitao nao encontrado com o nome: " + nomeCapitao));
	}
}