package br.edu.ifsp.arq.comp;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		
		String dados = LeFonte.lerJson();
		Gson gson = new Gson();
		Pessoa[] candidatos = gson.fromJson(dados, Pessoa[].class);
		
		System.out.println("Candidatos");
		for(Pessoa p : candidatos) {
			System.out.println(p.getNome());
		}
		
		int qtd;
		try {
			qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantas pessoas sortear? "));
		}catch (Exception e) {
			System.out.println("Erro na leitura");
			qtd = 1;
		}
		
		qtd = qtd < 1? 1 : qtd;
		
		Sorteio sorteio = new Sorteio(candidatos.length, qtd);
		List<Integer> sortudos = sorteio.sortear();
		
		System.out.println("Sortudos:");
		for(Integer i : sortudos) {
			System.out.println(candidatos[i-1].getNome());
		}
	}

}
