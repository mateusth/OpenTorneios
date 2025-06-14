package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Organizador;
import br.edu.infnet.OpenTorneiosApp.model.domain.Torneio;
import br.edu.infnet.OpenTorneiosApp.model.repository.TorneioRepository;

@Service
public class TorneioService {
    
    @Autowired
	private TorneioRepository torneioRepository;
	
	public Torneio incluir(Torneio torneio) {
		return torneioRepository.save(torneio);
	}
	
	public void excluir(Integer id) {
		if(!torneioRepository.existsById(id)) {
			throw new RuntimeException("Torneio nao encontrado com o id: " + id);
		}
		torneioRepository.deleteById(id);
	}
	
	public Torneio alterar(Integer id, Torneio torneio ) {
		if(!torneioRepository.existsById(id)) {
			throw new RuntimeException("Torneio nao encontrado com o id: " + id);
		}
		torneio.setId(id);
		return torneioRepository.save(torneio);
	}
		
	public Iterable<Torneio> obterLista() {
		return torneioRepository.findAll();
	}
	
	public Torneio obterPorId(Integer id) {
		return torneioRepository.findById(id).orElseThrow(() -> new RuntimeException("Torneio nao encontrado com o id: " + id));
	}
	
	public Torneio obterPorNomeTorneio(String nomeTorneio) {
		return torneioRepository.findByNomeTorneio(nomeTorneio).orElseThrow(() -> new RuntimeException("Torneio nao encontrado com o nome: " + nomeTorneio));
	}
}
