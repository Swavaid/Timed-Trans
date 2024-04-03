//package frame;
//
//import main.DataUber;
//
//import java.util.Random;
//
//public class Mailmen_free {
//
//    public Mailmen_free() throws Exception {
//    }
//
//    //个人编号i（要求生成BlockCount个不重复的随机数）(0~BlockCount-1)
//    public static int[] GenNum(int num){
//        Random random = new Random();
//        int randInt ;
//        StringBuffer buffer = new StringBuffer();
//        int[] repat = new int[num];
//        for (int i = 0; i < num;) {
//            randInt = random.nextInt(num);
//            //randInt++;
//            if (!buffer.toString().contains("#" + randInt + ",")) {
//                repat[i] = randInt;
//                i++;
//            }
//            buffer.append("#" + randInt + ",");
//        }
//        return repat;
//
//    }
//
//    public static int[] iList=GenNum(DataUber.BlockCount);
//    public  int i;
//
//    public String Add_i;
//
//    //门限密钥的hash值以及秘文的hash值
//
//    public String CipherHash= Sender_Thres.Hc;
//    public String SSiHash= Sender_Thres.GenSSiHash()[i];
//
//
//
//
//    //随机生成0，1，其中1表示愿意接受此项任务，0表示不愿意接受
//
//    public static int GenState(){
//        Random random=new Random();
//
//        int value=random.nextInt(2);
//        return value;
//    }
//
//    public  int State=GenState();
//
//
//
//    //payment
//    public static int payment= Sender_Cipher.salary;
//
//
//
//    //tf(任务必须送达的时间限制)
//
//
//
//
//}
