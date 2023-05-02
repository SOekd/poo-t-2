package me.augusto;

import java.util.Objects;

public class Transacao {

    private String nome;

    private String tipo;

    private String data;

    private double valor;

    public Transacao(String nome, String tipo, String data, double valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Double.compare(transacao.valor, valor) == 0 && Objects.equals(nome, transacao.nome) && Objects.equals(tipo, transacao.tipo) && Objects.equals(data, transacao.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo, data, valor);
    }

}
