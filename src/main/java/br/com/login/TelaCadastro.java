package br.com.login;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
  JTextField login;
  JPasswordField senha;
  JButton botaoCadastar;
  public TelaCadastro(Acesso acesso) throws HeadlessException {
    this.setTitle("Cadastrar Usuario");
    this.setSize(400,400);
    JTextField login = new JTextField();
    JPasswordField senha = new JPasswordField();

    login.setHorizontalAlignment(JTextField.RIGHT);
    senha.setHorizontalAlignment(JTextField.RIGHT);
    login.setBounds(100,0, 150,20);
    senha.setBounds(100,50, 150,20);

    JButton botaoCadastar = new JButton("Cadastrar");
    botaoCadastar.setBounds(125, 100,95,30);
    setLayout(null);
    add(login);
    add(senha);
    add(botaoCadastar);
    setVisible(true);
    botaoCadastar.addActionListener(e -> {
      String pegaLogin = login.getText();
      String pegaSenha = String.valueOf(senha.getPassword());
      Usuario usuario = new Usuario(pegaLogin, pegaSenha);
      if(acesso.cadastra(usuario)){
        JFrame ok = new JFrame();
        JOptionPane.showMessageDialog(ok, "Usuario cadastrado com sucesso!!!");
        login.setText("");
        senha.setText("");
      }else{
        JFrame fail = new JFrame();
        JOptionPane.showMessageDialog(fail, "Usuario já cadastrado","Alerta", JOptionPane.WARNING_MESSAGE);
      }

  });

  }
}
