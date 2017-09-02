package team.pepsi.pepsimod.common;

import team.pepsi.pepsimod.common.util.Nonce;

import java.io.Serializable;

public class ServerFirstAuthMessage implements Serializable {
    public final Nonce nonce = new Nonce();
}
