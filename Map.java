import java.util.Random;
import java.util.ArrayList;

public class Map {
    private int sizeX;
    private int sizeY;
    Room[][] map;
    private Room currentRoom;
    private int xIndex;
    private int yIndex;
    ArrayList<Room> queue = new ArrayList<>();

    public Map()
    {
        //Generate size of map
        Random r = new Random();
        //sizeX = r.nextInt(20)+10;
        //sizeY = r.nextInt(20)+10;
        sizeX=20;
        sizeY=20;
        //Generate matrix cooresponding to map
        map = new Room[sizeX][sizeY];
        //Set middle of map to have a room
        map[sizeX/2][sizeY/2] = new Room(true);
        setCurrentRoom(sizeX/2,sizeY/2);
        currentRoom.setPosition(xIndex, yIndex);
        mapLeft(currentRoom);

        System.out.println("Finished map!");
        for (int i=0; i<sizeX; i++)
        {
            for (int j=0; j<sizeY; j++)
            {
                if (map[i][j] == null)
                {
                    System.out.print("[ ]");
                }
                else
                {
                    System.out.print("[x]");
                }
            }
            System.out.println();
        }
    }

    private void mapUp(Room sourceRoom)
    {
        if(xIndex > 0 && sourceRoom.hasUp())
        {
            try
            {
                sourceRoom.setAdjacent("n", map[xIndex-1][yIndex]);
                map[xIndex-1][yIndex].setAdjacent("s", sourceRoom);
            }
            catch (NullPointerException e)
            {
                map[xIndex-1][yIndex]=new Room();
                setCurrentRoom(xIndex-1, yIndex);
                currentRoom.setPosition(xIndex, yIndex);
                sourceRoom.setAdjacent("n", currentRoom);
                currentRoom.setAdjacent("s", currentRoom);
                queue.add(currentRoom);
            }
        }
        mapRight(sourceRoom);
    }

    private void mapLeft(Room sourceRoom)
    {
        if(yIndex > 0 && sourceRoom.hasLeft())
        {
            try
            {
                sourceRoom.setAdjacent("w", map[xIndex][yIndex-1]);
                map[xIndex][yIndex-1].setAdjacent("e", sourceRoom);
            }
            catch (NullPointerException e)
            {
                map[xIndex][yIndex-1]=new Room();
                setCurrentRoom(xIndex, yIndex-1);
                currentRoom.setPosition(xIndex, yIndex);
                sourceRoom.setAdjacent("w", currentRoom);
                currentRoom.setAdjacent("e", currentRoom);
                queue.add(currentRoom);
            }
        }
        mapUp(sourceRoom);
        for (int i=0; i<queue.size();i++)
        {
            if (queue.get(i)!=null)
            {
                setCurrentRoom(queue.get(i).returnPositionx(),queue.get(i).returnPositiony());
                queue.remove(i);
                mapLeft(currentRoom);
            }
        }
    }

    private void mapRight(Room sourceRoom)
    {
        if(yIndex < sizeY-1 && sourceRoom.hasRight())
        {
            try
            {
                sourceRoom.setAdjacent("e", map[xIndex][yIndex+1]);
                map[xIndex][yIndex+1].setAdjacent("w", sourceRoom);
            }
            catch (NullPointerException e)
            {
                map[xIndex][yIndex+1]=new Room();
                setCurrentRoom(xIndex, yIndex+1);
                currentRoom.setPosition(xIndex, yIndex);
                sourceRoom.setAdjacent("e", currentRoom);
                currentRoom.setAdjacent("w", currentRoom);
                queue.add(currentRoom);
            }
        }
        mapDown(sourceRoom);
    }

    private void mapDown(Room sourceRoom)
    {
        if(xIndex < sizeX-1 && sourceRoom.hasDown())
        {
            try
            {
                sourceRoom.setAdjacent("s", map[xIndex+1][yIndex]);
                map[xIndex+1][yIndex].setAdjacent("n", sourceRoom);
            }
            catch (NullPointerException e)
            {
                map[xIndex+1][yIndex]=new Room();
                setCurrentRoom(xIndex+1, yIndex);
                currentRoom.setPosition(xIndex, yIndex);
                sourceRoom.setAdjacent("s", currentRoom);
                currentRoom.setAdjacent("n", currentRoom);
                queue.add(currentRoom);
            }
        }
    }

    private void setCurrentRoom(int xIndex, int yIndex)
    {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        currentRoom=map[xIndex][yIndex];
    }
}
