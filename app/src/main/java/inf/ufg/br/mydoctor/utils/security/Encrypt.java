package inf.ufg.br.mydoctor.utils.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by diogojayme on 10/6/16.
 */

public class Encrypt {

    public static final String toMd5(final String s) {
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(s.getBytes(),0,s.length());
            return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}
