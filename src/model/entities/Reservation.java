package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long dif = checkOut.getTime() - checkIn.getTime();// SUBTRAIR OS MILLESECONDS<<
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); // CONVERTER OS MILLESECONDS PARA DIAS<<<<<
	}

	public void updateDate(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room" 
				+ roomNumber 
				+ ", checkin :" 
				+ sdf.format(checkIn) 
				+ ", checkout :" 
				+ sdf.format(checkOut) + ", "
				+ duration() 
				+ " nights";
	}
}
