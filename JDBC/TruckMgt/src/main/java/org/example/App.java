package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App
{

    public static void main( String[] args )
    {
        TruckService truckService=new TruckService();
        Scanner scanner =new Scanner(System.in);
        Truck truck=new Truck();

        while (true){
            // Display menu
            System.out.println("\n========= Truck Management System =========");
            System.out.println("1. Add Truck");
            System.out.println("2. Fetch Truck by ID");
            System.out.println("3. Update Truck");
            System.out.println("4. Get All Trucks");
            System.out.println("5. Delete Truck by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            Truck tata=new Truck("TATA","2019",1000,"rajesh");
            Truck volvo=new Truck("VOLVO","2023",1000,"Akash");
            Truck eicher=new Truck("Eicher","2022",1000,"Harshit");

            switch (choice){
                case 1:
                    // Add Truck
                    System.out.println("Adding data......");
                    truckService.addTruck(tata);
                    truckService.addTruck(volvo);
                    truckService.addTruck(eicher);
                    break;

                case 2:
                    // Fetch Truck by ID
                    System.out.println("Fetching data by id : ......"+1);
                     truck = truckService.getTruckById(1);
                    System.out.println("Truck data : "+truck);
                    break;


                case 3:
                    //updating truck data
                    System.out.println("Updated  data......");
                    truck.setDriverName("Ramesh");
                    truckService.updateTruck(truck);
                    System.out.println("Updated truck data : "+truckService.getTruckById(1));
                    break;

                case 4:
                    //get all truck data
                    System.out.println("fetching all data......");
                    List<Truck> allTrucks = truckService.getAllTrucks();
                    System.out.println("All trucks in DB :");
                    for (Truck truck1 : allTrucks)
                    {
                        System.out.println(truck1);
                    }
                    break;


                case 5:
                    //delete truck data
                    System.out.println("Deleting data by id......"+2);
                    truckService.deleteTruck(2);
                    System.out.println("Data deleted by id : "+2);

                    System.out.println("get all data......");
                    allTrucks=truckService.getAllTrucks();
                    System.out.println("All trucks after all operations :");
                    System.out.println(allTrucks);
                    break;


                case 6:
                    // Exit
                    System.out.println("Exiting Truck Management System...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }

    }
}
