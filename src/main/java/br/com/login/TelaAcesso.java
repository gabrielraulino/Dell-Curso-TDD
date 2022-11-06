package br.com.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaAcesso extends JFrame {
  JButton ok;
  public TelaAcesso() {
    Label mensagem;
    setTitle("Acesso");
    mensagem = new Label("Bem vindo à Dell");
    mensagem.setBounds(100,100,100,50);
    setSize(400,400);
    setLayout(null);
    this.add(mensagem);
  }

  public void mostra(){
    this.setVisible(true);
  }
}
