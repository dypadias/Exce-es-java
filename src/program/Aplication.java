/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author dypad
 */
public class Aplication {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter with Romm Number:");
        int number = sc.nextInt();
        System.out.println("Enter with check-IN date (dd/MM/yyyy):");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Enter with check-Out date(dd/MM/yyyy):");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Chec-out must be after Check-in date!");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println("");
            System.out.println("Enter update dates");
            System.out.println("Enter with check-IN date (dd/MM/yyyy):");
            checkIn = sdf.parse(sc.next());
            System.out.println("Enter with check-Out date(dd/MM/yyyy):");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || (checkOut.before(now))) {
                System.out.println("Error reservation: Reservations dates for updates must be futures dates ! ");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Chec-out must be after Check-in date!");

            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);

            }

        }

        sc.close();
    }

}
