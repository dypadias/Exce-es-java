/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dypad
 */
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

    public void setRoomNumber(Integer rooNumber) {
        this.roomNumber = rooNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }
    
    public void updateDates(Date checkIn, Date checkOut){
        
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        
    }

    @Override
    public String toString() {
        return "Reservation:"
                + "Room :" + roomNumber 
                + ", CheckIn :" + sdf.format(checkIn)
                +", Check-out : "+ sdf.format(checkOut)
                + ",Duration: "+duration()
                + " nights.";
    }
    

}
