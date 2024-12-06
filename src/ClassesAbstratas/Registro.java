package ClassesAbstratas;

import ClassesAbstratas.Classes.Bicicleta;
import ClassesAbstratas.Classes.Cliente;
import ClassesAbstratas.Classes.Funcionario;

public class Registro {
  private Cliente cliente;
  private Veiculo veiculo;
  private Funcionario funcionarioEntrada;
  private Funcionario funcionarioSaida;
  private String horaEntrada;
  private String horaSaida;
  private double valor;

  public Registro(Cliente cliente, Veiculo veiculo, Funcionario funcionarioEntrada, String horaEntrada) {
    this.cliente = cliente;
    this.veiculo = veiculo;
    this.funcionarioEntrada = funcionarioEntrada;
    this.funcionarioSaida = null;
    this.horaEntrada = horaEntrada;
    this.horaSaida = null;
  }

  public String getHoraEntrada() {
    return horaEntrada;
  }

  public String getHoraSaida() {
    return horaSaida;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void registrarSaida(String horaSaida, Funcionario funcionarioSaida, double valor) {
    this.funcionarioSaida = funcionarioSaida;
    this.horaSaida = horaSaida;
    this.valor = valor;
  }

  public String getReferenciaVeiculo() {
    if (veiculo instanceof Bicicleta) {
      return ((Bicicleta) veiculo).getReferencia();
    } else {
      return veiculo.getPlaca();
    }
  }

  @Override
  public String toString() {
    return "\nRegistro(" +
            "cliente=" + cliente +
            ", referencia=" + getReferenciaVeiculo() +
            ", funcionarioEntrada='" + funcionarioEntrada.getNome() + '\'' +
            ", horaEntrada='" + horaEntrada + '\'' +
            ", funcionarioSaida='" + (funcionarioSaida != null ? funcionarioSaida.getNome() : null) + '\'' +
            ", horaSaida=" + horaSaida  + '\'' +
            ", valorTicket='" + valor + ")\n";
  }
}
