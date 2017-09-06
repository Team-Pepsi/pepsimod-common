/*
 * Adapted from the Wizardry License
 *
 * Copyright (c) 2017 Team Pepsi
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

package team.pepsi.pepsimod.common;

import team.pepsi.pepsimod.common.util.CryptUtils;
import team.pepsi.pepsimod.common.util.SerializableUtils;
import team.pepsi.pepsimod.common.util.Zlib;

import java.io.Serializable;
import java.util.HashMap;

public class ServerPepsiModSending implements Serializable  {
    public final byte[] classes;
    public final byte[] assets;

    public ServerPepsiModSending(HashMap<String, byte[]> classes, HashMap<String, byte[]> assets, String hwid)   {
        this.classes = Zlib.deflate(CryptUtils.encrypt(SerializableUtils.toBytes(classes), hwid), 7);
        this.assets = Zlib.deflate(CryptUtils.encrypt(SerializableUtils.toBytes(assets), hwid), 7);
    }
}
