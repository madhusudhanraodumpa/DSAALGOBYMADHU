import javax.crypto.Cipher;
import java.security.Key;

public class EncrypDES {

    private static String strDefaultKey = "des20200903@#$%^&";
    private Cipher encryptCipher = null;
    private Cipher decryptCipher = null;

    /**
     * @throws Exception
     */
    public EncrypDES() throws Exception {
        this(strDefaultKey);
    }

    /**
     * @param strKey
     * @throws Exception
     */
    public EncrypDES(String strKey) throws Exception {
        Key key = getKey(strKey.getBytes());
        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    /**
     * @param arrBTmp
     * @return
     * @throws Exception
     */
    private Key getKey(byte[] arrBTmp) throws Exception {
        byte[] arrB = new byte[8];
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }

    /**
     * @param strIn
     * @return
     * @throws Exception
     */
    public String encrypt(String strIn) throws Exception {
        byte[] encryptByte = encryptCipher.doFinal(strIn.getBytes());
        int iLen = encryptByte.length;
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = encryptByte[i];
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * @param strIn
     * @return
     * @throws Exception
     */
    public String decrypt(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        byte[] decryptByte = decryptCipher.doFinal(arrOut);
        return new String(decryptByte);
    }

    public static void main(String[] args) {
        try {
            String msg1 = "DLP_Classification_Rules";
            String key = "20200903#@!";
            EncrypDES des1 = new EncrypDES(key);
            System.out.println("input value:" + msg1);
            System.out.println("After encryption Value：" + des1.encrypt(msg1));
            System.out.println("After decryption Value：" + des1.decrypt(des1.encrypt(msg1)));
            System.out.println("--------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
