package ledger;

public class LedgerDTO {
    private int id;
    private String date;
    private String summary;
    private int revenue;
    private int expenditure;

    public LedgerDTO(int id, String date, String summary, int revenue, int expenditure) {
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
        if(id > 0) {
            this.id = id;
        }else{
            System.out.println("error!!!");
        }

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
        return id + " " + date + " " + summary +" " + revenue + " " + expenditure;
    }
}
