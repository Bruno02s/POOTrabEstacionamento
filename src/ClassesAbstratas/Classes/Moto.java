package ClassesAbstratas.Classes;

import ClassesAbstratas.Veiculo;

public class Moto extends Veiculo {
  private static final double VALOR_HORA = 5.0;

  public Moto(String placa) {
    super(placa);
  }

  @Override
  public double getValorHora() {
    return VALOR_HORA;
  }
}
