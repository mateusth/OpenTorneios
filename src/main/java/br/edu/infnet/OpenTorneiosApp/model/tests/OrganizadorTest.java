package br.edu.infnet.OpenTorneiosApp.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.OpenTorneiosApp.model.domain.Organizador;
import br.edu.infnet.OpenTorneiosApp.model.service.OrganizadorService;

@Component
public class OrganizadorTest implements ApplicationRunner {
	@Autowired
	private OrganizadorService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader file = new FileReader("organizadores.csv"); //Cria o arquivo
            BufferedReader read = new BufferedReader(file);                 //Le o arquivo criado
            String linha = read.readLine();                    //Faz a leitura da primeira linha
            String[] campos = null;                            //Cria vetor para gravar cada linha do arquivo em indices

            while(linha != null) {
                campos = linha.split(",");            //pego cada linha(que tem 3 itens divididos por virgula

                Organizador organizador = new Organizador();
                organizador.nomeOrganizador = campos[0];
                organizador.email = campos[1];
                organizador.telefone = campos[2];

                service.include(organizador);               // metodo para incluir no arquivo
                linha = read.readLine();            //faz a leitura da proxima linha
            }
            System.out.println("#ORGANIZADOR");
                        
            for(Organizador item : service.getList()) {     //forEach com metodo para exibir cada no console
                System.out.println(item);
            }

            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Impossivel abrir/fechar arquivo.");
            e.printStackTrace();
        }
    }
}
