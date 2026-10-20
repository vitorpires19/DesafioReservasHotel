
import java.util.Locale;
import java.util.Scanner;

public class SistemaReservas {

    private static final int CAPACIDADE = 10;

    private static final Reserva[] reservas =
            new Reserva[CAPACIDADE];

    private static int quantidadeReservas = 0;

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();

            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarReserva();
                    break;

                case 2:
                    listarReservas();
                    break;

                case 3:
                    buscarReserva();
                    break;

                case 4:
                    ordenarReservas();
                    break;

                case 5:
                    System.out.println(
                            "\nSistema encerrado. Ate logo!"
                    );
                    break;

                default:
                    System.out.println(
                            "\nOpcao invalida! Tente novamente."
                    );
            }

        } while (opcao != 5);

        scanner.close();
    }

    // MENU PRINCIPAL
    private static void exibirMenu() {

        System.out.println("\n================================");
        System.out.println("   SISTEMA DE RESERVAS - EBAC");
        System.out.println("================================");
        System.out.println("1 - Nova reserva");
        System.out.println("2 - Listar reservas");
        System.out.println("3 - Buscar reserva por hospede");
        System.out.println("4 - Ordenar por dias (decrescente)");
        System.out.println("5 - Sair");
        System.out.println("================================");
    }

    // CADASTRO
    private static void cadastrarReserva() {

        if (quantidadeReservas >= CAPACIDADE) {
            System.out.println(
                    "\nLimite de 10 reservas atingido!"
            );
            return;
        }

        System.out.println("\n=== NOVA RESERVA ===");

        String nome = lerTexto("Nome do hospede: ");

        String quarto = lerTexto("Tipo do quarto: ");

        int dias = lerInteiroPositivo(
                "Numero de dias: "
        );

        double diaria = lerValorPositivo(
                "Valor da diaria: R$ "
        );

        Reserva novaReserva = new Reserva(
                nome, quarto, dias, diaria
        );

        reservas[quantidadeReservas] = novaReserva;
        quantidadeReservas++;

        System.out.println(
                "\nReserva cadastrada com sucesso!"
        );

        System.out.printf(
                "Valor total: R$ %.2f%n",
                novaReserva.calcularValorTotal()
        );
    }

    // LISTAGEM
    private static void listarReservas() {

        if (quantidadeReservas == 0) {
            System.out.println(
                    "\nNenhuma reserva cadastrada."
            );
            return;
        }

        System.out.println("\n=== RESERVAS CADASTRADAS ===");

        for (int i = 0; i < quantidadeReservas; i++) {

            System.out.println(
                    "\nReserva numero " + (i + 1)
            );

            System.out.println(reservas[i].toString());
        }

        System.out.println(
                "\nTotal de reservas: " + quantidadeReservas
        );
    }

    // BUSCA POR PARTE DO NOME
    private static void buscarReserva() {

        if (quantidadeReservas == 0) {
            System.out.println(
                    "\nNenhuma reserva cadastrada."
            );
            return;
        }

        String busca = lerTexto(
                "Digite parte do nome do hospede: "
        ).toLowerCase(Locale.ROOT);

        boolean encontrou = false;

        System.out.println("\n=== RESULTADO DA BUSCA ===");

        for (int i = 0; i < quantidadeReservas; i++) {

            String nome = reservas[i]
                    .getNomeHospede()
                    .toLowerCase(Locale.ROOT);

            if (nome.contains(busca)) {

                System.out.println(
                        "\n" + reservas[i].toString()
                );

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println(
                    "Nenhuma reserva encontrada."
            );
        }
    }

    // ORDENACAO BUBBLE SORT
    private static void ordenarReservas() {

        if (quantidadeReservas == 0) {
            System.out.println(
                    "\nNenhuma reserva para ordenar."
            );
            return;
        }

        for (int i = 0; i < quantidadeReservas - 1; i++) {

            for (int j = 0;
                 j < quantidadeReservas - 1 - i;
                 j++) {

                if (reservas[j].getNumeroDias()
                        < reservas[j + 1].getNumeroDias()) {

                    Reserva auxiliar = reservas[j];

                    reservas[j] = reservas[j + 1];

                    reservas[j + 1] = auxiliar;
                }
            }
        }

        System.out.println(
                "\nReservas ordenadas por dias (decrescente)!"
        );

        listarReservas();
    }

    // LEITURA DE TEXTO
    private static String lerTexto(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println(
                    "O campo nao pode ficar vazio."
            );
        }
    }

    // LEITURA DE NUMEROS INTEIROS
    private static int lerInteiro(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Digite um numero inteiro valido."
                );
            }
        }
    }

    // VALIDACAO DE DIAS
    private static int lerInteiroPositivo(
            String mensagem) {

        while (true) {

            int valor = lerInteiro(mensagem);

            if (valor >= 1) {
                return valor;
            }

            System.out.println(
                    "O numero de dias deve ser maior que zero."
            );
        }
    }

    // VALIDACAO DA DIARIA
    private static double lerValorPositivo(
            String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String entrada = scanner.nextLine()
                    .trim()
                    .replace(',', '.');

            try {
                double valor = Double.parseDouble(entrada);

                if (Double.isFinite(valor) && valor > 0) {
                    return valor;
                }

            } catch (NumberFormatException e) {
                // Solicita uma nova entrada.
            }

            System.out.println(
                    "Digite um valor maior que zero."
            );
        }
    }
}
