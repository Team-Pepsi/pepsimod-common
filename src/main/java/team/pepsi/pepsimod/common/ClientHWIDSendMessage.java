package team.pepsi.pepsimod.common;

import team.pepsi.pepsimod.common.util.CryptUtils;

import java.io.Serializable;

public class ClientHWIDSendMessage implements Serializable {
    public final String hwid;

    public ClientHWIDSendMessage(String hwid)   {
        this.hwid = hwid;
    }
}
