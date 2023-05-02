package me.augusto;

public class Ganho extends Transacao {
    public Ganho(String nome, String tipo, String data, double valor) {
        super(nome, tipo, data, valor);
    }


    @Override
    public String toString() {
        return getNome() + " | " + getTipo() + " | " + getData() + " | " + getValor();
    }
}
