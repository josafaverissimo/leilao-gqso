package br.edu.ifal.leilaogqso;

import java.util.List;

public class Avaliador {

    private double maiorDeTodos = 0;
    private double menorDeTodos = 0;

    public void avalia(Leilao leilao) {
        final List<Lance> lances = leilao.getLances();

        for(int i = 0; i < lances.size(); i++) {
            final double lance = lances.get(i).getValor();

            if(i == 0) {
                if(lance > 0) {
                    this.maiorDeTodos = lance;
                    this.menorDeTodos = lance;
                }
            } else {
                if(this.maiorDeTodos < lance) {
                    this.maiorDeTodos = lance;
                }

                if(this.menorDeTodos > lance) {
                    this.menorDeTodos = lance;
                }
            }
        }
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }
}
