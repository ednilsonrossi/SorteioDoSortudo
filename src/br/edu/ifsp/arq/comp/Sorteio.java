package br.edu.ifsp.arq.comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {
	private final int BORDA_PADRAO = 1;
	private final int RODADAS_PADRAO = 1;
	private int bordaSuperior;
	private int qtdadeRodadas;
	private boolean conjunto[];
	
	public Sorteio(int limite, int rodadas) {
		this.bordaSuperior = limite >= 1 ? limite : BORDA_PADRAO;
		this.qtdadeRodadas = rodadas >= 1 ? rodadas : RODADAS_PADRAO;
		this.conjunto = new boolean[this.bordaSuperior];
		init();
	}
	
	private void init() {
		for(int i=0; i < this.bordaSuperior; i++) {
			this.conjunto[i] = false;
		}
	}
	
	public List<Integer> sortear() {
		Random rand = new Random();
		int rodada = 1;
		int select = 0;
		while(rodada <= this.qtdadeRodadas) {
			select = rand.nextInt(this.bordaSuperior);
			if(this.conjunto[select] == false) {
				this.conjunto[select] = true;
				rodada += 1;
			}
		}
		
		List<Integer> retorno = new ArrayList<Integer>();
		rodada = 0;
		while(rodada < this.bordaSuperior) {
			if(this.conjunto[rodada] == true) {
				retorno.add(new Integer(rodada + 1));
			}
			rodada += 1;
		}
		
		return retorno;
	}
}
