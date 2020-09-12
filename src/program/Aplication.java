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
import model.exceptions.DomainExceptions;

/**
 *
 * @author dypad
 */
public class Aplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Enter with Romm Number:");
            int number = sc.nextInt();
            System.out.println("Enter with check-IN date (dd/MM/yyyy):");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Enter with check-Out date(dd/MM/yyyy):");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println("");

            System.out.println("Enter update dates");
            System.out.println("Enter with check-IN date (dd/MM/yyyy):");
            checkIn = sdf.parse(sc.next());
            System.out.println("Enter with check-Out date(dd/MM/yyyy):");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println(reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date format!");

        } catch (DomainExceptions e) {
            System.out.println("Error in reservation: " + e.getMessage());

        }
        sc.close();
    }

}
