package contateste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameCriar extends JFrame {
    private JButton simplesJButton;
    private JButton especialJButton;
    private JButton poupancaJButton;
    private JButton cancel;

    public FrameCriar() {
        super("Contas.exe");
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();

        SimplesHandler simplesHandler = new SimplesHandler();
        EspecialHandler especialHandler = new EspecialHandler();
        PoupancaHandler poupancaHandler = new PoupancaHandler();
        CancelHandler cancelHandler = new CancelHandler();

        simplesJButton = new JButton("ContaSimples");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 0;
        add(simplesJButton, constraint);
        simplesJButton.addActionListener(simplesHandler);

        especialJButton = new JButton("ContaEspecial");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 0;
        add(especialJButton, constraint);
        especialJButton.addActionListener(especialHandler);

        poupancaJButton = new JButton("ContaPoupança");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 2;
        constraint.gridy = 0;
        add(poupancaJButton, constraint);
        poupancaJButton.addActionListener(poupancaHandler);

        cancel = new JButton("Cancel");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 1;
        //cancel.setBackground(Color.red);
        cancel.setForeground(Color.red);
        add(cancel, constraint);
        cancel.addActionListener(cancelHandler);

    }

    private class SimplesHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            FrameSimples contaSimples = new FrameSimples();
            contaSimples.setSize(500, 250);
            contaSimples.setLocationRelativeTo(null);
            contaSimples.setVisible(true);
            dispose();
        }
    }

    private class EspecialHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            FrameEspecial contaEspecial = new FrameEspecial();
            contaEspecial.setSize(500, 250);
            contaEspecial.setLocationRelativeTo(null);
            contaEspecial.setVisible(true);
            dispose();
        }
    }

    private class PoupancaHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            FramePoupanca contaPoupanca = new FramePoupanca();
            contaPoupanca.setSize(500, 250);
            contaPoupanca.setLocationRelativeTo(null);
            contaPoupanca.setVisible(true);
            setVisible(false);
        }
    }
    
    private class CancelHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }

}
