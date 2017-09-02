package team.pepsi.pepsimod.common.util;

import java.io.*;

public class SerializableUtils {
    public static byte[] toBytes(Serializable serializable) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream outputStream = null;
        byte[] toReturn = null;
        try {
            bos = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(bos);
            outputStream.writeObject(serializable);
            outputStream.flush();
            toReturn = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)    {
                    bos.close();
                }
                if (outputStream != null)   {
                    outputStream.close();
                }
            } catch (IOException e) {
                //wtf java
            }
        }

        return toReturn;
    }

    public static Object fromBytes(byte[] bytes)  {
        ByteArrayInputStream bis = null;
        ObjectInputStream in = null;
        Object toReturn = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            in = new ObjectInputStream(bis);
            toReturn = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)    {
                    bis.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                //wtf java
            }
        }

        return toReturn;
    }
}
