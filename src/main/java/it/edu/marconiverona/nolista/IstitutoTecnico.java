/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.edu.marconiverona.nolista;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class IstitutoTecnico extends Scuola {

    public IstitutoTecnico(int id, String nome) {
        super(id, nome);
    }
    
    public void addLaboratorio(int idLaboratorio) {
        Laboratorio.getLaboratoriobyId(idLaboratorio).setIdIstitutoTecnico(super.getId());
    }
    
    public Iterable<Laboratorio> getListaLaboratori() {
        List<Laboratorio> listaLaboratori = new ArrayList<>();
        for (Integer idLaboratorio : Laboratorio.getListaIdLoboratorio()) {
            Laboratorio laboratorio = Laboratorio.getLaboratoriobyId(idLaboratorio);
            if (laboratorio.getIdIstitutoTecnico() == super.getId()) {
                listaLaboratori.add(laboratorio);
            }
        }
        return listaLaboratori;
    }
    
    @Override
    public String toString() {
        String toStringListaLaboratorio = "[\n";
        for (Laboratorio laboratorio : getListaLaboratori()) {
            toStringListaLaboratorio += laboratorio.toString() + '\n';
        }
        
        toStringListaLaboratorio += "]";
        return "IstitutoTecnico{" + super.toString() + ", listaLaboratorio=" + toStringListaLaboratorio + "}";
    }
    
}
