package br.ufrpe.codersfootballleague.dados;

import java.util.List;

import br.ufrpe.codersfootballleague.exceptions.EquipeException;
import br.ufrpe.codersfootballleague.negocios.beans.Equipe;

public interface IRepositorioEquipes {

    void adicionar(Equipe e) throws EquipeException;

    List<Equipe> listar();

    void atualizar(Equipe nova, String antiga) throws EquipeException;

    void remover(String nome);

    void salvar();

}