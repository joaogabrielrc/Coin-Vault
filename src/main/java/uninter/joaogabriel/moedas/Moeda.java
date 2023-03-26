package uninter.joaogabriel.moedas;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;


public abstract class Moeda {

  protected BigDecimal valor;

  public Moeda(BigDecimal valor) {
    this.valor = valor.setScale(2, HALF_UP);
  }

  public abstract void info();

  public abstract BigDecimal converter();

}
