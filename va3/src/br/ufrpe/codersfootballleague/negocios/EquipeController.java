/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.codersfootballleague.negocios;

import br.ufrpe.codersfootballleague.dados.IRepositorioEquipes;
import br.ufrpe.codersfootballleague.dados.RepositorioEquipes;
import br.ufrpe.codersfootballleague.exceptions.EquipeException;
import br.ufrpe.codersfootballleague.negocios.beans.Equipe;

import java.util.List;

public class EquipeController {

    private IRepositorioEquipes repEquipes;
    private static EquipeController instance;

    private EquipeController() {
        repEquipes = RepositorioEquipes.getInstance();
    }

    public static EquipeController getInstance() {
        if (instance == null) {
            instance = new EquipeController();
        }
        return instance;
    }

    public void adicionar(Equipe e) throws EquipeException {
        repEquipes.adicionar(e);
    }

    public List<Equipe> listar() {
        return repEquipes.listar();
    }

    public void atualizar(Equipe nova, String antiga) throws EquipeException {
        repEquipes.atualizar(nova, antiga);
    }

    public void remove(String nome) {
        repEquipes.remover(nome);
    }

    public void salvar() {
        repEquipes.salvar();
    }

}
