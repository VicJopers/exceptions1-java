package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updates(Date checkin, Date checkout) {
		
		Date now = new Date();
		
		if(checkin.before(now) || checkout.before(now)) {
			return "As datas não são validas!";
		}
		if(!checkout.after(checkin) && checkin.before(checkout)){
			return "Erro na reserva, as datas não batem";
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
		
	}
	
	@Override
	public String toString() {
		return "Room: " + roomNumber +", "+
				"Checkin: "+ sdf.format(checkin)+", "+
				"Checkout: "+ sdf.format(checkout)+ ", " + duration()+" nights ";
	}

}
