package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}
	
	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime(); // Quantidade de milisegundos
		
		//Agora, vamos converter para dias
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		
	}
	
	public String atualizarData(Date dataEntrada, Date dataSaida) {
		Date agora = new Date();
		if (dataEntrada.before(agora) || dataSaida.before(agora)) {
			System.out.println("Erro na reserva, as datas de reserva na atualizacao devem ser datas futuras.");
		} 
		if (!dataSaida.after(dataEntrada)) {
			System.out.println("Erro! Em uma reserva, a data de saida deve ser depois da data de entrada!");	
		}
			this.dataEntrada = dataEntrada;
			this.dataSaida = dataSaida;
			return null;
		}
	
	@Override
	public String toString() {
		return "Quarto: " + numeroQuarto + ", data de entrada: "
				+ sdf.format(dataEntrada) + ", data de saida: "
				+ sdf.format(dataSaida) + ", " + duracao() + " noites.";
	}
	
}
