import java.util.Scanner;

public class Menu {

    public void retornaMenu() {
        System.out.println("--------------------------------------");
        System.out.println("          CONVERSOR DE MOEDAS         ");
        System.out.println("--------------------------------------");
        System.out.println("1 - Dolar para Peso Argentino         ");
        System.out.println("2 - Peso Argentino para Dolar         ");
        System.out.println("3 - Dolar para Real brasileiro        ");
        System.out.println("4 - Real brasileiro para Dolar        ");
        System.out.println("5 - Dolar para Peso Colombiano        ");
        System.out.println("6 - Peso colombiano para  Dolar       ");
        System.out.println("7 - Finalizar                         ");
        System.out.println("--------------------------------------");
    }

    public String converterMoeda(String moeda1, String moeda2, double valor) {
        Exchange exchange = new Exchange();
        ExchangeApi novoEndereco = exchange.retornaValor(moeda1, moeda2);
        String conversao = moeda1 + ": " + valor + "= " + moeda2 + ": ";

        String convertido = String.format("%.2f", valor * Double.valueOf(novoEndereco.conversion_rate()));
        String resultado = conversao + convertido;
        return resultado;
    }

    public void escolhaMoeda() {
        System.out.println("Digite qual moeda deseja converter: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int opcao = scanner.nextInt();
            if (opcao == 7)
                System.exit(0);
            System.out.println("Insira o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            switch (opcao) {
                case 1:
                    String opcao1 = converterMoeda("USD", "ARS", valor);
                    System.out.println(opcao1);
                    break;
                case 2:
                    String opcao2 = converterMoeda("ARS", "USD", valor);
                    break;
                case 3:
                    String opcao3 = converterMoeda("USD", "BRL", valor);
                    System.out.println(opcao3);
                    break;
                case 4:
                    String opcao4 = converterMoeda("BRL", "USD", valor);
                    System.out.println(opcao4);
                    break;
                case 5:
                    String opcao5 = converterMoeda("USD", "COP", valor);
                    System.out.println(opcao5);
                    break;
                case 6:
                    String opcao6 = converterMoeda("COP", "USD", valor);
                    System.out.println(opcao6);
                    break;
                case 7:
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e ){
            throw new RuntimeException("A conversão não pode ser realizada com os valores inseridos. Tente novamente");
        }
    }
}

