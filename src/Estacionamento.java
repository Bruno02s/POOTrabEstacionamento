import ClassesAbstratas.Classes.Sistema;
import Excessoes.VeiculoNaoEncontradoException;

public class Estacionamento {
  public static void main(String[] args) throws VeiculoNaoEncontradoException {
    Sistema sistema = new Sistema();

    sistema.menu();
  }
}