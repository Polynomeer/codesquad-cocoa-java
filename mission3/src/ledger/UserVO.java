package ledger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserVO {
    private String username;
    private String password;
    private List<LedgerVO> ledgerList;

    public UserVO(String username, String password) {
        this.username = username;
        this.password = password;
        this.ledgerList = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username + "," + password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(username, userVO.username) &&
                Objects.equals(password, userVO.password);
    }

    public boolean isEmpty() {
        return this.username.equals("");
    }
}
