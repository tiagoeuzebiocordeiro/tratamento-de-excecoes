package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.DomainException;

public class Programa {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Numero do quarto: ");
			int numQuarto = sc.nextInt();
			
			System.out.print("Data de entrada (DD/MM/YYYY): ");
			Date entrada = sdf.parse(sc.next());
			
			System.out.print("Data de saida (DD/MM/YYYY): ");
			Date saida = sdf.parse(sc.next());
				
			Reserva reserva = new Reserva(numQuarto, entrada, saida);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			
			System.out.print("Data de entrada (DD/MM/YYYY): ");
			entrada = sdf.parse(sc.next());
			
			System.out.print("Data de saida (DD/MM/YYYY): ");
			saida = sdf.parse(sc.next());
				
			reserva.atualizarData(entrada, saida);
			
			System.out.println(reserva);
		} catch (ParseException e) {
			System.out.println("Formato de data invalido.");
		} catch (DomainException i) {
			System.out.println("Erro na reserva: " + i.getMessage());
		} catch (RuntimeException r) {
			System.out.println("Erro inesperado...");
		}
		sc.close();
	}

}
