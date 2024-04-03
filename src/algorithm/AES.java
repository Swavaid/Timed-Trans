//package algorithm;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//public class AES {
//
//
//
//    //AES symmetric algorithm
//    public static String encryptAES(String plaintext,String key) throws Exception{
//        Cipher c=Cipher.getInstance("AES/CTR/PKCS5Padding");
//        SecretKeySpec secretKeySpec=new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),"AES");
//        c.init(Cipher.ENCRYPT_MODE,secretKeySpec);
//        byte[] bytes=c.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
//        String ciphertext= Base64.getEncoder().encodeToString(bytes);
//        return ciphertext;
//
//    }
//    public static String decryptAES(String ciphertext,String key) throws Exception{
//        Cipher c=Cipher.getInstance("AES/CTR/PKCS5Padding");
//        SecretKeySpec secretKeySpec=new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),"AES");
//        c.init(Cipher.DECRYPT_MODE,secretKeySpec);
//        byte[] bytes=c.doFinal(Base64.getDecoder().decode(ciphertext));
//        return new String(bytes);
//    }
//}
