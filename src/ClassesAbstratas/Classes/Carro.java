package ClassesAbstratas.Classes;

import ClassesAbstratas.Veiculo;

public class Carro extends Veiculo {
  private static final double VALOR_HORA = 10.0;

  public Carro(String placa) {
    super(placa);
  }

  @Override
  public double getValorHora() {
    return VALOR_HORA;
  }
}
