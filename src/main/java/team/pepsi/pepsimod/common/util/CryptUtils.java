/*
 * Adapted from the Wizardry License
 *
 * Copyright (c) 2016 Team Pepsi
 *
 * Permission is hereby granted to any persons and/or organizations using this software to copy, modify, merge, publish, and distribute it.
 * Said persons and/or organizations are not allowed to use the software or any derivatives of the work for commercial use or any other means to generate income, nor are they allowed to claim this software as their own.
 *
 * The persons and/or organizations are also disallowed from sub-licensing and/or trademarking this software without explicit permission from Team Pepsi.
 *
 * Any persons and/or organizations using this software must disclose their source code and have it publicly available, include this license, provide sufficient credit to the original authors of the project (IE: Team Pepsi), as well as provide a link to the original project.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package team.pepsi.pepsimod.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
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

    public static byte[] decrypt(byte[] input, String password) {
        try {
            byte[] keyBytes = password.getBytes();
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = new byte[cipher.getOutputSize(input.length)];
            int ptLength = cipher.update(input, 0, input.length, plainText, 0);
            cipher.doFinal(plainText, ptLength);
            return plainText;
        } catch (Exception e)   {
            e.printStackTrace();
            Runtime.getRuntime().exit(40932);
        }

        return null;
    }
}
