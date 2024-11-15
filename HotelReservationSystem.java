import java.util.Scanner;

class Hotel {
    private String hotelName;
    private int totalRooms;
    private boolean[] rooms;

    // Constructor to initialize the hotel
    public Hotel(String hotelName, int totalRooms) {
        this.hotelName = hotelName;
        this.totalRooms = totalRooms;
        this.rooms = new boolean[totalRooms]; // False means the room is available, True means the room is reserved
    }

    // Display available rooms
    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms in " + hotelName + ":");
        boolean anyAvailable = false;
        for (int i = 0; i < totalRooms; i++) {
            if (!rooms[i]) {
                System.out.println("Room " + (i + 1) + " is available.");
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("Sorry, no rooms available.");
        }
    }

    // Reserve a room
    public boolean reserveRoom(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= totalRooms && !rooms[roomNumber - 1]) {
            rooms[roomNumber - 1] = true;
            System.out.println("Room " + roomNumber + " has been successfully reserved.");
            return true;
        } else {
            System.out.println("Room " + roomNumber + " is already reserved or invalid.");
            return false;
        }
    }

    // Cancel a reservation
    public boolean cancelReservation(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= totalRooms && rooms[roomNumber - 1]) {
            rooms[roomNumber - 1] = false;
            System.out.println("Room " + roomNumber + " reservation has been successfully canceled.");
            return true;
        } else {
            System.out.println("Room " + roomNumber + " is not reserved or invalid.");
            return false;
        }
    }

    // Get total rooms in the hotel
    public int getTotalRooms() {
        return totalRooms;
    }
}

public class HotelReservationSystem {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Grand Plaza", 10);  // A hotel with 10 rooms
        boolean exit = false;

        while (!exit) {
            System.out.println("\n-- Hotel Reservation System --");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Reserve a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter room number to reserve: ");
                    int reserveRoomNumber = scanner.nextInt();
                    hotel.reserveRoom(reserveRoomNumber);
                    break;

                case 3:
                    System.out.print("Enter room number to cancel reservation: ");
                    int cancelRoomNumber = scanner.nextInt();
                    hotel.cancelReservation(cancelRoomNumber);
                    break;

                case 4:
                    System.out.println("Exiting the Hotel Reservation System.");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
