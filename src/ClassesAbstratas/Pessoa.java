package ClassesAbstratas;

public abstract class Pessoa {
  private String cpf = null;
  private String telefone = null;

  public Pessoa(String cpf, String telefone) {
    this.cpf = cpf;
    this.telefone = telefone;
  }

  public Pessoa() {}

  public String getCpf() { return cpf; }
  public String getTelefone() { return telefone; }

  @Override
  public String toString() {
    return "CPF: " + cpf + ", Telefone: " + telefone;
  }
}
