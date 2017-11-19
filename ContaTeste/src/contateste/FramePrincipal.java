package contateste;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FramePrincipal extends JFrame{
    private JButton criaContaJButton;
    private JButton consultaJButton;
    private JButton saqueJButton;
    private JButton depositoJButton;
    private JButton rendimentoJButton;
    private JButton sair;
    
    public FramePrincipal()
    {
        super("Contas.exe");
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        
        CriaHandler criaHandler = new CriaHandler();
        ConsultaHandler consultaHandler = new ConsultaHandler();
        SaqueHandler saqueHandler = new SaqueHandler();
        DepositoHandler depositoHandler = new DepositoHandler();
        RendimentoHandler rendimentoHandler = new RendimentoHandler();
        SairHandler sairHandler = new SairHandler();
        
        criaContaJButton = new JButton("Criar Conta");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 0;
        //constraint.anchor = GridBagConstraints.PAGE_END;
        add(criaContaJButton, constraint);
        criaContaJButton.addActionListener(criaHandler);
        
        consultaJButton = new JButton("Consultar Saldo");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 0;
        add(consultaJButton, constraint);
        consultaJButton.addActionListener(consultaHandler);
        
        saqueJButton = new JButton("Saque");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 2;
        constraint.gridy = 0;
        add(saqueJButton, constraint);
        saqueJButton.addActionListener(saqueHandler);
        
        depositoJButton = new JButton("Deposito");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 0;
        constraint.gridy = 1;
        add(depositoJButton, constraint);
        depositoJButton.addActionListener(depositoHandler);
        
        rendimentoJButton = new JButton("Rendimento");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 1;
        constraint.gridy = 1;
        add(rendimentoJButton, constraint);
        rendimentoJButton.addActionListener(rendimentoHandler);
        
        sair = new JButton("Sair");
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridx = 2;
        constraint.gridy = 1;
        sair.setForeground(Color.red);
        add(sair, constraint);
        sair.addActionListener(sairHandler);
    }
    
    private class CriaHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            FrameCriar criar = new FrameCriar();
            criar.setSize(500, 250);
            criar.setLocationRelativeTo(null);
            //telaCria.setBackground(Color.BLUE);
            criar.setVisible(true);
        }
    }
    private class ConsultaHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            FrameConsulta consultar = new FrameConsulta();
            consultar.setSize(500, 250);
            consultar.setLocationRelativeTo(null);
            consultar.setVisible(true);
        }
    }
    private class SaqueHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            FrameSaque saque = new FrameSaque();
            saque.setSize(500, 250);
            saque.setLocationRelativeTo(null);
            saque.setVisible(true);
        }
    }
    private class DepositoHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            FrameDeposito deposito = new FrameDeposito();
            deposito.setSize(500, 250);
            deposito.setLocationRelativeTo(null);
            deposito.setVisible(true);
        }
    }
    private class RendimentoHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Banco banco = Banco.getInstance();
            banco.rendimento();
        }
    }
    private class SairHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Banco banco = Banco.getInstance();
            banco.gravar();
            dispose();
        }
    }
   
}
