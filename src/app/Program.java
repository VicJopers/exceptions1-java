package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number:  ");
			int room = sc.nextInt();
			System.out.print("Date checkin:  ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Date checkout:  ");
			Date checkout = sdf.parse(sc.next());
				
			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.println("Reservation:  "+reservation);
			
			System.out.println();
			System.out.println("atualize os dados");
			
			System.out.print("Data de checkIn: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de checkout:  ");
			checkout= sdf.parse(sc.next());
			
			reservation.updates(checkin, checkout);
			System.out.println("Reserva: "+reservation);
		}
		catch(ParseException e) {
			System.out.println("Data invalida!");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva!"+e.getMessage());
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
