package uninter.joaogabriel.moedas;

import java.math.BigDecimal;


public class Euro extends Moeda {
  private final BigDecimal cotacao = new BigDecimal("5.66");

  public Euro(BigDecimal valor) {
    super(valor);
  }

  @Override
  public void info() {
    System.out.println("Euro: €" + super.valor);
  }

  @Override
  public BigDecimal converter() {
    return super.valor.multiply(this.cotacao);
  }

}
