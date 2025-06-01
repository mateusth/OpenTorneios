package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.util.List;

public class Time {
    public Torneio torneio;
    public String capitao;
    public String nomeTime;
    public List<String> jogadores;
    public String categoria;

    @Override
    public String toString() {
       return MessageFormat.format("O time {0} [ {1} / {2} ] foi criado com sucesso.",nomeTime,torneio.nomeTorneio,categoria);
    }
}