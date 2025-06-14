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
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public String nomeOrganizador;
    public String email;
    public String telefone;
    
    @OneToMany(mappedBy = "organizador")
    public List<Torneio> torneios;

    @Override
    public String toString() {
        return MessageFormat.format("O organizador de torneios {0} - {1} - {2} foi criado com sucesso.",nomeOrganizador,email,telefone);
    }
}