package br.com.login;

public class Usuario {
  private final String nome;
  private final String senha;

  public Usuario(String nome, String senha) {
    this.nome = nome;
    this.senha = senha;
    System.out.println("Usuario criado com sucesso");
  }

  public String getNome() {
    return "Nome: " + nome;
  }

  public boolean verificaNome(Usuario usuario) {
    return this.nome.equals(usuario.nome);
  }

  public boolean verificaSenha(Usuario usuario) {
    return this.senha.equals(usuario.senha);
  }

  @Override
  public String toString() {
    return "Nome: "+nome;
  }
}
