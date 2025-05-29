package br.edu.infnet.OpenTorneiosApp.model.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.OpenTorneiosApp.model.domain.Time;
import br.edu.infnet.OpenTorneiosApp.model.service.TimeService;

@Component
public class TimeTest implements ApplicationRunner{
	@Autowired
	private TimeService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader file = new FileReader("times.csv");
            BufferedReader read = new BufferedReader(file);
            String linha = read.readLine();
            String[] campos = null;

            while(linha != null) {
                campos = linha.split(",");
  
                Time time = new Time();
               // time.torneio = campos[0];
                time.capitao = campos[1];
                time.nomeTime = campos[2];
              //  time.jogadores = campos[3];
                time.categoria = campos[4];
                
                service.include(time);
                linha = read.readLine();
            }
            System.out.println("#TIME");
            for(Time item : service.getList()) {
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
