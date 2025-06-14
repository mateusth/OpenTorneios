package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TJogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nomeCapitao;
    public String emailJogador;
    public String telefone;
    public String genero;
    public LocalDate dataNascimento;
    @OneToMany(mappedBy = "nomeCapitao")
    public List<Time> times;
    
    @Override
    public String toString() {
        return MessageFormat.format("O atleta {0} foi criado com sucesso. {1} - {2} - {3} - {4}",nomeCapitao,emailJogador,telefone,genero,dataNascimento);
    }
}