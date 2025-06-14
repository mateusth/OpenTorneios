package br.edu.infnet.OpenTorneiosApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Organizador;
import br.edu.infnet.OpenTorneiosApp.model.repository.OrganizadorRepository;

@Service
public class OrganizadorService {

	@Autowired
	private OrganizadorRepository organizadorRepository;
	
	public Organizador incluir(Organizador organizador) {
		return organizadorRepository.save(organizador);
	}
	
	public void excluir(Integer id) {
		if(!organizadorRepository.existsById(id)) {
			throw new RuntimeException("Organizador nao encontrado com o id: " + id);
		}
			organizadorRepository.deleteById(id);
	}
	
	public Organizador alterar(Integer id, Organizador organizador ) {
		if(!organizadorRepository.existsById(id)) {
			throw new RuntimeException("Organizador nao encontrado com o id: " + id);
		}
		organizador.id = id;
		return organizadorRepository.save(organizador);
	}
	
	public Iterable<Organizador> obterLista() {
		return organizadorRepository.findAll();
	}
	
	public Organizador obterPorId(Integer id) {
		return organizadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Organizador nao encontrado com o id: " + id));
	}

	public Organizador obterPorEmail(String email) {
		return organizadorRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Organizador nao encontrado com o email: " + email));
	}
}