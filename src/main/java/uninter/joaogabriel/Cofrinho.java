package uninter.joaogabriel;

import uninter.joaogabriel.moedas.Moeda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ZERO;
import static java.math.RoundingMode.HALF_UP;


public class Cofrinho {

  private final List<Moeda> listaMoedas = new ArrayList<>();

  public void adicionar(Moeda moeda) {
    listaMoedas.add(moeda);
    System.out.println("Adicionado com sucesso!");
  }

  public void remover(Moeda moeda) {
    listaMoedas.remove(moeda);
    System.out.println("Removido com sucesso!");
  }

  public List<Moeda> listagemMoedas() {
    return this.listaMoedas;
  }

  public BigDecimal totalConvertido() {
    return listaMoedas.stream()
        .map(Moeda::converter)
        .reduce(
            new BigDecimal(ZERO),
            BigDecimal::add
        ).setScale(2, HALF_UP);
  }

}
