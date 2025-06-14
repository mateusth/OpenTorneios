package br.edu.infnet.OpenTorneiosApp.model.loaders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.OpenTorneiosApp.model.domain.Time;
import br.edu.infnet.OpenTorneiosApp.model.service.TimeService;
import br.edu.infnet.OpenTorneiosApp.model.service.TorneioService;

@Order(4)
@Component
public class TimeLoader implements ApplicationRunner{
	@Autowired
	private TimeService timeService;

	//@Autowired
    //private TorneioService torneioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader file = new FileReader("times.csv");
            BufferedReader read = new BufferedReader(file);
            String linha = read.readLine();
            String[] campos = null;

            while(linha != null) {
                campos = linha.split(",");
  
                List<String> jogadores = Arrays.asList(campos[3].split(";")); // Categorias separadas por ';'

                Time time = new Time();
              //  time.torneio = torneioService.getByNomeTorneio(campos[0]);
                time.capitao = campos[1];
                time.nomeTime = campos[2];
                time.jogadores = jogadores;
                time.categoria = campos[4];
                
                timeService.incluir(time);
                linha = read.readLine();
            }
            System.out.println("#TIME");
            for(Time item : timeService.obterLista()) {
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