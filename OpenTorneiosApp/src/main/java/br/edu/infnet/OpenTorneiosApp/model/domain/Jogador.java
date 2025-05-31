package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

public class Jogador {
    public String nomeJogador;
    public String email;
    public String telefone;
    public String genero;
    public LocalDate dataNascimento;
    public List<Torneio> torneios;

    @Override
    public String toString() {
        return MessageFormat.format("O atleta {0} foi criado com sucesso. {1} - {2} - {3} - {4}", nomeJogador, email, telefone, genero, dataNascimento);
    }
}
