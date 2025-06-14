package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="TTime")
public class Time {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    private Torneio torneio;
    @JsonIgnore
    @ManyToOne
    private Jogador nomeCapitao;
    private String nomeTime;
    private List<String> jogadores;
    private String categoria;

    @Override
    public String toString() {
       return MessageFormat.format("O time {0} [ {1} / {2} ] foi criado com sucesso.",nomeTime,torneio, categoria);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public Jogador getNomeCapitao() {
		return nomeCapitao;
	}

	public void setNomeCapitao(Jogador nomeCapitao) {
		this.nomeCapitao = nomeCapitao;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public List<String> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<String> jogadores) {
		this.jogadores = jogadores;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}