//package frame;
//
//import algorithm.*;
//import main.DataUber;
//
//import java.math.BigInteger;
//import java.security.KeyPair;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//
//
//
//public class Receiver_Decypt {
//
//
//
//
//
//    public Receiver_Decypt() throws Exception {
//    }
//
//    //非对称私钥解密
//
//    private static PrivateKey privateKeyElGamal=Receiver_GenKey.keyPair.getPrivate();
//
//    private static String DeElGamalGen(byte[] ciphertext) throws Exception {
//        if(ciphertext!=null){
//            String DeElGamal=ElGamal.ElGamalDecrypt(ciphertext,privateKeyElGamal);
//            return  DeElGamal;
//        }
//
//        return null;
//
//    }
//    private static String DeElGamal;
//
//    static {
//        try {
//            DeElGamal = DeElGamalGen(Sender_Cipher.ciphertext);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    //密钥还原
//    private static BigInteger GenSymKey(){
//        //遍历mailmen的数量是否大于等于t
//        int count=0;
//        for (int i=0;i<DataUber.n;i++){
//            if (DataUber.mailmen_id_tasks[i]!=null){
//                count++;
//            }
//
//        }
//        if(count<Sender_Cipher.t){
//            System.out.println("less than threshold!");
//        }
//
//        //满足人数，开始还原
//
//        //初始化结果
//        BigInteger result=BigInteger.valueOf(0);
//
//        //随机质数p
//        BigInteger p=Sender_Cipher.Prime;
//
//        //分享参数列表，y和x
//        BigInteger[] y = new BigInteger[DataUber.n];
//        int[] x=new int[DataUber.n];
//
//        //初始化x和y的值
//
//        for (int k=0;k<DataUber.n;k++){
//            //x
//            x[k]=DataUber.mailmen_id_tasks[k].ind_i+1;
//            //y
//            y[k]=DataUber.mailmen_id_tasks[k].SS_ind_i;
//        }
//
//        int t=Sender_Cipher.t;
//
//        for (int j=0;j<t;j++){
//            final int xi=x[j];
//            final BigInteger yi=y[j];
//
//            BigInteger numerator=BigInteger.ONE;
//            BigInteger denominator=BigInteger.ONE;
//
//            for(int l=0;l<t;l++){
//                if(l==j){
//                    continue;
//                }
//                final int xl=x[l];
//
//                numerator=numerator.multiply(BigInteger.valueOf(xl).negate());
//                denominator=denominator.multiply(BigInteger.valueOf(xi-xl));
//            }
//            result = result.add(yi.multiply(numerator).mod(p).multiply(denominator.modInverse(p)).mod(p)).mod(p);
//        }
//
//        return result;
//    }
//
//
//    private static String ShareSymKey=new String(String.valueOf(GenSymKey()));
//
//
//
//    //对称解密
//    private static String DeplaintextGen(String DeElGamal) throws Exception {
//        if (DeElGamal!=null){
//            String Deplaintext=AES.decryptAES(DeElGamal,ShareSymKey);
//            return Deplaintext;
//        }
//        return null;
//
//    }
//
//    private static  String Deplaintext;
//
//    static {
//        try {
//            Deplaintext = DeplaintextGen(DeElGamal);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void IfSuccess() throws Exception {
//        if(Sender_Cipher.plaintextHash.equals(Hash_SHA256.getSHA256(Receiver_Decypt.Deplaintext))){
//            System.out.println("message has been sent successfully!");
//        }
//    }
//
//}
