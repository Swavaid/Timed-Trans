//package frame;
//
//import algorithm.Hash_SHA256;
////import algorithm.threshold;
//import main.DataUber;
//
//import java.math.BigInteger;
//import java.util.Base64;
//
//public class Sender_Thres
//
//{
//
//    //生成BlockCount个i以及对应的f(i)  即 [y] 即SSi
//    public static BigInteger[][] ParaGroup= Sender_Cipher.GenParaGroup(Sender_Cipher.Prime);
//    public static String[] SSiHash;
//
//    static {
//        try {
//            SSiHash = GenSSiHash();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //生成f(i)的Hash值
//    public static String[] GenSSiHash() throws Exception {
//        String[] SSiHash = new String[DataUber.BlockCount];
//        for (int i=0;i<DataUber.BlockCount;i++){
//            SSiHash[i] = Hash_SHA256.getSHA256(new String(String.valueOf(ParaGroup[i][1])));
//        }
//        return SSiHash;
//    }
//
//    //生成秘文的Hash值
//    public static String Hc;
//
//    static {
//        try {
//            Hc = Hash_SHA256.getSHA256(Base64.getEncoder().encodeToString(Sender_Cipher.ciphertext));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
