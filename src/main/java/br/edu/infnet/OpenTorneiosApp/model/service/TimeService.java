package br.edu.infnet.OpenTorneiosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Time;

@Service
public class TimeService {

    private Map<String, Time> mapa = new HashMap<String, Time>();
    public void include(Time time) {
        mapa.put(time.nomeTime,time);
    }
    public Collection<Time> getList() {
        return mapa.values();
    }
}
