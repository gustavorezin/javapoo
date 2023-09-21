package c_desafio_matricula;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	 private String nome;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Double> notas = new ArrayList<>();
    
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public void matricular(Disciplina disciplina) {
		disciplinas.add(disciplina);
    }

    public void informarNotas(Disciplina disciplina, List<Double> notas) {
        int index = disciplinas.indexOf(disciplina);
        if (index != -1) {
            this.notas.set(index, notas);
        }
    }

    public double calcularMedia(Disciplina disciplina) {
        int index = disciplinas.indexOf(disciplina);
        if (index != -1) {
            List<Double> notas = this.notas.get(index);
            double soma = 0;
            for (Double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        }
        return 0;
    }

    // Método para listar as disciplinas do aluno com suas médias
    public void listarDisciplinasEMedias() {
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = disciplinas.get(i);
            double media = calcularMedia(disciplina);
            System.out.println("Disciplina: " + disciplina.getNome());
            System.out.println("Média do Aluno: " + media);
        }
    }
    
}
