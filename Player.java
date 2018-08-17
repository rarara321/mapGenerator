public class Player {
    private int maxHP;
    public int HP;
    private int wealth;
    public String name;


    public Player()
    {
        maxHP = 100;
        HP = maxHP;
        wealth = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
