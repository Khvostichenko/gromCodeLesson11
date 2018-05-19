package homeTask;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int counter = 0, sizeOfNewArray = 0;

        for(Room room : rooms){
            if(room != null) {
                if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                    if((room.getPersons() <= persons+1) || (room.getPersons() >= persons-1)) {
                        sizeOfNewArray++;
                    }
                }
            }
        }

        Room[] rooms1 = new Room[sizeOfNewArray];

        for(Room room : rooms){
            if(room != null) {
                if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                    if((room.getPersons() <= persons+1) || (room.getPersons() >= persons-1)) {
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