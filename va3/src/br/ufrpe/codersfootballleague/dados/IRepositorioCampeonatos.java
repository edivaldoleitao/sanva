package br.ufrpe.codersfootballleague.dados;

import java.util.List;

import br.ufrpe.codersfootballleague.exceptions.CampeonatoException;
import br.ufrpe.codersfootballleague.negocios.beans.Campeonato;

public interface IRepositorioCampeonatos {

    void adicionar(Campeonato c) throws CampeonatoException;

    Campeonato consultar(String nome) throws CampeonatoException;

    List<Campeonato> listar();

    void remove(String nome) throws CampeonatoException;

    void salvar();

}