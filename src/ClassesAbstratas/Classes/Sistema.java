package ClassesAbstratas.Classes;

import ClassesAbstratas.Registro;
import ClassesAbstratas.Veiculo;
import Excessoes.EntradaInvalidaException;
import Excessoes.VeiculoNaoEncontradoException;
import Interfaces.GerenciamentoEntrada;
import Interfaces.GerenciamentoMostragem;
import Interfaces.GerenciamentoSaida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema implements GerenciamentoEntrada, GerenciamentoSaida, GerenciamentoMostragem {
  private List<Registro> veiculosEstacionados = new ArrayList<>();

  public void menu() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Registrar Entrada");
      System.out.println("2. Registrar Saida");
      System.out.println("3. Listar Veículos informados");
      System.out.println("4. Sair");
      System.out.print("Escolha uma opção: ");

      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          registrarEntrada(scanner);

          break;
        case 2:
          try {
            registrarSaida(scanner);
          } catch (VeiculoNaoEncontradoException e) {
            System.out.println(e.getMessage());
          }

          break;
        case 3:
          listarVeiculosEstacionados();

          break;
        case 4:
          System.out.println("Saindo do sistema...");

          return;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  @Override
  public void registrarEntrada(Scanner scanner) {
    try {
    System.out.print("Digite o tipo do veículo (1 para carro, 2 para moto, 3 para bicicleta): ");
    int tipo = scanner.nextInt();

    String textoReferencia = "";

      switch (tipo) {
        case 1:
        case 2:
          textoReferencia = "placa";

          break;
        case 3:
          textoReferencia = "referencia";

          break;
        default:
          throw new EntradaInvalidaException("Tipo de veículo inválido.");
      }

      scanner.nextLine();

      System.out.print("Digite a " + textoReferencia + " do veículo: ");
      String referencia = scanner.nextLine();


      System.out.print("Digite o CPF do cliente: ");
      String cpf = scanner.nextLine();

      System.out.print("Digite o telefone do cliente (DDNNNNNNNNN): ");
      String telefone = scanner.nextLine();

      System.out.print("Digite o horário de entrada (HHMM): ");
      String horarioEntrada = scanner.nextLine();

      System.out.print("Funcioanario responsável pela entrada, digite seu Nome: ");
      String nomeFuncionario = scanner.nextLine();

      Veiculo veiculo = null;

      switch (tipo) {
        case 1:
          veiculo = new Carro(referencia);

          break;
        case 2:
          veiculo = new Moto(referencia);

          break;
        case 3:
          veiculo = new Bicicleta(referencia);
      }

      Cliente cliente = new Cliente(cpf, telefone);

      Funcionario funcionario = new Funcionario(nomeFuncionario);

      Registro registro = new Registro(cliente, veiculo, funcionario, horarioEntrada);

      veiculosEstacionados.add(registro);

      System.out.println("Entrada registrada com sucesso!");

    } catch (EntradaInvalidaException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("Erro inesperado: " + e.getMessage());
      scanner.nextLine(); // Consumir entrada inválida
    }
  }

  @Override
  public void registrarSaida(Scanner scanner) throws VeiculoNaoEncontradoException {
    System.out.print("Digite a referencia do veículo: ");
    String referencia = scanner.nextLine();

    Registro registroSaida = null;
    for (Registro registro : veiculosEstacionados) {
      if (registro.getReferenciaVeiculo().equals(referencia)) {
        registroSaida = registro;

        break;
      }
    }

    if (registroSaida == null) {
      throw new VeiculoNaoEncontradoException("\n Veículo não encontrado!");
    } else {
      System.out.print("Digite o horário de saída (HHMM): ");
      String horaSaida = scanner.nextLine();

      System.out.print("Funcionário responsável pela saída, digite seu nome: ");
      String nomeFuncionario = scanner.nextLine();
      Funcionario funcionarioSaida = new Funcionario(nomeFuncionario);

      double valorAPagar = calcularValor(registroSaida.getHoraEntrada(), horaSaida, registroSaida.getVeiculo().getValorHora());

      registroSaida.registrarSaida(horaSaida, funcionarioSaida, valorAPagar);

      System.out.println("\nSaída registrada com sucesso! o valor do seu ticket é:\n R$ " + valorAPagar);
    }
  }

  @Override
  public void listarVeiculosEstacionados() {
    System.out.println(veiculosEstacionados);
  }

  @Override
  public double calcularValor(String horaEntrada, String horaSaida, double valorHora) {
    String[] entrada = horaEntrada.split("");
    String[] saida = horaSaida.split("");

    int horasEntrada = Integer.parseInt((entrada[0] + entrada[1]));
    int horasSaida = Integer.parseInt((saida[0] + saida[1]));

    int minutosEntrada = Integer.parseInt((entrada[2] + entrada[3]));
    int minutosSaida = Integer.parseInt((saida[2] + saida[3]));

    int totalMinutos = (horasSaida * 60 + minutosSaida) - (horasEntrada * 60 + minutosEntrada);

    int horasPassadas = totalMinutos / 60;
    int minutosPassados = totalMinutos % 60;

    double valorHoraPassada = horasPassadas * valorHora;
    double valorMinutosPassados = (minutosPassados/60.0) * valorHora;

    return valorHoraPassada + valorMinutosPassados;
  }
}
