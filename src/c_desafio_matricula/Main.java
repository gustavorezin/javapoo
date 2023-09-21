package c_desafio_matricula;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import c_desafio_matricula.Professor.Formacao;

public class Main {
	public static void main(String[] args) {
		List<Professor> professores = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();

        while (true) {
            String op = JOptionPane.showInputDialog(
                "Escolha uma opção:\n\n" +
                "1 - Cadastrar Professor\n" +
                "2 - Cadastrar Disciplina\n" +
                "3 - Cadastrar Aluno\n" +
                "4 - Matricular Aluno em Disciplina\n" +
                "5 - Informar Notas de Aluno\n" +
                "6 - Listar Disciplinas e Médias de Aluno\n" +
                "7 - Listar Disciplinas Lecionadas por Professores com Pós-Graduação\n" +
                "8 - Sair"
            );
            if (op == null || op.equals("8")) {
                break;
            }
            
            switch (op) {
			case "1":
				 String nomeProfessor = JOptionPane.showInputDialog("Nome do Professor:");
                 String formacaoStr = JOptionPane.showInputDialog("Formação do Professor (1 - Graduação, 2 - Especialização, 3 - Pós-Graduação):");
                 Formacao formacao = Formacao.values()[Integer.parseInt(formacaoStr) - 1];
                 Professor professor = new Professor(nomeProfessor, formacao);
                 professores.add(professor);
				break;
			
			 case "2":
                 String nomeDisciplina = JOptionPane.showInputDialog("Nome da Disciplina:");
                 String cargaHorariaStr = JOptionPane.showInputDialog("Carga Horária da Disciplina:");
                 String professorIndexStr = JOptionPane.showInputDialog("Índice do Professor que leciona esta Disciplina:");
                 int cargaHoraria = Integer.parseInt(cargaHorariaStr);
                 int professorIndex = Integer.parseInt(professorIndexStr);
                 Disciplina disciplina = new Disciplina(nomeDisciplina, cargaHoraria, professores.get(professorIndex));
                 disciplinas.add(disciplina);
                 break;
                 
			 case "3":
                 String nomeAluno = JOptionPane.showInputDialog("Nome do Aluno:");
                 Aluno aluno = new Aluno(nomeAluno);
                 alunos.add(aluno);
                 break;
				
			 case "4":
                 String alunoIndexStr = JOptionPane.showInputDialog("Índice do Aluno:");
                 String disciplinaIndexStr = JOptionPane.showInputDialog("Índice da Disciplina:");
                 int alunoIndex = Integer.parseInt(alunoIndexStr);
                 int disciplinaIndex = Integer.parseInt(disciplinaIndexStr);
                 alunos.get(alunoIndex).matricular(disciplinas.get(disciplinaIndex));
                 break;
                 
			default:
				break;
			}
            
        }
	}
}
