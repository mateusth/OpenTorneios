package br.edu.infnet.OpenTorneiosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Jogador;

@Service
public class JogadorService {
    private Map<String, Jogador> mapa = new HashMap<String, Jogador>();
    public void include(Jogador jogador) {
        mapa.put(jogador.email,jogador);
    }
    public Collection<Jogador> getList() {
        return mapa.values();
    }
}
