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
        Classe cl02 = new Classe(201, "1ei");
        Classe cl03 = new Classe(202, "2ei");
        Classe cl04 = new Classe(203, "4ei");
        
        Laboratorio lb01 = new Laboratorio(400, "UwU");
        Laboratorio lb02 = new Laboratorio(401, "OwO");
        Laboratorio lb03 = new Laboratorio(402, ">w<");
        Laboratorio lb04 = new Laboratorio(403, "^w^");
        
        Scuola sc01 = new Scuola(2000, "Guglielmo Marconi");
        Scuola sc02 = new Scuola(2002, "Luigi Pizza Pie :3");
        
        IstitutoTecnico it01 = new IstitutoTecnico(3000, "mamma mia pizzeria");
        IstitutoTecnico it02 = new IstitutoTecnico(3001, "Istituto delle belle arti");
        
        cl01.addStudente(st01.getId());
        cl02.addStudente(st02.getId());
        cl03.addStudente(st03.getId());
        cl04.addStudente(st04.getId());
        cl04.addStudente(st05.getId());
        
        sc01.addClasse(cl01.getId());
        sc01.addClasse(cl02.getId());
        sc02.addClasse(cl03.getId());
        sc02.addClasse(cl04.getId());
        
        it01.addLaboratorio(lb01.getId());
        it01.addLaboratorio(lb02.getId());
        it02.addLaboratorio(lb03.getId());
        it02.addLaboratorio(lb04.getId());
        
        System.out.println("scuola1:\n" + sc01.toString());
        System.out.println("scuola2:\n" + sc02.toString());
        
        System.out.println("IstitutoTecnico1:\n" + it01.toString());
        System.out.println("IstitutoTecnico2:\n" + it02.toString());
        
        
    }
}
