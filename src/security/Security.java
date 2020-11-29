package security;

/*
SHA-1
MD5
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security
{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "hello world";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(str.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }
        System.out.println(stringBuilder.toString());
    }
}
