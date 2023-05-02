package me.augusto;

public class Gasto extends Transacao {

    private String tipoDePagamento;

    public Gasto(String nome, String tipo, String data, double valor, String tipoDePagamento) {
        super(nome, tipo, data, valor);
        this.tipoDePagamento = tipoDePagamento;
    }

    @Override
    public String toString() {
        return getNome() + " | " + getTipo() + " | " + getData() + " | " + getValor() + " | " + tipoDePagamento;
    }

}
