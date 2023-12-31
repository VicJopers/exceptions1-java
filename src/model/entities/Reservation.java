package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if(!checkout.after(checkin)){
			throw new DomainException("Erro na reserva, a data de checkout não pode ser anterior a data de checkin!");
		}
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
	
	public void updates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException( "As datas de reserva devem ser futuras!");
		}
		if(!checkout.after(checkin)){
			throw new DomainException("Erro na reserva, a data de checkout não pode ser anterior a data de checkin!");
		}	
		this.checkin = checkin;
		this.checkout = checkout;
	
	}
	
	@Override
	public String toString() {
		return "Room: " + roomNumber +", "+
				"Checkin: "+ sdf.format(checkin)+", "+
				"Checkout: "+ sdf.format(checkout)+ ", " + duration()+" nights ";
	}

}
