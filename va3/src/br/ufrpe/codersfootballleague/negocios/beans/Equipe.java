package br.ufrpe.codersfootballleague.negocios.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.ufrpe.codersfootballleague.exceptions.EquipeException;
import br.ufrpe.codersfootballleague.exceptions.LimiteJogadoresException;
import br.ufrpe.codersfootballleague.exceptions.NomeJogadorException;
import br.ufrpe.codersfootballleague.exceptions.NumeroCamisaException;

public class Equipe implements Serializable {
    private String nome;
    private Map<Integer, String> jogadores;

    public static final int NUM_MAX_JOGADORES = 11;

    public Equipe(String nome) {
        this.nome = nome;
        jogadores = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, String> getJogadores() {
        return jogadores;
    }

    public void adicionarJogador(String nome, int num) throws NomeJogadorException, NumeroCamisaException, LimiteJogadoresException{
        if(!jogadores.containsKey(num)) {
        	if(!jogadores.containsValue(nome)) {
        		if(jogadores.size() < NUM_MAX_JOGADORES)
        			jogadores.put(num, nome);
        		else 
        			throw new LimiteJogadoresException("limite jogadores");
        	}
        	else 
        		throw new NomeJogadorException("nome existe");
        }
        else 
        	throw new  NumeroCamisaException("numero ja existe");
    }

    public void removerJogador(String nome) throws EquipeException {
    	int key = -1;
        if(jogadores.containsValue(nome)) {
            for(Map.Entry<Integer, String> entry : jogadores.entrySet()) {
                if(entry.getValue().equals(nome))
                    key = entry.getKey();
            }
            jogadores.remove(key);
    	}
    	else 
    		throw new EquipeException("nao existe");
    	
    	
   
    }

    public boolean equals(Object obj) {
        boolean resultado = false;
        if (obj instanceof Equipe) {
            Equipe qualquer = (Equipe) obj;
            if (qualquer.getNome().equals(this.nome)) {
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "" + nome;
    }

}
