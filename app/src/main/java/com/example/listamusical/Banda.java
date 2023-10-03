package com.example.listamusical;
import java.util.ArrayList;

public class Banda {
    private String nome;
    private String estilo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Banda(String nome, String estilo) {
        this.nome = nome;
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Banda {" + "nome='" + nome + '\'' + ", estilo='" + estilo + '\'' + '}';
    }
}
