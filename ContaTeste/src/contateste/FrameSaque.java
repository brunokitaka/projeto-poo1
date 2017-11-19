package contateste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.NumberFormatException;

public class FrameSaque extends JFrame {
    private int existe;
    private JTextField numero;
    private JTextField valor;
    private JButton ok;
    private JButton cancel;
    private JLabel numeroLabel;
    private JLabel valorLabel;

    public FrameSaque() {
        super("Saque");
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
        
        valorLabel = new JLabel("Valor");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        add(valorLabel, constraint);
        valor = new JTextField(10);
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.gridwidth = 3;
        add(valor, constraint);

        ok = new JButton("Ok");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 2;
        constraint.gridwidth = 3;
        ok.setForeground(Color.GREEN);
        add(ok, constraint);
        OkHandler okHandler = new OkHandler();
        ok.addActionListener(okHandler);

        cancel = new JButton("Cancel");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 2;
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
                existe = banco.realizaSaque(Integer.parseInt(numero.getText()), Integer.parseInt(valor.getText()));
                if(existe == -1)
                {
                    JOptionPane.showMessageDialog(null, "Conta nao existente!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else if(existe == -2)
                {
                    JOptionPane.showMessageDialog(null, "Valor muito alto!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!", "Saque", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (NumberFormatException number) {
                JOptionPane.showMessageDialog(null, "Insira uma entrada valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        }
    }
    private class CancelHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }
}
