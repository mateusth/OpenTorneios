package br.edu.infnet.OpenTorneiosApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.OpenTorneiosApp.model.domain.Organizador;

@Service
public class OrganizadorService {
    //abaixo os 3 proximos privates sao para o MAP = para CRUD = forma uma lista temporaria a partir do que ele le no arquivo.
    private Map<String, Organizador> mapa = new HashMap<String, Organizador>();   //Criar um mapa para usar abaixo

    public void include(Organizador organizador) {            //Metodo para incluir esse organizador dentro do mapa
        mapa.put(organizador.email,organizador);                      //A key eu escolhi email, do organizador
    }
    public Collection<Organizador> getList() {                      //Cria um metodo do tipo COLLECTION para retornar a lista.
        return mapa.values();                                         // OS 3 SAO PRIVATES
    }
}
