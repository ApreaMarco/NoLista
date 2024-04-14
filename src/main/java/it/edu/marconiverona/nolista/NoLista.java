package it.edu.marconiverona.nolista;

/**
 * Rappresenta una collezione di istanze di {@link Classe} e {@link Studente}.
 * Questa classe fornisce una dimostrazione della gestione delle istanze di
 * {@link Studente} all'interno delle istanze di {@link Classe}.
 *
 * @author <a href="mailto:marco.aprea@marconiverona.edu.it">Marco Aprea</a>
 * @version 1.0 20240414
 * @see
 * <a href="https://it.wikipedia.org/wiki/Class_diagram#Relazione">Wikipedia:
 * UML Relazione</a>
 */
public class NoLista {

    /**
     * Metodo principale che mostra l'utilizzo delle istanze di {@link Classe}
     * e {@link Studente}. Crea diverse istanze di entrambe le classi,
     * aggiunge studenti alle classi e visualizza informazioni sulle classi e
     * sugli studenti.
     *
     * @param args Gli argomenti da riga di comando passati al programma.
     */
    public static void main(String[] args) {
        Studente st01 = new Studente(10, "20010");
        Studente st02 = new Studente(11, "20011");
        Studente st03 = new Studente(12, "20012");
        Studente st04 = new Studente(13, "20013");
        Studente st05 = new Studente(14, "20014");

        Classe cl01 = new Classe(200, "3ei");
        Classe cl02 = new Classe(200, "3ei");

        cl01.addStudente(st01.getId());
        cl01.addStudente(st02.getId());

        cl02.addStudente(st03.getId());

        System.out.println("--- Studenti della classe cl01 ---");
        System.out.println(cl01.toString());

        System.out.println("--- Studenti della classe cl02 ---");
        System.out.println(cl02.toString());

        System.out.println("--- Studenti della classe con id 200 ---");
        Classe clId200 = Classe.getClassebyId(200);
        System.out.println(clId200.toString());
    }
}
