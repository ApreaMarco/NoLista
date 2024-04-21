/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.edu.marconiverona.nolista;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mario
 */
public class Laboratorio {
    private int id;
    private String nome;
    private static Map<Integer, Laboratorio> mappaLaboratorio = new HashMap<>();
    private int idIstitutoTecnico;

    public Laboratorio(int id, String nome) {
        this.id = id;
        this.nome = nome;
        
        if (!mappaLaboratorio.containsKey(id)) {
            // Se uso esclusivamente il metodo put dell'hashmap, cambia il riferimento dell'istanza -> UPDATE
            mappaLaboratorio.put(this.id, this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdIstitutoTecnico() {
        return idIstitutoTecnico;
    }

    public void setIdIstitutoTecnico(int idIstitutoTecnico) {
        this.idIstitutoTecnico = idIstitutoTecnico;
    }
    
    public static Laboratorio getLaboratoriobyId(int idLaboratorio) {
        return mappaLaboratorio.get(idLaboratorio);
    }
    
    public static void removeLaboratoriobyId(int idLaboratorio) {
        mappaLaboratorio.remove(idLaboratorio);
    }
    
    public static Iterable<Integer> getListaIdLoboratorio() {
        return mappaLaboratorio.keySet();
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "id=" + id + ", nome=" + nome + ", idIstitutoTecnico=" + idIstitutoTecnico + '}';
    }
    
}
