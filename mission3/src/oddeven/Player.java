package oddeven;

public class Player {
    private String name;
    private int money;
    private int betting;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.betting = 0;
    }

    public int getBetting() {
        return betting;
    }

    public void setBetting(int betting) {
        this.betting = betting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void winMoney(Player rival, int betting){
        this.money += betting;
        rival.loseMoney(betting);
    }
    public void loseMoney(int betting) {
        this.money -= betting;
    }
}
