package b_desafio_funcionario;

import javax.swing.JOptionPane;

public class Funcionario {
    private static int totalFuncionarios = 0;
    private static int idadeMinima = 18;

    public static void contratar() {
        String nome = JOptionPane.showInputDialog("Nome do funcion�rio:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));

        if (idade >= idadeMinima) {
            totalFuncionarios++;
            JOptionPane.showMessageDialog(null, "Funcion�rio " + nome + " contratado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O funcion�rio " + nome + " n�o pode ser contratado devido � idade.");
        }
    }

    public static int getTotalFuncionarios() {
        return totalFuncionarios;
    }

    public static int getIdadeMinima() {
        return idadeMinima;
    }

    public static void setIdadeMinima(int idadeMinima) {
        Funcionario.idadeMinima = idadeMinima;
    }
}
