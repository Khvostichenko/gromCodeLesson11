package homeTask;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int counter = 0, sizeOfNewArray = 0;

        for(Room room : rooms){
            if(room != null) {
                if (room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                    if((room.getPrice() <= price+100) || (room.getPrice() >= price-100)) {
                        sizeOfNewArray++;
                    }
                }
            }
        }

        Room[] rooms1 = new Room[sizeOfNewArray];

        for(Room room : rooms){
            if(room != null) {
                if (room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                    if((room.getPrice() <= price+100) || (room.getPrice() >= price-100)) {
                        rooms1[counter++] = room;
                    }
                }
            }
        }

        return rooms1;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}