package ClassesAbstratas.Classes;

import ClassesAbstratas.Veiculo;

public class Bicicleta extends Veiculo {
  private static final double VALOR_HORA = 1.0;
  private String referenciaTexto;

  public Bicicleta(String referenciaTexto) {
    this.referenciaTexto = referenciaTexto;
  }

  public String getReferencia() { return referenciaTexto; }

  public double getValorHora() {
    return VALOR_HORA;
  }
}
