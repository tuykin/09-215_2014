package ru.kpfu.disciplines.db.gtf.helpers;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.util.encoders.Hex;

public class HashSumCreator {
    public static byte[] createMD5(String input) {
        byte[] byteInput = input.getBytes();
        MD5Digest digest = new MD5Digest();
        digest.update(byteInput, 0, byteInput.length);
        byte[] md5 = new byte[digest.getDigestSize()];
        digest.doFinal(md5, 0);
        return Hex.encode(md5, 0, md5.length);
    }
}