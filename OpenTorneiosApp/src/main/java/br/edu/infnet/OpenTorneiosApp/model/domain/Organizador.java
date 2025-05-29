package br.edu.infnet.OpenTorneiosApp.model.domain;

import java.text.MessageFormat;
import java.util.List;

public class Organizador {
    public String nomeOrganizador;
    public String email;
    public String telefone;
    public List<Torneio> torneios;

    @Override
    public String toString() {
        return MessageFormat.format("O organizador de torneios {0} - {1} - {2} foi criado com sucesso.", nomeOrganizador, email, telefone);
    }
}