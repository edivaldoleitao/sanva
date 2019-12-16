/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.codersfootballleague.negocios.beans;

public class EquipeInformation implements Comparable<EquipeInformation>{
    
    private String nome;
    private int pontos;
    private int saldoDeGols;
    private int golsAFavor;
    private int golsContra;

    public EquipeInformation(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.saldoDeGols = 0;
        this.golsAFavor = 0;
        this.golsContra = 0;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getPontos() {
        return pontos;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    public int getGolsAFavor() {
        return golsAFavor;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void atualizarPontos(int pontos) {
        this.pontos += pontos;
    }

    public void atualizarSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols += saldoDeGols;
    }

    public void atualizarGolsAFavor(int golsAFavor) {
        this.golsAFavor += golsAFavor;
    }

    public void atualizarGolsContra(int golsContra) {
        this.golsContra += golsContra;
    }
    
    
    public boolean equals(Object obj){
        boolean resultado = false;
        if(obj instanceof EquipeInformation){
            EquipeInformation qualquer = (EquipeInformation) obj;
            if(qualquer.getNome().equals(this.nome)){
                resultado = true;
            }
        }
        return resultado;
    }
    
    @Override
    public int compareTo(EquipeInformation o) {
        int resultado = 0;
        // TODO (1,0) Implementar noção de ordenação para pontuação de equipes 
        // Implementar noção de ordenação de acordo com o seguinte critério: 
        // uma equipe A está na frente de uma equipe B se o seu número de A pontos 
        // for maior que o de B. Se A e B tem o mesmo número de pontos, então 
        // estará na frente a equipe que tiver o maior saldo de gols. Se o saldo 
        // de gols for igual, então estará na frente a equipe que tiver o maior 
        // número de gols a favor. Por fim, se o número de gols a favor for igual, 
        // estará na frente a equipe que tiver o menor número de gols contra.
        if(this.pontos > o.getPontos())
            resultado = 1;
        if(this.pontos < o.getPontos())
            resultado = -1;
        if( this.pontos == o.getPontos()) {
            if(this.saldoDeGols > o.getGolsContra())
                resultado = 1;
            if(this.saldoDeGols < o.getSaldoDeGols())
                resultado = -1;
            if(this.saldoDeGols == o.getSaldoDeGols()) {
                if(this.golsAFavor > o.getGolsAFavor())
                    resultado = 1;
                if(this.golsAFavor < o.getGolsAFavor())
                    resultado = -1;
                if(this.golsAFavor == o.getGolsAFavor()) {
                    if(this.golsContra < o.getGolsContra())
                        resultado = 1;
                    if(this.golsContra > o.getGolsContra())
                        resultado = -1;
                }
            }
        } 
            
        return resultado;
    }
    
}
