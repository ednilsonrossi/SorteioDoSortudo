package br.edu.ifsp.arq.comp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

public class LeFonte {

	public static String lerJson() {
		StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String linha;
 
        try {
        	JFileChooser chooser = new JFileChooser();
        	chooser.showOpenDialog(null);
        	inputStream = new FileInputStream(chooser.getSelectedFile().getAbsoluteFile());
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
 
            while((linha = bufferedReader.readLine()) != null){
                sb.append(linha);
            }
 
            bufferedReader.close();
        }catch (IOException e) {
            System.out.println("Erro ao recuperar os dados do arquivo. Mensagem: " + e);
            e.printStackTrace();
        }
 
        return sb.toString();
    }
	
}
