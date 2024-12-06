package Interfaces;

import ClassesAbstratas.Registro;
import Excessoes.VeiculoNaoEncontradoException;

import java.util.Scanner;

public interface GerenciamentoSaida {
  void registrarSaida(Scanner scanner) throws VeiculoNaoEncontradoException;
  double calcularValor(String horaEntrada, String horaSaida, double valorHora);
}
