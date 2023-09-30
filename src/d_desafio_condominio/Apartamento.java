package d_desafio_condominio;

public class Apartamento {
	private int numero;
	private String bloco;
	private double tamanhoMetrosQuadrados;
	private String nomeProprietario;
	private static final double VALOR_METRO_QUADRADO = 5.00;
	
	public double calculaValorApartamento() {
		return tamanhoMetrosQuadrados * VALOR_METRO_QUADRADO;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public double getTamanhoMetrosQuadrados() {
		return tamanhoMetrosQuadrados;
	}

	public void setTamanhoMetrosQuadrados(double tamanhoMetrosQuadrados) {
		this.tamanhoMetrosQuadrados = tamanhoMetrosQuadrados;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario.toUpperCase();
	}
}
