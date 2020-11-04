package IndianNaming.cocoa.codesquad;

public class Indian {
    private int year;
    private int month;
    private int day;
    private String name = "";

    static String[] yearTable = {"시끄러운", "푸른", "적색", "조용한", "웅크린", "백색", "지혜로운", "용감한", "날카로운", "욕심많은"};
    static String[] monthTable = {"늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
    static String[] dayTable = {"와(과) 함께춤을", "의 기상", "은(는) 그림자속에", "", "", "", "의 환생", "의 죽음", "아래에서", "를(을) 보라",
            "이(가) 노래하다.", "의 그림자", "의 일격", "에게 쫓기는 남자", "의 행진", "의 왕", "의 유령", "~을 죽인자.", "는(은) 맨날 잠잔다.", "처럼..",
            "의 고향", "의 전사", "은(는) 나의친구", "의 노래", "의 정령", "의 파수꾼", "의 악마", "와(과)같은 사나이", "를(을) 쓰러트린자", "의 혼", "은(는) 말이없다"};

    public String naming() {
        name += yearTable[this.year % 10] + " ";
        name += monthTable[this.month - 1];
        name += dayTable[this.day - 1];

        return this.name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
