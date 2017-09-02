package team.pepsi.pepsimod.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;

public class CryptUtils {
    public static Cipher cipher;

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        } catch (Exception e)   {
            e.printStackTrace();
            Runtime.getRuntime().exit(9237432);
        }
    }

    public static byte[] encrypt(String string, String password)    {
        return encrypt(string.getBytes(), password);
    }

    public static byte[] encrypt(byte[] input, String password)  {
        try {
            byte[] keyBytes = password.getBytes();
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
            int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
            cipher.doFinal(cipherText, ctLength);
            return cipherText;
        } catch (Exception e)   {
            e.printStackTrace();
            Runtime.getRuntime().exit(98473);
        }

        return null;
    }

    public static String decryptString(byte[] input, String password)  {
        try {
            byte[] keyBytes = password.getBytes();
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = new byte[cipher.getOutputSize(input.length)];
            int ptLength = cipher.update(input, 0, input.length, plainText, 0);
            cipher.doFinal(plainText, ptLength);
            return new String(plainText);
        } catch (Exception e)   {
            e.printStackTrace();
            Runtime.getRuntime().exit(40932);
        }

        return null;
    }
}
