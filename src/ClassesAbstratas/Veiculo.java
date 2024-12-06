package ClassesAbstratas;

public abstract class Veiculo {
  private String placa = null;

  public Veiculo(String placa) {
    this.placa = placa;
  }

  public Veiculo() {}

  public String getPlaca() { return placa; }

  public abstract double getValorHora();

  @Override
  public String toString() {
    return "Placa: " + placa;
  }
}
