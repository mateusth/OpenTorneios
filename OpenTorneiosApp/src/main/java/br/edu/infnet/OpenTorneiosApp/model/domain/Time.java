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
    public Integer id;
    @JsonIgnore
    @ManyToOne
    public Torneio torneio;
    @JsonIgnore
    @ManyToOne
    public Jogador nomeCapitao;
    public String nomeTime;
    public List<String> jogadores;
    public String categoria;

    @Override
    public String toString() {
       return MessageFormat.format("O time {0} [ {1} / {2} ] foi criado com sucesso.",nomeTime,torneio, categoria);
    }
}