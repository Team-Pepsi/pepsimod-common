package team.pepsi.pepsimod.common.util;

import java.io.Serializable;

public class Nonce implements Serializable {
    public byte[] randomData = String.valueOf(System.currentTimeMillis()).getBytes();
}
