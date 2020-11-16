package ledger;

public class LedgerDTO implements Comparable<LedgerDTO> {
    private int id;
    private String date;
    private String type;
    private String summary;
    private int revenue;
    private int expenditure;
    private int balance;

    public LedgerDTO(int id, String date, String type, String summary, int revenue, int expenditure, int balance) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.summary = summary;
        this.revenue = revenue;
        this.expenditure = expenditure;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return id + " " + date + " " + type + " " + summary + " " + revenue + " " + expenditure;
    }

    @Override
    public int compareTo(LedgerDTO ledgerDTO) {
        return this.getRevenue() > ledgerDTO.getRevenue() ? 1 : -1;
    } // how can I sort by other?
}
