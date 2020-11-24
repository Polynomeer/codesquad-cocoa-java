package ledger;

import java.util.Date;

public class LedgerDTO implements Comparable<LedgerDTO> {
    private int id;
    private Date date;
    private String type;
    private String summary;
    private int revenue;
    private int expenditure;
    private int balance;

    public LedgerDTO(int id, Date date, String type, String summary, int revenue, int expenditure, int balance) {
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

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getSummary() {
        return summary;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getExpenditure() {
        return expenditure;
    }

    @Override
    public String toString() {
        return id + " " + date + " " + type + " " + summary + " " + revenue + " " + expenditure;
    }

    @Override
    public int compareTo(LedgerDTO ledgerDTO) {
        return this.date.compareTo(ledgerDTO.date);
    }
}
