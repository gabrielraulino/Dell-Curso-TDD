package br.com.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Acesso {
  List<Usuario> usuarios = new ArrayList<>();

  public Acesso() {
    System.out.println("Acesso criado com sucesso!");
  }

  public boolean cadastra(Usuario usuario) {
    return contemUsuario(usuario) ? false : usuarios.add(usuario);
  }

  public String imprimirUsuarios() {
    return usuarios.toString();
  }

  public int quantidadeUsuarios() {
    return usuarios.size();
  }


  public boolean autenticaSenha(Usuario usuario, Usuario usuario2) {
    return usuario.verificaSenha(usuario2);
  }

  public Optional<Usuario> buscaUsuario(Usuario user) {
    try {
      return Optional.ofNullable(usuarios
          .stream()
          .filter(e -> e.getNome().equals(user.getNome()))
          .iterator()
          .next());
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  public boolean contemUsuario(Usuario user) {
    return usuarios
        .stream()
        .filter(e -> e.getNome().equals(user.getNome()))
        .iterator()
        .hasNext();
  }

  public boolean login(Usuario usuario) {
    if(!contemUsuario(usuario))
        return false;
    return autenticaSenha(buscaUsuario(usuario).get(),usuario);
  }
}
