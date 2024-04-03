//package frame;
//
//import algorithm.*;
//import main.DataUber;
//
//import java.math.BigInteger;
//import java.util.Base64;
//import java.util.Random;
//
//public class Sender_Cipher {
//
//
//
//    public static int salary=678;
//    public static int tf=12;
//    public static int deposit=20;
//    private static String plaintext="I'm iron man";
//    public static String plaintextHash;
//    public static int t=DataUber.n-5;
//
//    static {
//        try {
//            plaintextHash = Hash_SHA256.getSHA256(plaintext);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    //对素数p的生成(Zp*)
//    public static BigInteger GenPrime(){
//        String str="";
//        BigInteger bigIntegerPrime = null;
//        while (str.length()!=16){
//            bigIntegerPrime=Random_prime.ranPrime();
//            str=new String(String.valueOf(bigIntegerPrime));
//        }
//
//        return bigIntegerPrime;
//    }
//    //生成大素数
//    public static BigInteger Prime=GenPrime();
//
//    //对称密钥k的生成(后续需要改成private)
//    //生成密钥SymKey(密钥分享的参数)
//    private static BigInteger GenPara(BigInteger p){
//        String Parameter=null;
//        String str="";
//        BigInteger bigIntegerPara=p;
//        int result=0;
//        while (str.length()!=16||result!=-1){
//            bigIntegerPara=Random_prime.ranPrime();
//            result=bigIntegerPara.compareTo(p);
//            str=new String(String.valueOf(bigIntegerPara));
//        }
//
//        return bigIntegerPara;
//    }
//
//
//    private static BigInteger BigintKey=GenPara(Prime);
//
//    private static String symKey=new String(String.valueOf(BigintKey));
//
//
//
//
//    //从Zp*中获取t个常数作为系数a_0---a_t-1
//    private static BigInteger[] SecretSharesPara(){
//        BigInteger[] Parameters = new BigInteger[DataUber.BlockCount];
//        Parameters[0]= Sender_Cipher.BigintKey;
//        int result=0;
//        for (int i = 1; i< t; i++){
//            Parameters[i]=GenPara(Sender_Cipher.Prime);
//        }
//
//        return Parameters;
//    }
//
//    public static final BigInteger[] Para_a=SecretSharesPara();
//
//    //方案细则：将密钥分成BlockCount份，至少要有t个人同时持有才能还原
//    //计算f(i)
//    public static BigInteger[][] GenParaGroup(BigInteger p){
//
//        BigInteger[][] ParaGroup=new BigInteger[DataUber.BlockCount][2];
//
//        BigInteger[] x = new BigInteger[DataUber.BlockCount];
//        BigInteger[] y = new BigInteger[DataUber.BlockCount];
//        BigInteger[] a=Para_a;
//        //初始化x
//        for (int i=0;i<DataUber.BlockCount;i++){
//            x[i]=new BigInteger(String.valueOf(i+1));
//        }
//        //计算y
//        for (int i=0;i<DataUber.BlockCount;i++){
//            y[i]=new BigInteger("0");
//            for (int j=0;j<t;j++){
//                y[i]=y[i].add(a[j].multiply(x[i].pow(j)));
//            }
//        }
//        for (int j=0;j<DataUber.BlockCount;j++){
//            y[j]=y[j];
//        }
//
//        for (int k=0;k<DataUber.BlockCount;k++){
//            ParaGroup[k][0]=x[k];
//            ParaGroup[k][1]=y[k];
//        }
//
//
//        return ParaGroup;
//    }
//
//
//
//
//    //对称加密
//    private static String SymmetricCipher;
//
//    static {
//        try {
//            SymmetricCipher = AES.encryptAES(plaintext,symKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //PkR公钥加密
//
//    private static byte[] ciphertextGen(String SymmetricCipher) throws Exception {
//        if (SymmetricCipher!=null&&Receiver_GenKey.publicKeyElGamal!=null){
//            byte[] ciphertext=ElGamal.ElGamalEncrypt(SymmetricCipher,Receiver_GenKey.publicKeyElGamal);
//            return ciphertext;
//        }
//        return null;
//    }
//    public static byte[] ciphertext;
//
//    static {
//        try {
//            ciphertext = ciphertextGen(SymmetricCipher);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//
//    //任务发布成功后，生成4位任务编号
//    public static String GenIDStr(){
//        //任务发布成功，生成任务编号
//        if (DataUber.mailmen_frees.length==DataUber.BlockCount){
//            String IDStr="";
//            Random random=new Random();
//            int IDNum = 0;
//            while (IDStr.length()!=4){
//                IDNum = random.nextInt(10000);
//                IDStr=new String(String.valueOf(IDNum));
//            }
//
//            return IDStr;
//        }
//
//        return "The task is not published";
//    }
//
//    public static String IDStr=GenIDStr();
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
