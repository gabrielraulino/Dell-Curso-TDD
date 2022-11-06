package br.com.login;

import javax.swing.*;


public class Main {
  public static void main(String[] args) {
    Usuario usuario = new Usuario("joao","1234");
    JFrame telaInicial = new JFrame("Tela Login");
    telaInicial.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Acesso acesso = new Acesso();
    acesso.cadastra(usuario);
    JTextField login = new JTextField();
    JPasswordField senha = new JPasswordField();

    login.setHorizontalAlignment(JTextField.RIGHT);
    senha.setHorizontalAlignment(JTextField.RIGHT);
    login.setBounds(100,0, 150,20);
    senha.setBounds(100,50, 150,20);
    JButton botaoLogar = new JButton("Entrar");
    botaoLogar.setBounds(125,100,95,30);
    JButton botaoCadastar = new JButton("Cadastrar");
    botaoCadastar.setBounds(125, 150,95,30);

    botaoLogar.addActionListener(e -> {
      String loginUsuario = login.getText();
      String senhaUsuario = String.valueOf(senha.getPassword());
      Usuario usuario12 = new Usuario(loginUsuario, senhaUsuario);
      if(acesso.login(usuario12)) {
        TelaAcesso telaAcesso = new TelaAcesso();
        telaAcesso.mostra();
        login.setText("");
        senha.setText("");
      } else{
        JFrame fail = new JFrame();
        JOptionPane.showMessageDialog(fail, "Usuario ou senha incorreto","Alerta", JOptionPane.WARNING_MESSAGE);
        login.setText("");
        senha.setText("");
      }
    });

    botaoCadastar.addActionListener(e -> {
      TelaCadastro cadastro = new TelaCadastro(acesso);

    });
    telaInicial.add(botaoLogar);
    telaInicial.add(botaoCadastar);
    telaInicial.add(login);
    telaInicial.add(senha);
    telaInicial.setSize(400,400);
    telaInicial.setLayout(null);
    telaInicial.setVisible(true);
  }
}