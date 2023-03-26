package uninter.joaogabriel;

import uninter.joaogabriel.moedas.Dolar;
import uninter.joaogabriel.moedas.Euro;
import uninter.joaogabriel.moedas.Moeda;
import uninter.joaogabriel.moedas.Real;

import java.math.BigDecimal;
import java.util.*;


public class Main {

  private static final Cofrinho cofrinho = new Cofrinho();
  private static boolean continuarLoop = true;

  public static void main(String[] args) {
    while (continuarLoop) {
      mostrarMenuPrincipal();

      Scanner scanner = new Scanner(System.in);

      switch (scanner.nextLine()) {
        case "1" -> adicionarMoeda();
        case "2" -> removerMoeda();
        case "3" -> listarMoedas();
        case "4" -> calcularTotalEmReal();
        case "0" -> finalizarPrograma();
        default -> repetirPergunta();
      }
    }

  }

  private static void calcularTotalEmReal() {
    System.out.println("Total: R$" + cofrinho.totalConvertido());
  }

  private static void mostrarMenuPrincipal() {
    System.out.println("\nCOFRINHO:");
    System.out.println("1-Adicionar Moeda");
    System.out.println("2-Remover Moeda");
    System.out.println("3-Listar Moedas");
    System.out.println("4-Calcular total convertido em real");
    System.out.println("0-Encerrar");
  }

  private static BigDecimal obterValor() throws InputMismatchException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nDigite o valor:");
    return scanner.nextBigDecimal();
  }

  private static void mostrarMenuEscolherMoeda() {
    System.out.println("\nEscolha a moeda:");
    System.out.println("1-Real");
    System.out.println("2-Dólar");
    System.out.println("3-Euro");
  }

  private static void adicionarMoeda() {
    mostrarMenuEscolherMoeda();

    Scanner scanner = new Scanner(System.in);
    String tipoMoeda = scanner.nextLine();

    try {
      switch (tipoMoeda) {
        case "1" -> {
          Moeda real = new Real(obterValor());
          cofrinho.adicionar(real);
        }
        case "2" -> {
          Moeda dolar = new Dolar(obterValor());
          cofrinho.adicionar(dolar);
        }
        case "3" -> {
          Moeda euro = new Euro(obterValor());
          cofrinho.adicionar(euro);
        }
        default -> repetirPergunta();
      }
    } catch (InputMismatchException e) {
      repetirPergunta();
    }
  }

  private static void listarMoedas() {
    System.out.println();
    cofrinho.listagemMoedas().forEach(Moeda::info);
  }

  private static void removerMoeda() {
    mostrarMenuEscolherMoeda();

    Scanner scanner = new Scanner(System.in);
    String tipoMoeda = scanner.nextLine();

    List<String> tiposDeMoedaDisponiveis = new ArrayList<>(
        List.of("1", "2", "3")
    );

    if (tiposDeMoedaDisponiveis.contains(tipoMoeda)) {
      Optional<Moeda> optionalMoeda = cofrinho.listagemMoedas()
          .stream()
          .filter(moeda -> moeda
              .converter()
              .equals(obterValor())
          )
          .findFirst();

      if (optionalMoeda.isPresent()) {
        cofrinho.remover(optionalMoeda.get());
      } else {
        System.out.println("Essa moeda com esse valor não existe.");
      }
    } else {
      repetirPergunta();
    }
  }

  private static void finalizarPrograma() {
    System.out.println("\nFim do programa.");
    continuarLoop = false;
  }

  private static void repetirPergunta() {
    System.out.println("\nDigite um valor válido.");
  }

}
