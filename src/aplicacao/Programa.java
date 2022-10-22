package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
	
		
		System.out.print("Numero do quarto: ");
		int numQuarto = sc.nextInt();
		
		System.out.print("Data de entrada (DD/MM/YYYY): ");
		Date entrada = sdf.parse(sc.next());
		
		System.out.print("Data de saida (DD/MM/YYYY): ");
		Date saida = sdf.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro! Em uma reserva, a data de saida deve ser depois da data de entrada!");
		} else {
			
			Reserva reserva = new Reserva(numQuarto, entrada, saida);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			
			System.out.print("Data de entrada (DD/MM/YYYY): ");
			entrada = sdf.parse(sc.next());
			
			System.out.print("Data de saida (DD/MM/YYYY): ");
			saida = sdf.parse(sc.next());
			
			Date agora = new Date();
			System.out.println(agora);
			
			String erro = reserva.atualizarData(entrada, saida);
			
			if (erro != null) {
				System.out.println("Erro: " + erro);
			} else {
				System.out.println("Reserva: " + reserva);
			}
				
		}
		sc.close();
	}

}
