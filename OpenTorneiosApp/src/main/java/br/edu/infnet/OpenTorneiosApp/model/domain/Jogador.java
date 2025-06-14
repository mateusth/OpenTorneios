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
    private Integer id;
    private String nomeCapitao;
    private String emailJogador;
    private String telefone;
    private String genero;
    private LocalDate dataNascimento;
    @OneToMany(mappedBy = "nomeCapitao")
    private List<Time> times;
    
    @Override
    public String toString() {
        return MessageFormat.format("O atleta {0} foi criado com sucesso. {1} - {2} - {3} - {4}",nomeCapitao,emailJogador,telefone,genero,dataNascimento);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCapitao() {
		return nomeCapitao;
	}

	public void setNomeCapitao(String nomeCapitao) {
		this.nomeCapitao = nomeCapitao;
	}

	public String getEmailJogador() {
		return emailJogador;
	}

	public void setEmailJogador(String emailJogador) {
		this.emailJogador = emailJogador;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
}