package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="TOrganizador")
public class Organizador {
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeOrganizador() {
		return nomeOrganizador;
	}

	public void setNomeOrganizador(String nomeOrganizador) {
		this.nomeOrganizador = nomeOrganizador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Torneio> getTorneios() {
		return torneios;
	}

	public void setTorneios(List<Torneio> torneios) {
		this.torneios = torneios;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nomeOrganizador;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "organizador")
    private List<Torneio> torneios;

    @Override
    public String toString() {
        return MessageFormat.format("O organizador de torneios {0} - {1} - {2} foi criado com sucesso.",nomeOrganizador,email,telefone);
    }
}