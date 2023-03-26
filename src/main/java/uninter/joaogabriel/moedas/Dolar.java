package uninter.joaogabriel.moedas;

import java.math.BigDecimal;


public class Dolar extends Moeda {

  private final BigDecimal cotacao = new BigDecimal("5.25");

  public Dolar(BigDecimal valor) {
    super(valor);
  }

  @Override
  public void info() {
    System.out.println("Dólar: $" + super.valor);
  }

  @Override
  public BigDecimal converter() {
    return super.valor.multiply(this.cotacao);
  }

}
