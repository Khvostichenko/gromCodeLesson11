package homeTask;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel){

        int size = 0, counter = 0;

        for(API api : apis){
            if(api.findRooms(price,persons,city,hotel) != null){
                size += api.findRooms(price,persons,city,hotel).length;
            }
        }

        Room[] rooms = new Room[size];

        for(API api : apis){
            if(api.findRooms(price,persons,city,hotel) != null){
                for(Room r : api.findRooms(price,persons,city,hotel)){
                    rooms[counter++] = r;
                }
            }
        }

        return rooms;
    }

    public Room[] check(API api1, API api2){
        Room[] rooms1 = api1.getAll();
        Room[] rooms2 = api2.getAll();
        int sizeOfNewArray=0, counter=0;

        if(rooms1 != null && rooms2 != null){
            for (int i = 0; i < rooms1.length; i++) {
                for (int j = 0; j < rooms2.length; j++) {
                    if(rooms1[i] != null && rooms2[j] != null) {
                        if (rooms1[i].getPersons() == rooms2[j].getPersons() && rooms1[i].getPrice() == rooms2[j].getPrice()
                                && rooms1[i].getHotelName() == rooms2[j].getHotelName() && rooms1[i].getCityName() == rooms2[j].getCityName()) {
                            if (rooms1[i].getDateAvailableFrom() != null && rooms2[j].getDateAvailableFrom() != null) {
                                if (rooms1[i].getDateAvailableFrom() != rooms2[j].getDateAvailableFrom() && rooms1[i].getId() != rooms2[j].getId()) {
                                    sizeOfNewArray++;
                                }
                            }
                        }
                    }
                }
            }
        }

        Room[] resultArray = new Room[sizeOfNewArray];

        if(rooms1 != null && rooms2 != null){
            for (int i = 0; i < rooms1.length; i++) {
                for (int j = 0; j < rooms2.length; j++) {
                    if(rooms1[i] != null && rooms2[j] != null) {
                        if (rooms1[i].getPersons() == rooms2[j].getPersons() && rooms1[i].getPrice() == rooms2[j].getPrice()
                                && rooms1[i].getHotelName() == rooms2[j].getHotelName() && rooms1[i].getCityName() == rooms2[j].getCityName()) {
                            if (rooms1[i].getDateAvailableFrom() != null && rooms2[j].getDateAvailableFrom() != null) {
                                if (rooms1[i].getDateAvailableFrom() != rooms2[j].getDateAvailableFrom() && rooms1[i].getId() != rooms2[j].getId()) {
                                    resultArray[counter++] = rooms1[i];
                                }
                            }
                        }
                    }
                }
            }
        }

        return resultArray;
    }
}