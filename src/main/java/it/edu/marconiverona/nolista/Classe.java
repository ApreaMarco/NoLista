package it.edu.marconiverona.nolista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Simula una tabella MASTER
// Bisognerebbe prevedere anche il comportamento del COMMIT, del ROLLBACK e dell' ONCASCADE
/**
 * Rappresenta un'entità di classe nel sistema. Ogni istanza di questa classe
 * corrisponde a una classe nel sistema. Mantiene un'associazione tra gli ID degli
 * studenti e questa classe utilizzando un'interfaccia Iterable anziché una lista.
 *
 * @author <a href="mailto:marco.aprea@marconiverona.edu.it">Marco Aprea</a>
 * @version 1.0 20240414
 */
public class Classe {

    // Chiave univoca -> PRIMARY KEY
    private int id;
    private String name;
    // Map che contiene tutte le istanze di Classe
    private static Map<Integer, Classe> mappaClasse = new HashMap<>(100);// 100 capability
    private int idScuola;

    /**
     * Costruisce una nuova istanza di {@link Classe} con l'ID e il nome
     * specificati. Se non esiste un'istanza con lo stesso ID, aggiunge questa
     * istanza alla mappa delle classi.
     *
     * @param id L'identificatore univoco per la classe.
     * @param name Il nome della classe.
     */
    public Classe(int id, String name) {
        this.id = id;
        this.name = name;
        // Inserisce l'istanza rappresentata da this nella mappa, controllando che non sia presente l'id -> INSERT
        // Sarebbe più saggio prevedere un metodo apposito
        if (!mappaClasse.containsKey(id)) {
            // Se uso esclusivamente il metodo put dell'hashmap, cambia il riferimento dell'istanza -> UPDATE
            mappaClasse.put(this.id, this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdScuola() {
        return idScuola;
    }

    public void setIdScuola(int idScuola) {
        this.idScuola = idScuola;
    }

    
    /**
     * Restituisce una rappresentazione in stringa dell'oggetto {@link Classe}.
     * Questo include l'ID della classe, il nome e una lista di ID studente
     * associati ad essa.
     *
     * @return Una rappresentazione in stringa dell'oggetto classe.
     */
    @Override
    public String toString() {
        // Recupero le istanze di Studente collegate a Classe, usando le chiavi primarie -> JOIN
        // Sarebbe più elegante ed efficiente usare uno StringBuilder
        String toStringListaStudente = "[\n";
        for (Studente studente : getListaStudenti()) {
            toStringListaStudente += studente.toString() + '\n';
        }
        toStringListaStudente += "]";
        return "Classe{" + "id=" + id + ", name=" + name + ", idScuola=" + idScuola + ", listaStudente=" + toStringListaStudente + '}';
    }

    // Metodo che restituisce un instanza di Classe che ha quell'id -> SELECT
    /**
     * Recupera un'istanza di {@link Classe} dal suo ID dalla mappa delle
     * classi.
     *
     * @param id L'ID della classe da recuperare.
     * @return Un'istanza di {@link Classe} se trovata, altrimenti null.
     */
    public static Classe getClassebyId(int id) {
        return mappaClasse.get(id);
    }

    // Metodo che elimina un instanza di Classe che ha quell'id -> DELETE
    /**
     * Rimuove un'istanza di {@link Classe} dalla mappa delle classi dal suo ID.
     *
     * @param id L'ID della classe da rimuovere.
     */
    public static void removeClasseById(int id) {
        mappaClasse.remove(id);
    }

    /**
     * Aggiunge un ID studente alla lista di ID studente associati a questa
     * istanza di classe. Aggiorna anche l'ID di classe corrispondente
     * nell'istanza studente associata.
     *
     * @param idStudente L'ID dello studente da aggiungere.
     */
    public void addStudente(int idStudente) {
        // Vincolo di integrità referenziale
        Studente updateStudente = Studente.getStudentebyID(idStudente);
        updateStudente.setIdClasse(id);
    }

    // Metodo per ottenere un'iterabile degli studenti nella classe -> JOIN
    /**
     * Restituisce un iterabile di studenti associati a questa istanza di
     * {@link Classe}.
     *
     * @return Un iterabile di studenti associati alla classe.
     */
    public Iterable<Studente> getListaStudenti() {
        List<Studente> listaStudenti = new ArrayList<>();
        for (Integer idStudente : Studente.getListaIdStudente()) {
            Studente studente = Studente.getStudentebyID(idStudente);
            if (studente.getIdClasse() == id) {
                listaStudenti.add(studente);
            }
        }
        return listaStudenti;
    }

    // Metodo per ottenere un'iterabile degli ID delle classi
    /**
     * Restituisce un iterabile di ID delle classi nel sistema.
     *
     * @return Un iterabile di ID delle classi.
     */
    public static Iterable<Integer> getListaIdClasse() {
        return mappaClasse.keySet();
    }

}
