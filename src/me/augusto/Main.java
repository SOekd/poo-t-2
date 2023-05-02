package me.augusto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final List<Transacao> transacoes = new ArrayList<>();


    public static void main(String[] args) {

        while (true) {

            System.out.println(
                    """
                    Gestão Financeira
                    -----------------------
                    1 - Adicionar Gasto
                    2 - Adicionar Ganho
                    3 - Relatório de Gastos
                    4 - Relatório de Ganhos
                    5 - Relatório Mensal
                    6 - Sair
                    """
            );

            int entrada = SCANNER.nextInt();

            switch (entrada) {
                case 1 -> adicionarGasto();
                case 2 -> adicionarGanho();
                case 3 -> {
                    System.out.println("Gasto | Tipo | Data | Valor | Forma de Pagamento");
                    for (Transacao transacao : transacoes) {
                        if (transacao instanceof Gasto)
                            System.out.println(transacao);
                    }
                }
                case 4 -> {
                    System.out.println("Gasto | Tipo | Data | Valor");
                    for (Transacao transacao : transacoes) {
                        if (transacao instanceof Ganho)
                            System.out.println(transacao);
                    }
                }
                case 5 -> {
                    System.out.println("Diga o mês que deseja ver o relatório:");
                    int mes = SCANNER.nextInt();
                    System.out.println("Diga o ano que deseja ver o relatório:");
                    int ano = SCANNER.nextInt();

                    double totalGastos = 0;
                    double totalGanho = 0;
                    for (Transacao transacao : transacoes) {
                        String[] dataDividida = transacao.getData().split(Pattern.quote("/"));
                        int mesTransacao = Integer.parseInt(dataDividida[1]);
                        int anoTransacao = Integer.parseInt(dataDividida[2]);

                        if (ano == anoTransacao && mes == mesTransacao) {
                            if (transacao instanceof Gasto) {
                                totalGastos += transacao.getValor();
                            } else if (transacao instanceof Ganho) {
                                totalGanho += transacao.getValor();
                            }
                        }
                    }
                    double saldo = totalGanho - totalGastos;
                    System.out.println( "Relatório Mensal\n" +
                            "-----------------------\n" +
                            codigoMesParaMesNome(mes) + " de " + ano + "\n" +
                            "Ganho Total : R$" + totalGanho + "\n" +
                            "Gasto total : R$" + totalGastos + "\n" +
                            "Saldo: " + saldo
                    );

                }
                case 6 -> {
                    System.out.println("Saindo...");
                    return;
                }
            }


        }

    }

    private static void adicionarGanho() {
        while (true) {
            System.out.println(
                    """
                    Selecione o tipo de ganho
                    -----------------------
                    1 - Salário
                    2 - Investimento
                    3 - Doação
                    4 - Freelance
                    99 - Voltar
                    """
            );

            String tipoDeGanho;
            switch (SCANNER.nextInt()) {
                case 1 -> tipoDeGanho = "Salário";
                case 2 -> tipoDeGanho = "Investimento";
                case 3 -> tipoDeGanho = "Doação";
                case 4 -> tipoDeGanho = "Freelance";
                case 99 -> {
                    System.out.println("Saindo da etapa de adicionar gasto...");
                    return;
                }
                default -> {
                    System.out.println("Gasto desconhecido!");
                    continue;
                }
            }

            System.out.println("Digite a data do ganho (dia/mês/ano):");
            String data = SCANNER.next();

            System.out.println("Digite a quantidade ganha:");
            double valorGanho = SCANNER.nextDouble();

            System.out.println("Escreva o nome do gasto: ");
            String nomeDoGanho = SCANNER.next();

            Ganho ganho = new Ganho(
                    nomeDoGanho,
                    tipoDeGanho,
                    data,
                    valorGanho
            );

            transacoes.add(ganho);
            return;
        }
    }

    private static void adicionarGasto() {
        while (true) {
            System.out.println(
                    """
                    Selecione o tipo de gasto
                    -----------------------
                    1 - Habitação
                    2 - Entretenimento
                    3 - Alimentação
                    4 - Transporte
                    99 - Voltar
                    """
            );

            String tipoDeGasto;
            switch (SCANNER.nextInt()) {
                case 1 -> tipoDeGasto = "Habitação";
                case 2 -> tipoDeGasto = "Entretenimento";
                case 3 -> tipoDeGasto = "Alimentação";
                case 4 -> tipoDeGasto = "Transporte";
                case 99 -> {
                    System.out.println("Saindo da etapa de adicionar gasto...");
                    return;
                }
                default -> {
                    System.out.println("Gasto desconhecido!");
                    continue;
                }
            }

            System.out.println("Digite a data do gasto (dia/mês/ano):");
            String data = SCANNER.next();

            System.out.println("Digite a quantidade gasta:");
            double valorGasto = SCANNER.nextDouble();

            System.out.println(
                    """
                    Selecione o método de pagamento
                    -----------------------
                    1 - Cheque
                    2 - Pix
                    3 - Débito
                    """
            );


            int metodoCodigo = SCANNER.nextInt();
            String metodoDePagamento;
            switch (metodoCodigo) {
                case 1 -> metodoDePagamento = "Cheque";
                case 2 -> metodoDePagamento = "Pix";
                case 3 -> metodoDePagamento = "Débito";
                default -> {
                    System.out.println("O método de pagamento é inválido, cancelando.");
                    return;
                }
            }

            System.out.println("Escreva o nome do gasto: ");
            String nomeGasto = SCANNER.next();

            Gasto gasto = new Gasto(
                    nomeGasto,
                    tipoDeGasto,
                    data,
                    valorGasto,
                    metodoDePagamento
            );

            transacoes.add(gasto);
            return;
        }
    }


    private static String codigoMesParaMesNome(int codigo) {
        switch (codigo) {
            case 1 -> {
                return "Janeiro";
            }
            case 2 -> {
                return "Fevereiro";
            }
            case 3 -> {
                return "Março";
            }
            case 4 -> {
                return "Abril";
            }
            case 5 -> {
                return "Maio";
            }
            case 6 -> {
                return "Junho";
            }
            case 7 -> {
                return "Julho";
            }
            case 8 -> {
                return "Agosto";
            }
            case 9 -> {
                return "Setembro";
            }
            case 10 -> {
                return "Outubro";
            }
            case 11 -> {
                return "Novembro";
            }
            case 12 -> {
                return "Dezembro";
            }
            default -> {
                return "Desconhecido";
            }
        }
    }

}