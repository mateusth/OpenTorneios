package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TJogador")
public class Jogador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nomeJogador;
    public String emailJogador;
    public String telefone;
    public String genero;
    public LocalDate dataNascimento;
    
    //public List<String> torneios; /////////ERA <TORNEIO>

    @Override
    public String toString() {
        return MessageFormat.format("O atleta {0} foi criado com sucesso. {1} - {2} - {3} - {4}",nomeJogador,emailJogador,telefone,genero,dataNascimento);
    }
}