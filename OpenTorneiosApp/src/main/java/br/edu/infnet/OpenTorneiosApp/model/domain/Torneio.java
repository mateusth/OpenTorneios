package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TProduto")
public class Torneio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer Id;
    
    public String nomeTorneio;
    public LocalDate data;
    public String horario;
    public String localizacao;
    public LocalDate dataLimiteInscr;
    @Transient
    public List<String> categorias;
    public float valorInscricao;
    @Transient
    public Organizador organizador;
    @Transient
    public List<Time> times;

    @Override
    public String toString() {
        return MessageFormat.format("O torneio {0} - data: {1}, foi criado com sucesso por: .",nomeTorneio,data);
    }
}