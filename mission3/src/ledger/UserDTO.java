package ledger;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private List<LedgerDTO> ledgerList;

    public UserDTO(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    boolean isEmpty() {
        if (this.username == "") return true;
        return false;
    }
}
