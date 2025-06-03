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
	
	public Iterable<Organizador> obterLista() {
		return organizadorRepository.findAll();
	}
}