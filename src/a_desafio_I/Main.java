package a_desafio_I;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        List<Carro> listaCarros = new ArrayList<>();
        String menu = "1- Cadastrar\n2- Listar\n\n3- Sair";
        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    cadastrarCarro(listaCarros);
                    break;
                case 2:
                    listarCarros(listaCarros);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 3);
    }

    private static void cadastrarCarro(List<Carro> listaCarros) {
        Carro carro = new Carro();
        if(carro.cadastrarCarro()) {
        	listaCarros.add(carro);        	
        }
    }

    private static void listarCarros(List<Carro> listaCarros) {
        String menuListar = "1- Por ano de fabricação\n2- Por marca\n3- Por cor";
        int opListar = Integer.parseInt(JOptionPane.showInputDialog(menuListar));
        
        switch (opListar) {
            case 1:
            	buscaPorPeriodo(listaCarros);
                break;
            case 2:
            	buscaPorMarca(listaCarros);
                break;
            case 3:
            	buscaPorCor(listaCarros);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }
    
    private static void buscaPorPeriodo(List<Carro> listaCarros) {
    	int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Ano inicial: "));
    	int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Ano final: "));
    	StringBuilder resultadoBusca = new StringBuilder();
    	int totalEncontrado = 0;
    	for (Carro carro : listaCarros) {
    		if(anoInicial <= carro.getAnoFabricacao() && anoFinal >= carro.getAnoFabricacao()) {
    			resultadoBusca.append(carro.exibir());
    			totalEncontrado++;
    		}
		}
    	resultadoBusca.append(calculaPercentual(listaCarros.size(), totalEncontrado));
    	JOptionPane.showMessageDialog(null, resultadoBusca);
    }
    
    private static void buscaPorMarca(List<Carro> listaCarros) {
    	String marca = JOptionPane.showInputDialog("Marca: ");
    	StringBuilder resultadoBusca = new StringBuilder();
    	int totalEncontrado = 0;
    	for (Carro carro : listaCarros) {
    		if(carro.getMarca().equalsIgnoreCase(marca)) {
    			resultadoBusca.append(carro.exibir());
    			totalEncontrado++;
    		}
    	}
    	resultadoBusca.append(calculaPercentual(listaCarros.size(), totalEncontrado));
    	JOptionPane.showMessageDialog(null, resultadoBusca);
    }
    
    private static void buscaPorCor(List<Carro> listaCarros) {
    	String[] opcoes = Carro.cores();        
        String escolhida = (String) JOptionPane.showInputDialog(null,
                "Escolha a cor do carro:",
                "Escolha a cor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        
        Cor cor = Cor.valueOf(escolhida);
        
    	StringBuilder resultadoBusca = new StringBuilder();
    	int totalEncontrado = 0;
    	for (Carro carro : listaCarros) {
    		if(cor == carro.getCor()) {
    			resultadoBusca.append(carro.exibir());
    			totalEncontrado++;
    		}
    	}
    	resultadoBusca.append(calculaPercentual(listaCarros.size(), totalEncontrado));
    	JOptionPane.showMessageDialog(null, resultadoBusca);
    }
    
    private static String calculaPercentual(int totalLista, int totalEncontrado) {
    	double percentual = (double) totalEncontrado / (double) totalLista * 100;
    	return 	"Percentual com base no total de carros listados: " + percentual + "%";
    }
}
