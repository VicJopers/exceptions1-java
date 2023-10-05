package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:  ");
		int room = sc.nextInt();
		System.out.print("Date checkin:  ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Date checkout:  ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Data invalida vadia!");
		}else {
			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.println("Reservation:  "+reservation);
			
			System.out.println();
			System.out.println("atualize os dados");
			
			System.out.print("Data de checkIn: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de checkout:  ");
			checkout= sdf.parse(sc.next());
			
			String error = reservation.updates(checkin, checkout);
			if(error != null) {
				System.out.println("Ocorreu um erro!"+error);
			}
			else {
				System.out.println("Reserva: "+reservation);
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
