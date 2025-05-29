package br.edu.infnet.OpenTorneiosApp.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.OpenTorneiosApp.model.domain.Torneio;
import br.edu.infnet.OpenTorneiosApp.model.service.TorneioService;

@Component
public class TorneioTest implements ApplicationRunner {
	@Autowired
	private TorneioService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	  try {
            FileReader file = new FileReader("torneios.csv");
            BufferedReader read = new BufferedReader(file);
            String linha = read.readLine();
            String[] campos = null;

            while(linha != null) {
                campos = linha.split(",");
                LocalDate data = LocalDate.parse(campos[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate dataLimiteInscr = LocalDate.parse(campos[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                List<String> categorias = Arrays.asList(campos[5].split(";")); // Categorias separadas por ';'

                Torneio torneio = new Torneio();
                torneio.nomeTorneio = campos[0];
                torneio.data = data;
                torneio.horario = campos[2];
                torneio.localizacao = campos[3];
                torneio.dataLimiteInscr = dataLimiteInscr;
                torneio.categorias = categorias;
                torneio.valorInscricao = Float.valueOf(campos[6]);

                service.include(torneio);
                linha = read.readLine();
            }
            System.out.println("#TORNEIO");
            for(Torneio item : service.getList()) {
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