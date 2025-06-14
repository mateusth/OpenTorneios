package br.edu.infnet.OpenTorneiosApp.model.loaders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.OpenTorneiosApp.model.domain.Jogador;
import br.edu.infnet.OpenTorneiosApp.model.service.JogadorService;

@Order(3)
@Component
public class JogadorLoader implements ApplicationRunner{
	@Autowired
	private JogadorService jogadorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader file = new FileReader("jogadores.csv");
            BufferedReader read = new BufferedReader(file);
            String linha = read.readLine();
            String[] campos = null;

            while(linha != null) {
                campos = linha.split(",");
                
                LocalDate dataNascimento = LocalDate.parse(campos[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
                Jogador jogador = new Jogador();
                jogador.setNomeCapitao(campos[0]) ;
                jogador.setEmailJogador(campos[1]);
                jogador.setTelefone(campos[2]);
                jogador.setGenero(campos[3]);
                jogador.setDataNascimento(dataNascimento);

                jogadorService.incluir(jogador);
                linha = read.readLine();
            }
            System.out.println("#JOGADOR");
                        
            for(Jogador item : jogadorService.obterLista()) {
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