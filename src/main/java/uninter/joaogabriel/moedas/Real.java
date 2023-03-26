package uninter.joaogabriel.moedas;

import java.math.BigDecimal;


public class Real extends Moeda {

  public Real(BigDecimal valor) {
    super(valor);
  }

  @Override
  public void info() {
    System.out.println("Real: R$" + super.valor);
  }

  @Override
  public BigDecimal converter() {
    return super.valor;
  }

}
