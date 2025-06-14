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
    private Integer id;
    private String nomeTorneio;
    private LocalDate data;
    private String horario;
    private String localizacao;
    private LocalDate dataLimiteInscr;
    private List<String> categorias;
    private float valorInscricao;
    @JsonIgnore
    @ManyToOne
    private Organizador organizador;
    @OneToMany(mappedBy = "torneio")
    private List<Time> times;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTorneio() {
		return nomeTorneio;
	}

	public void setNomeTorneio(String nomeTorneio) {
		this.nomeTorneio = nomeTorneio;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public LocalDate getDataLimiteInscr() {
		return dataLimiteInscr;
	}

	public void setDataLimiteInscr(LocalDate dataLimiteInscr) {
		this.dataLimiteInscr = dataLimiteInscr;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public float getValorInscricao() {
		return valorInscricao;
	}

	public void setValorInscricao(float valorInscricao) {
		this.valorInscricao = valorInscricao;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	@Override
    public String toString() {
        return MessageFormat.format("O torneio {0} - data: {1}, foi criado com sucesso por: {2}.",nomeTorneio,data, organizador.getEmail());
    }
}