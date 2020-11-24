package oddeven;

public class Player {
    private String name;
    private int money;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public String getPlayer() {
        return  this.name + "'s money is " + this.money;
    }

    public void winMoney(Player rival, int betting){
        this.money += betting;
        rival.loseMoney(betting);
    }
    public void loseMoney(int betting) {
        this.money -= betting;
    }
}
