package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.util.List;

public class Time {
    public String nomeTime;
    public List<Torneio> torneios;
    public String capitao;
    public List<String> jogadores;
    public String categoria;

    @Override
    public String toString() {
        return String.format("O time %s [ %s / %s ] foi criado com sucesso.", nomeTime, torneios, categoria);
    }
}