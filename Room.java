import java.util.Random;

public class Room {
    private boolean entranceUp;
    private boolean entranceDwn;
    private boolean entranceLeft;
    private boolean entranceRight;
    public Room up = null;
    public Room dwn = null;
    public Room left = null;
    public Room right = null;
    public int xPos;
    public int yPos;


    //Make sure that rooms are unable to generate entrances if on edge of map
    //


    public Room()
    {
        Random r = new Random();
        if (r.nextInt(100)+1 <= 33)
        {
            entranceUp=true;
        }
        if (r.nextInt(100)+1 <= 33)
        {
            entranceDwn=true;
        }
        if (r.nextInt(100)+1 <= 33)
        {
            entranceRight=true;
        }
        if (r.nextInt(100)+1 <= 33)
        {
            entranceLeft=true;
        }
    }

    public Room(boolean start)
    {
        entranceUp=true;
        entranceDwn=true;
        entranceLeft=true;
        entranceRight=true;
    }

    public boolean hasLeft() {return entranceLeft;}

    public boolean hasRight() {return entranceRight;}

    public boolean hasDown() {return entranceDwn;}

    public boolean hasUp() {return entranceUp;}

    public void setAdjacent(String direction, Room neighbor)
    {
        if (direction.contains("n")){up=neighbor; entranceUp = true;}
        if (direction.contains("w")){left=neighbor; entranceLeft = true;}
        if (direction.contains("s")){dwn=neighbor; entranceDwn = true;}
        if(direction.contains("e")){right=neighbor; entranceRight = true;}
    }

    public void setPosition(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int returnPositionx()
    {
        return xPos;
    }

    public int returnPositiony()
    {
        return yPos;
    }

}
