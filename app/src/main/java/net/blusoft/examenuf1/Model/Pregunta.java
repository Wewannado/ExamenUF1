package net.blusoft.examenuf1.Model;

/**
 * Created by IES on 13/12/2016.
 */

public class Pregunta {


    String pregunta;
    String resposta;


    Pregunta(String pregunta, String resposta) {

        this.pregunta = pregunta;
        this.resposta = resposta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getResposta() {
        return resposta;
    }
}
