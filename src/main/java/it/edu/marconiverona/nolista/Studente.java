package it.edu.marconiverona.nolista;

import java.util.HashMap;
import java.util.Map;

// Simula una tabella SLAVE
// Bisognerebbe prevedere anche il comportamento del COMMIT, del ROLLBACK e dell' ONCASCADE
/**
 * Rappresenta un'entità studente nel sistema. Ogni istanza di questa classe
 * corrisponde a uno studente nel sistema. Mantiene un mapping degli ID studente
 * alle istanze studente.
 *
 * @author <a href="mailto:marco.aprea@marconiverona.edu.it">Marco Aprea</a>
 * @version 1.0 20240414
 */
public class Studente {

    // Chiave univoca -> PRIMARY KEY
    private int id;
    private String matricola;
    // Map che contiene tutte le istanze di Studente
    private static Map<Integer, Studente> mappaStudente = new HashMap<>(100);// 100 capability
    // Collegamento con l'istanza di Classe -> FOREIGN KEY
    private int idClasse;

    /**
     * Costruisce una nuova istanza di {@link Studente} con l'ID e la matricola
     * specificati. Se non esiste un'istanza con lo stesso ID, aggiunge questa
     * istanza alla mappa degli studenti.
     *
     * @param id L'identificatore univoco per lo studente.
     * @param matricola La matricola dello studente.
     */
    public Studente(int id, String matricola) {
        this.id = id;
        this.matricola = matricola;
        // Inserisce l'istanza rappresentata da this nella mappa, controllando che non sia presente l'id -> INSERT
        // Sarebbe più saggio prevedere un metodo apposito
        if (!mappaStudente.containsKey(id)) {
            // Se uso esclusivamente il metodo put dell'hashmap, cambia il riferimento dell'istanza -> UPDATE
            mappaStudente.put(this.id, this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * Restituisce una rappresentazione in stringa dell'oggetto
     * {@link Studente}. Questo include l'ID dello studente, la matricola e l'ID
     * di classe associato.
     *
     * @return Una rappresentazione in stringa dell'oggetto studente.
     */
    @Override
    public String toString() {
        return "StudenteSCI{" + "id=" + id + ", matricola=" + matricola + ", idClasseSC=" + idClasse + '}';
    }

    // Collegamento con la Classe
    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    // Metodo che restituisce un instanza di Studente che ha quell'id -> SELECT
    /**
     * Restituisce l'istanza di {@link Studente} corrispondente all'ID
     * specificato.
     *
     * @param id L'ID dello studente da cercare.
     * @return L'istanza di {@link Studente} se trovata, altrimenti null.
     */
    public static Studente getStudentebyID(int id) {
        return mappaStudente.get(id);
    }

    // Metodo che elimina un instanza di Classe che ha quell'id -> DELETE
    /**
     * Rimuove l'istanza di {@link Studente} corrispondente all'ID specificato.
     *
     * @param id L'ID dello studente da rimuovere.
     */
    public static void removeStudenteById(int id) {
        mappaStudente.remove(id);
    }

    // Metodo per ottenere un'iterabile degli ID degli studenti
    /**
     * Restituisce un iterabile di ID degli studenti nel sistema.
     *
     * @return Un iterabile di ID degli studenti.
     */
    public static Iterable<Integer> getListaIdStudente() {
        return mappaStudente.keySet();
    }
}
