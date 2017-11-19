package contateste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.NumberFormatException;

public class FrameEspecial extends JFrame {

    private JTextField nome;
    private JTextField numero;
    private JTextField saldo;
    private JTextField limite;
    private JButton ok;
    private JButton cancel;
    private JLabel nomeLabel;
    private JLabel numeroLabel;
    private JLabel saldoLabel;
    private JLabel limiteLabel;

    public FrameEspecial() {
        super("Criando Conta Especial");
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        nomeLabel = new JLabel("Nome");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 0;
        add(nomeLabel, constraint);
        nome = new JTextField(10);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 0;
        constraint.gridwidth = 3;
        add(nome, constraint);

        numeroLabel = new JLabel("Numero");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        add(numeroLabel, constraint);
        numero = new JTextField(10);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.gridwidth = 3;
        add(numero, constraint);

        saldoLabel = new JLabel("Saldo");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 1;
        add(saldoLabel, constraint);
        saldo = new JTextField(10);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 2;
        constraint.gridwidth = 3;
        add(saldo, constraint);
        
        limiteLabel = new JLabel("Limite de Saldo");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 3;
        constraint.gridwidth = 1;
        add(limiteLabel, constraint);
        limite = new JTextField(10);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 3;
        constraint.gridwidth = 3;
        add(limite, constraint);

        cancel = new JButton("Cancel");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 4;
        constraint.gridwidth = 2;
        cancel.setForeground(Color.red);
        add(cancel, constraint);
        CancelHandler cancelHandler = new CancelHandler();
        cancel.addActionListener(cancelHandler);
        
        ok = new JButton("Ok");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 4;
        constraint.gridwidth = 3;
        ok.setForeground(Color.green);
        add(ok, constraint);
        OkHandler okHandler = new OkHandler();
        ok.addActionListener(okHandler);
        
    }

    private class OkHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Banco banco = Banco.getInstance();
            try {
                banco.criaContaEspecial(nome.getText(), Integer.parseInt(numero.getText()), Float.parseFloat(saldo.getText()), Float.parseFloat(limite.getText()));
                dispose();
            } catch (NumberFormatException number) {
                JOptionPane.showMessageDialog(null, "Insira uma entrada valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private class CancelHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }
}
