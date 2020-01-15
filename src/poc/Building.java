
package poc;

import java.util.Arrays;


public class Building {
    private final Room rooms[];

    public Building(Room[] room) {
        this.rooms = new Room[room.length];
        for (int i = 0; i < room.length; i++) {
            if (room[i] != null){
            this.rooms[i] = new Room(room[i].getRoomId());
            }
        }
    }

    public void listRooms() {
        for (Room room : rooms) {
            if(room != null){
                System.out.println(room);
            }
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Building other = (Building) obj;
        return Arrays.deepEquals(this.rooms, other.rooms);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.deepHashCode(this.rooms);
        return hash;
    }

    @Override
    public String toString() {
        return "Building{" + "rooms=" + Arrays.toString(rooms) + '}';
    }

 

}
