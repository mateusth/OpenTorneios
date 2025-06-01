package br.edu.infnet.OpenTorneiosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Torneio;

@Service
public class TorneioService {
    private Map<String, Torneio> mapa = new HashMap<String, Torneio>();
    public void include(Torneio torneio) {
        mapa.put(torneio.nomeTorneio,torneio);
    }
    public Collection<Torneio> getList() {
        return mapa.values();
    }

    public Torneio getByNomeTorneio(String nomeTorneio) {
        return mapa.get(nomeTorneio);
    }
}