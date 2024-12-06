package ClassesAbstratas.Classes;

import ClassesAbstratas.Pessoa;

public class Funcionario extends Pessoa {
  String nome;

  public Funcionario(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
}
