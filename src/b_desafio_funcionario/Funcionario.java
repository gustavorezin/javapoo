package b_desafio_funcionario;

import javax.swing.JOptionPane;

public class Funcionario {
    private static int totalFuncionarios = 0;
    private static int idadeMinima = 18;

    public static void contratar() {
        String nome = JOptionPane.showInputDialog("Nome do funcionário:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));

        if (idade >= idadeMinima) {
            totalFuncionarios++;
            JOptionPane.showMessageDialog(null, "Funcionário " + nome + " contratado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O funcionário " + nome + " não pode ser contratado devido à idade.");
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
