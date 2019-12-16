/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.codersfootballleague.negocios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.ufrpe.codersfootballleague.dados.IRepositorioCampeonatos;
import br.ufrpe.codersfootballleague.dados.RepositorioCampeonatos;
import br.ufrpe.codersfootballleague.exceptions.CampeonatoException;
import br.ufrpe.codersfootballleague.negocios.beans.Campeonato;
import br.ufrpe.codersfootballleague.negocios.beans.Equipe;
import br.ufrpe.codersfootballleague.negocios.beans.EquipeInformation;
import br.ufrpe.codersfootballleague.negocios.beans.Partida;
import java.util.Comparator;

public class CampeonatoController {

    private IRepositorioCampeonatos repCampeonato;
    private static CampeonatoController instance;

    private CampeonatoController() {
        repCampeonato = RepositorioCampeonatos.getInstance();
    }

    public static CampeonatoController getInstance() {
        if (instance == null) {
            instance = new CampeonatoController();
        }
        return instance;
    }

    @SuppressWarnings("unused")
    public Campeonato simularCampeonato(List<Equipe> equipes, LocalDate dataInicioCampeonato, String nomeCampeonato) throws CampeonatoException {
        Campeonato resultado = null;
        
        // TODO (3,0) Este método será responsável por criar todas as partidas de um campeonato
        // O método deverá simular a execução de um campeonato criando partidas
        // para a lista de equipes informadas como parâmetro de acordo com as
        // seguintes regras:
        // 1 – Todas as equipes deverão se enfrentar uma única vez numa
        // combinação de N, 2 a 2 onde n é o número de equipes. Isto é, se um
        // campeonato tem 4 equipes, 6 partidas deverão ser geradas considerando
        // a combinação de todos os jogos possíveis. Lembre-se que a partida A
        // vs B é a mesma de B vs A e não deve ser adicionada duas vezes na
        // lista de partidas de um campeonato. Um exemplo disso é a fase de
        // grupos da copa do mundo.
        
        // 2 – Um campeonato deverá ter o tamanho mínimo de 4 equipes e cada 
        // equipe deve conter pelo menos 3 jogadores, isto é, o parâmetro 
        // (List<Equipe>) informado deve ser verificado e caso não
        // atenda a este critério, uma exceção criada por você deverá ser
        // arremessada e devidamente tratada na GUI. 
        
        // 3 – A data inicial de um campeonato é fornecida como parâmetro, porém
        // a data final será igual a data da última partida
        
        // 4 – As datas de cada partida devem ser definidas a partir do início
        // do campeonato seguindo somente uma restrição: partidas de uma mesma
        // equipe não poderão ocorrer em dias consecutivos. Ou seja, as partidas
        // de uma mesma equipe precisarão ocorrer com um intervalo mínimo de
        // pelo menos um dia após a realização da sua última partida
        
        // 5 – Um campeonato deverá ter pelo menos 2 partidas amistosas, cujas
        // datas devem ser anteriores à data de início do mesmo envolvendo
        // equipes randômicas. Você pode definir quantas partidas amistosas
        // desejar
        
        // 6 – Todas as partidas geradas deverão ter seus placares preenchidos
        // randomicamente. O placar máximo de cada partida não deve ultrapassar
        // o número de 7 gols. Você pode usar a classe java.util.Random para
        // gerar os placares
        
        // 7 – O objeto do tipo Campeonato criado por você deverá ser retornado
        // ao final do método e também salvo no repositório de campeonatos
        
        if (resultado != null) {
            repCampeonato.adicionar(resultado);
        }
        return resultado;
    }

    public List<EquipeInformation> calcularPontuacaoPorEquipe(Campeonato c) {
        // TODO (2,0) Método para calcular informação sobre pontuação de equipes
        // Este método deve retornar uma lista ordenada de todas as 
        // informações de pontuação de cada equipe (obj. EquipeInformation) 
        // do campeonato informado como parâmetro e suas respectivas pontuações. 
        // As pontuações devem considerar 0 pontos para derrota, 1 ponto para 
        // empate e 3 pontos para vitória, além das informações calculadas de 
        // saldo de gols, gols a favor e gols contra. O algoritmo para ordenação 
        // deverá ser implementado na própria classe EquipeInformation.
        ArrayList<EquipeInformation> tabela = new ArrayList<>();
        
        for(Partida p : c.getPartidas()) {
            
            EquipeInformation equipeCasa = new EquipeInformation(p.getEquipeDaCasa().getNome());
            equipeCasa.atualizarGolsAFavor(p.getPlacarEquipeDaCasa());
            equipeCasa.atualizarGolsContra(p.getPlacarEquipeVisitante());
            equipeCasa.atualizarSaldoDeGols(p.getPlacarEquipeDaCasa() - p.getPlacarEquipeVisitante());
            
            if(p.getPlacarEquipeDaCasa() > p.getPlacarEquipeVisitante()) 
                equipeCasa.atualizarPontos(3);
            else if(p.getPlacarEquipeDaCasa() < p.getPlacarEquipeVisitante())
                equipeCasa.atualizarPontos(0);
            else if(p.getPlacarEquipeDaCasa() == p.getPlacarEquipeVisitante())
                equipeCasa.atualizarPontos(1);
       
            EquipeInformation equipe2 = new EquipeInformation(p.getEquipeVisitante().getNome());
            
            
            
  
        }
        
        Collections.sort(tabela);
        return tabela;
    }

    public List<Partida> partidasOrdenadasPorData(Campeonato c) {
        // TODO (1,0) Retornar a lista de partidas de um campeonato ordenadas pela data em que ocorreram
        // Você deve utilizar alguma das estratégias de ordenação apresentadas
        // em sala de aula, não precisando implementar nenhum algoritmo de ordenação
        List<Partida> lista2 = c.getPartidas();
        Collections.sort(lista2);
        List<Partida> lista = new LinkedList<>();
        lista.addAll(c.getPartidas());
        lista.sort(Comparator.comparing(o ->  o.getDataHoraInicio()));
    	return lista;
    }

    public List<Campeonato> listar() {
        return repCampeonato.listar();
    }

    public Campeonato consultar(String nome) throws CampeonatoException {
        return repCampeonato.consultar(nome);
    }

    public void salvar() {
        repCampeonato.salvar();
    }

}
