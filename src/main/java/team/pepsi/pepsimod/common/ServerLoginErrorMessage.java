package team.pepsi.pepsimod.common;

import java.io.Serializable;

public class ServerLoginErrorMessage implements Serializable {
    public final int code;

    public ServerLoginErrorMessage(int code) {
        this.code = code;
    }
}
