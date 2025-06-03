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

import br.edu.infnet.OpenTorneiosApp.model.domain.Torneio;
import br.edu.infnet.OpenTorneiosApp.model.service.TorneioService;

@Order(2)
@Component
public class TorneioLoader implements ApplicationRunner {
	@Autowired
	private TorneioService TorneioService;
    
	// @Autowired
    // private OrganizadorService organizadorService;

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
               // List<String> categorias = Arrays.asList(campos[5].split(";")); // Categorias separadas por ';'

                // Organizador meuOrganizador = new Organizador();     //essas 2 linhas sao para teste do campos[7] 
                // meuOrganizador.email = campos[7];        TIREI OS 2 E MUDEI O TORNEIO.ORGANIZADOR ABAIXO COM O NOVO AUTOWIRED ACIMA.

                Torneio torneio = new Torneio();
                torneio.nomeTorneio = campos[0];
                torneio.data = data;
                torneio.horario = campos[2];
                torneio.localizacao = campos[3];
                torneio.dataLimiteInscr = dataLimiteInscr;
               // torneio.categorias = categorias;
                torneio.valorInscricao = Float.valueOf(campos[6]);
               // torneio.organizador = organizadorService.getByEmail(campos[7].trim());
                
                TorneioService.incluir(torneio);
                linha = read.readLine();
            }
            System.out.println("#TORNEIO");
            for(Torneio item : TorneioService.obterLista()) {
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