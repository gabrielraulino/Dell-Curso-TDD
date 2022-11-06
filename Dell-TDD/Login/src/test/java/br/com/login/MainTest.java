package br.com.login;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  private static Acesso acesso;
  private static Usuario usuario;

  @BeforeAll
  public static void iniciaUsuario_E_Acesso() {
    //Classe Usuario e Acesso já inicializadas para evitar retrabalho de codigo
    usuario = new Usuario("Joao", "1234");
    acesso = new Acesso();

  }

  @Test
  public void deveImprimirMensagemDeSucesso() {
    Usuario usuario = new Usuario("Joao", "1234");
  }

  @Test
  public void deveriaRetornarNomeUsuario() {
    assertEquals("Nome: Joao", usuario.getNome());

  }

  @Test
  public void deveriaCompararNomeComSuceso() {
    assertTrue(usuario.verificaNome(new Usuario("Joao", "1234")));
  }

  @Test
  public void deveriaComparaSenhaComSucesso() {
    assertTrue(usuario.verificaSenha(new Usuario("Joao", "1234")));
  }

  @Test
  public void deveriaIniciarClasseAcesso() {
    Acesso acesso = new Acesso();
  }

  @Test
  public void deveriaCadastrarUsuarioComSucesso() {
    assertTrue(acesso.cadastra(usuario));
  }
  @Test
  public void deveriaCadastrarUsuarioSemSucesso() {
    acesso.cadastra(usuario);
    assertFalse(acesso.cadastra(usuario));
  }
  @Test
  public void deveriaImprimirUmUsuario(){
    acesso.cadastra(usuario);
    Usuario user = new Usuario("Pedro","4321");
    acesso.cadastra(user);
    assertEquals("[Nome: Joao, Nome: Pedro]", acesso.imprimirUsuarios());
  }
  @Test
  public void deveriaRetornarQuantidadeDeUsuarios(){
    acesso.cadastra(usuario);
    assertEquals(1,acesso.quantidadeUsuarios());
  }
  @Test
  public void deveriaVerificarSeNomeConfere(){
    acesso.cadastra(usuario);
    Usuario user = new Usuario("Joao","1234");
  }
  @Test
  public void deveriaVerificarSeSenhaConfere(){
    acesso.cadastra(usuario);
    Usuario usuario2 = new Usuario("Joao", "1234");
    assertTrue(acesso.autenticaSenha(usuario, usuario2));
  }
  @Test
  public void deveriaAutenticarUsuarios(){
    acesso.cadastra(usuario);
    Usuario user = new Usuario("Joao", "1234");
    assertTrue(acesso.login(usuario));
  }
}
