package br.edu.ifal.leilaogqso;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String nome;
	private List<Lance> lances;

	public Leilao(String n) {
		this.nome = n;
		this.lances = new ArrayList<Lance>();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public void propoe(Lance lance) {
		lances.add(lance);
	}

}
