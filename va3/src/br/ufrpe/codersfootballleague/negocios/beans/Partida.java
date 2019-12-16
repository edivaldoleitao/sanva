/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.codersfootballleague.negocios.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Partida implements Serializable,Comparable<Partida> {
    private Equipe equipeVisitante;
    private Equipe equipeDaCasa;
    private LocalDateTime dataHoraInicio;
    private short placarEquipeVisitante;
    private short placarEquipeDaCasa;

    public Partida(Equipe equipeVisitante, Equipe equipeDaCasa, 
            LocalDateTime dataHoraInicio, short placarEquipeVisitante, short placarEquipeDaCasa) {
        this.equipeVisitante = equipeVisitante;
        this.equipeDaCasa = equipeDaCasa;
        this.dataHoraInicio = dataHoraInicio;
        this.placarEquipeVisitante = placarEquipeVisitante;
        this.placarEquipeDaCasa = placarEquipeDaCasa;
    }

    public Equipe getEquipeVisitante() {
        return equipeVisitante;
    }

    public Equipe getEquipeDaCasa() {
        return equipeDaCasa;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public short getPlacarEquipeVisitante() {
        return placarEquipeVisitante;
    }

    public short getPlacarEquipeDaCasa() {
        return placarEquipeDaCasa;
    }

    @Override
    public boolean equals(Object obj) {
    	boolean test = false;
    	if(obj!= null) {
    		if(((Partida) obj).getEquipeDaCasa().equals(this.equipeDaCasa) && ((Partida) obj).getEquipeVisitante().equals(this.equipeVisitante))
    			if(((Partida) obj).getDataHoraInicio().equals(this.dataHoraInicio))
    				test = true;
    		
    	}
        return test;
    }
    public abstract double calcularRenda();
    
    
    @Override
    public int compareTo(Partida p) {
        return this.dataHoraInicio.compareTo(p.getDataHoraInicio());
    }

}
