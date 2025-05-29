package br.edu.infnet.OpenTorneiosApp.model.domain;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

public class Torneio {
    public String nomeTorneio;
    public LocalDate data;
    public String horario;
    public String localizacao;
    public LocalDate dataLimiteInscr;
    public List<String> categorias;
    public float valorInscricao;
    public Organizador organizador;
    public List<Time> times;

    @Override
    public String toString() {
        return MessageFormat.format("O torneio {0} - data: {1}, foi criado com sucesso por: {2}.", nomeTorneio, data, organizador);
    }
}