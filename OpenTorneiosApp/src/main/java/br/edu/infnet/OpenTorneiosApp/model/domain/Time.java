package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="TOrganizador")
public class Time {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer Id;
    @Transient
    public Torneio torneio;
    public String capitao;
    public String nomeTime;
    @Transient
    public List<String> jogadores;
    public String categoria;

    @Override
    public String toString() {
       return MessageFormat.format("O time {0} [ {1} / {2} ] foi criado com sucesso.",nomeTime,torneio, categoria);
    }
}