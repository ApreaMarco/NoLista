/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.edu.marconiverona.nolista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mario
 */
public class Scuola {
    private int id;
    private String nome;
    private static Map<Integer, Scuola> mappaScuola = new HashMap<>(100);

    public Scuola(int id, String nome) {
        this.id = id;
        this.nome = nome;
    
        if (!mappaScuola.containsKey(id)) {
            // Se uso esclusivamente il metodo put dell'hashmap, cambia il riferimento dell'istanza -> UPDATE
            mappaScuola.put(this.id, this);
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
    
    public void addClasse(int idClasse) {
        Classe.getClassebyId(idClasse).setIdScuola(id);
    }
    
    public static Scuola getScuolabyId(int scuolaId) {
        return mappaScuola.get(scuolaId);
    }
    
    public static void removeScuolabyId(int scuolaId) {
        mappaScuola.remove(scuolaId);
    }
    
    public static Iterable<Integer> getListaIdScuola() {
        return mappaScuola.keySet();
    }
    
    public Iterable<Classe> getListaClassi() {
        List<Classe> listaClassi = new ArrayList<>();
        for (Integer idClasse : Classe.getListaIdClasse()) {
            Classe classe = Classe.getClassebyId(idClasse);
            if (classe.getIdScuola() == id) {
                listaClassi.add(classe);
            }
        }
        return listaClassi;
    }
    
    @Override
    public String toString() {
        // Recupero le istanze di Classe collegate a Scuola, usando le chiavi primarie -> JOIN
        // Sarebbe più elegante ed efficiente usare uno StringBuilder
        String toStringListaClasse = "[\n";
        for (Classe classe : getListaClassi()) {
            toStringListaClasse += classe.toString() + '\n';
        }
        toStringListaClasse += "]";
        return "Scuola{" + "id=" + id + ", name=" + nome + ", listaClasse=" + toStringListaClasse + '}';
    }
    
}
