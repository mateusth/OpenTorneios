package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TTorneio")
public class Torneio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public String nomeTorneio;
    public LocalDate data;
    public String horario;
    public String localizacao;
    public LocalDate dataLimiteInscr;
    public List<String> categorias;
    public float valorInscricao;
    @JsonIgnore
    @ManyToOne
    public Organizador organizador;
    @OneToMany(mappedBy = "torneio")
    public List<Time> times;

    @Override
    public String toString() {
        return MessageFormat.format("O torneio {0} - data: {1}, foi criado com sucesso por: {2}.",nomeTorneio,data, organizador.email);
    }
}