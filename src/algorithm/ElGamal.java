//package algorithm;
//
//
//import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
//import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.DHParameterSpec;
//import java.io.ByteArrayOutputStream;
//import java.nio.charset.StandardCharsets;
//import java.security.*;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//
//public class ElGamal {
//    //非对称密钥算法
//    public static final String EL_GAMAL = "ElGamal";
//    /**
//     * 密钥长度，DH算法的默认密钥长度是1024
//     * 密钥长度必须是8的倍数，在160到16384位之间
//     */
//    private static final int KEY_SIZE = 256;
//
//
//
//    public static KeyPair GenElGamalKey() throws Exception {
//        //System.out.println("=============接收方构建密钥对=============");
//        // 加入对BouncyCastle支持
//        Security.addProvider(new BouncyCastleProvider());
//        AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance(EL_GAMAL);
//        //初始化参数生成器
//        apg.init(KEY_SIZE);
//        //生成算法参数
//        AlgorithmParameters params = apg.generateParameters();
//        //构建参数材料
//        DHParameterSpec elParams = params.getParameterSpec(DHParameterSpec.class);
//        //实例化密钥生成器
//        KeyPairGenerator kpg = KeyPairGenerator.getInstance(EL_GAMAL);
//        //初始化密钥对生成器
//        kpg.initialize(elParams, new SecureRandom());
//        KeyPair keyPair = kpg.generateKeyPair();
//        //公钥
//        PublicKey publicKey = keyPair.getPublic();
//        //私钥
//        PrivateKey privateKey = keyPair.getPrivate();
//        return keyPair;
//        //System.out.println("公钥：" + java.util.Base64.getEncoder().encodeToString(publicKey.getEncoded()));
//        //System.out.println("私钥：" + java.util.Base64.getEncoder().encodeToString(privateKey.getEncoded()));
//    }
//
//    public static byte[] ElGamalEncrypt(String plaintext,PublicKey publicKey)throws Exception {
//        //System.out.println("原文：" + plaintext);
//        //System.out.println("=============发送方还原接收方公钥，并使用公钥对数据进行加密=============");
//        //还原公钥
//        KeyFactory keyFactory = KeyFactory.getInstance(EL_GAMAL);
//        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
//        publicKey = keyFactory.generatePublic(x509KeySpec);
//        //System.out.println("公钥：" + java.util.Base64.getEncoder().encodeToString(publicKey.getEncoded()));
//        //数据加密
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        //分组加密，并将加密后的内容写入输出字节流
//        byte[][] dataArray = splitArray(plaintext.getBytes(StandardCharsets.UTF_8), KEY_SIZE/128);
//        for (byte[] s : dataArray) {
//            out.write(cipher.doFinal(s));
//        }
//        byte[] bytes = out.toByteArray();
//        //System.out.println("加密后的数据：" + Base64.getEncoder().encodeToString(bytes));
//        return bytes;
//
//
//    }
//    public static String ElGamalDecrypt(byte[] ciphertext,PrivateKey privateKey)throws Exception {
//
//        KeyFactory keyFactory = KeyFactory.getInstance(EL_GAMAL);
//
//        //还原私钥
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
//        keyFactory = KeyFactory.getInstance(EL_GAMAL);
//        privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
//        //数据解密
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);
//        byte[][] splitArrays = splitArray(ciphertext, KEY_SIZE/4);
//        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
//        for(byte[] arr : splitArrays){
//            out1.write(cipher.doFinal(arr));
//        }
//
//        //System.out.println("解密后的数据：" + new String(out1.toByteArray()));
//
//        return new String(out1.toByteArray());
//
//    }
//
//
//
//
//    private static byte[][] splitArray(byte[] data,int len){
//
//        int dataLen = data.length;
//        if (dataLen <= len) {
//            return new byte[][]{data};
//        }
//        byte[][] result = new byte[(dataLen-1)/len + 1][];
//        int resultLen = result.length;
//        for (int i = 0; i < resultLen; i++) {
//            if (i == resultLen - 1) {
//                int slen = dataLen - len * i;
//                byte[] single = new byte[slen];
//                System.arraycopy(data, len * i, single, 0, slen);
//                result[i] = single;
//                break;
//            }
//            byte[] single = new byte[len];
//            System.arraycopy(data, len * i, single, 0, len);
//            result[i] = single;
//        }
//        return result;
//    }
//
//
//
//
//
//
//}
//
//
//
