package team.pepsi.pepsimod.common;

import team.pepsi.pepsimod.common.util.CryptUtils;
import team.pepsi.pepsimod.common.util.SerializableUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ServerPepsiModSending implements Serializable  {
    public final byte[] classes;
    public final byte[] assets;

    public ServerPepsiModSending(HashMap<String, byte[]> classes, HashMap<String, byte[]> assets, String hwid)   {
        this.classes = CryptUtils.encrypt(SerializableUtils.toBytes(classes), hwid);
        this.assets = CryptUtils.encrypt(SerializableUtils.toBytes(assets), hwid);
    }
}
