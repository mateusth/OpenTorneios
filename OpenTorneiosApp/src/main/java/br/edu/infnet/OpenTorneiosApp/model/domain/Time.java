package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.util.List;

public class Time {
    public Torneio torneio;
    public String capitao;
    public String nomeTime;
    public List<String> jogadores;
    public String categoria;

    @Override
    public String toString() {
        return String.format("O time %s [ %s / %s ] foi criado com sucesso.", nomeTime, torneio, categoria);
    }
}