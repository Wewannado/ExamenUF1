package net.blusoft.examenuf1.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IES on 13/12/2016.
 */

public class Preguntes {

    ArrayList<Pregunta> llistaPreguntes;

    public Preguntes() {
        llistaPreguntes = new ArrayList<>();
    }

    public ArrayList<Pregunta> getPreguntes(int tema, int numeroPreguntes) {

        for (int cont = 0; cont < numeroPreguntes; cont++) {

            llistaPreguntes.add(new Pregunta("Pregunta número" + cont + " Quan fan 2 + 2?", "4"));
        }
        return llistaPreguntes;
    }
}
