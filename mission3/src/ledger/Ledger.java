package ledger;

public class Ledger {
    private int id;
    private String date;
    private String summary;
    private int revenue;
    private int expenditure;

    public Ledger(int id, String date, String summary, int revenue, int expenditure) {
        this.id = id;
        this.date = date;
        this.summary = summary;
        this.revenue = revenue;
        this.expenditure = expenditure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public int print(int balance) {
        balance += this.revenue - this.expenditure;
        System.out.println(this.id + "\t|\t" + this.date + "\t|\t" + this.summary + "\t|\t" +
                this.revenue + "\t|\t" + this.expenditure + "\t|\t" + balance);
        return balance;
    }

    public void delete() {
        this.date = "none";
        this.summary = "none";
        this.revenue = 0;
        this.expenditure = 0;
    }

    public void modify(String date, String summary, int revenue, int expenditure) {
        this.date = date;
        this.summary = summary;
        this.revenue = revenue;
        this.expenditure = expenditure;
    }
}
