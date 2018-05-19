package homeTask;

public class GoogleAPI implements API{

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int counter = 0, sizeOfNewArray = 0;

        for(Room room : rooms){
            if(room != null) {
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                    sizeOfNewArray++;
                }
            }
        }

        Room[] rooms1 = new Room[sizeOfNewArray];

        for(Room room : rooms){
            if(room != null) {
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                    rooms1[counter++] = room;
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