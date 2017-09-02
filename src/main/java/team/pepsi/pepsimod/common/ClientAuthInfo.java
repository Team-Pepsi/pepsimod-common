package team.pepsi.pepsimod.common;

import java.io.Serializable;

public class ClientAuthInfo implements Serializable {
    public final String username;
    public final String password;
    public final String authKey;

    public ClientAuthInfo(String username, String password, String authKey)    {
        this.username = username;
        this.password = password;
        this.authKey = authKey;
    }
}
