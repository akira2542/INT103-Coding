
package poc;

public class Room {
    private final String roomId;

    public Room(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + '}';
    }
    
    
}
