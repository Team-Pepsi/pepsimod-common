package team.pepsi.pepsimod.common;

import java.io.Serializable;

public class ClientChangePassword implements Serializable {
    public final String newPassword;

    public ClientChangePassword(String password) {
        newPassword = password;
    }
}
