package contateste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.NumberFormatException;

public class FrameConsulta extends JFrame {
    private JTextField numero;
    private JButton ok;
    private JButton cancel;
    private JLabel numeroLabel;
    private float saldo;

    public FrameConsulta() {
        super("Consultar Saldo");
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        numeroLabel = new JLabel("Numero Da Conta");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 0;
        add(numeroLabel, constraint);
        numero = new JTextField(10);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 0;
        constraint.gridwidth = 3;
        add(numero, constraint);

        ok = new JButton("Ok");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.gridwidth = 3;
        ok.setForeground(Color.GREEN);
        add(ok, constraint);
        OkHandler okHandler = new OkHandler();
        ok.addActionListener(okHandler);

        cancel = new JButton("Cancel");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        cancel.setForeground(Color.red);
        add(cancel, constraint);
        CancelHandler cancelHandler = new CancelHandler();
        cancel.addActionListener(cancelHandler);
    }
    
    private class OkHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Banco banco = Banco.getInstance();
            try {
                saldo = banco.consulta(Integer.parseInt(numero.getText()));
                if(saldo == -1)
                {
                    JOptionPane.showMessageDialog(null, "Conta nao existente!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saldo da conta " + numero.getText() + " = " + saldo, "Consulta de saldo", JOptionPane.PLAIN_MESSAGE);
                }
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
