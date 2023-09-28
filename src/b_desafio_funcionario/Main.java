package b_desafio_funcionario;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String menu = "1- Contratar funcionário\n"
                + "2- Verificar total de funcionários\n"
                + "3- Verificar idade mínima\n"
                + "4- Sair";

        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    Funcionario.contratar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Total de funcionários: " + Funcionario.getTotalFuncionarios());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Idade mínima: " + Funcionario.getIdadeMinima());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 4);
    }
}