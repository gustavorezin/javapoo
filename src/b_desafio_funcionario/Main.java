package b_desafio_funcionario;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String menu = "1- Contratar funcion�rio\n"
                + "2- Verificar total de funcion�rios\n"
                + "3- Verificar idade m�nima\n"
                + "4- Sair";

        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    Funcionario.contratar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Total de funcion�rios: " + Funcionario.getTotalFuncionarios());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Idade m�nima: " + Funcionario.getIdadeMinima());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        } while (op != 4);
    }
}