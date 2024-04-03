//package frame;
//
//import algorithm.BLS;
//import algorithm.Hash_SHA256;
//import main.DataUber;
//
//public class Mailmen {
//
//    //发布任务并由Mailmen发出申请
//    public static Mailmen_Selected[] implement() throws Exception {
//        int mi;
//        int count=0;
//        //申请并统计申请人的数量
//        for (mi = 0; mi < DataUber.BlockCount; mi++) {
//            DataUber.mailmen_frees[mi]=new Mailmen_free();
//            DataUber.mailmen_frees[mi].i=mi;
//            DataUber.mailmen_frees[mi].State=Mailmen_free.GenState();
//            DataUber.mailmen_frees[mi].Add_i=new String(String.valueOf(DataUber.mailmen_frees[mi].i));
//            DataUber.mailmen_frees[mi].CipherHash= Sender_Thres.Hc;
//            DataUber.mailmen_frees[mi].SSiHash= Sender_Thres.SSiHash[mi];
//            //状态为想要申请任务(1)，则向Sender发送任务请求，生成Mailmen_apply
//            if(DataUber.mailmen_frees[mi].State==1){
//                //想要申请的mailmen_frees将变成Mailmen-apply（并迁移相关数据）
//                DataUber.mailmen_apply.add(new Mailmen_apply());
//                DataUber.mailmen_apply.get(count).applyNum=count;
//                DataUber.mailmen_apply.get(count).i=DataUber.mailmen_frees[mi].i;
//                DataUber.mailmen_apply.get(count).CipherHash=DataUber.mailmen_frees[mi].CipherHash;
//                DataUber.mailmen_apply.get(count).SSiHash=DataUber.mailmen_frees[mi].SSiHash;
//                DataUber.mailmen_apply.get(count).Add_i=DataUber.mailmen_frees[mi].Add_i;
//                count++;
//                //计算想要申请的Mailmen的数量
//            }
//        }
//        //对Mailmen_apply进行选择（采用随机选择）
//        int CountID=0;
//        if(count!=0){
//            int j;
//            for (j=0;j<count;j++){
//                //被选中，创建Mailmen_selected实例(未选中n人且，序号为1时选择)
//                if(DataUber.mailmen_apply.get(j).IfSelected==1&&CountID<DataUber.n){
//                    DataUber.mailmen_selected[CountID]=new Mailmen_Selected();
//                    DataUber.mailmen_selected[CountID].i=DataUber.mailmen_apply.get(j).i;
//                    DataUber.mailmen_selected[CountID].CipherHash=DataUber.mailmen_apply.get(j).CipherHash;
//                    DataUber.mailmen_selected[CountID].SSiHash=DataUber.mailmen_apply.get(j).SSiHash;
//                    DataUber.mailmen_selected[CountID].Add_i=DataUber.mailmen_apply.get(j).Add_i;
//                    CountID++;
//                }
//            }
//        }
//        return DataUber.mailmen_selected;
//
//    }
//
//
//    //向Sender支付定金
//    public static int[] depositList=new int[DataUber.n];
//
//    //向Mailmen_Selected发送数字签名,生成Mailmen_ID_task发起任务
//
//    //将对应的Add_i和ID发给对应的Mi以确认数字签名的正确性
//    //向Mailmen_task传递任务编号
//
//    public static void verification() throws Exception {
//        boolean SigVer;
//        for (int i=0;i<DataUber.n;i++){
//            //验证数字签名
//            DataUber.mailmen_selected[i].IDStr_Selected= Sender_Cipher.IDStr;
//            String message= (Sender_Cipher.IDStr + DataUber.mailmen_selected[i].Add_i);
//            SigVer= BLS.BLS_Sig(message);
//            //若正确，创建mailmen_id_task实例，并分配ind_i
//            if(SigVer==true){
//                DataUber.mailmen_id_tasks[i]=new Mailmen_ID_task();
//                DataUber.mailmen_id_tasks[i].i=DataUber.mailmen_selected[i].i;
//                DataUber.mailmen_id_tasks[i].SSiHash=DataUber.mailmen_selected[i].SSiHash;
//                DataUber.mailmen_id_tasks[i].CipherHash=DataUber.mailmen_selected[i].CipherHash;
//                DataUber.mailmen_id_tasks[i].Add_i=DataUber.mailmen_selected[i].Add_i;
//                DataUber.mailmen_id_tasks[i].IDStr_task=DataUber.mailmen_selected[i].IDStr_Selected;
//                //支付定金
//                depositList[i]= Sender_Cipher.deposit;
//                if(depositList!=null){
//                    DataUber.mailmen_id_tasks[i].ind_i=Mailmen_ID_task.ind_iList[i];
//                    //注册成功后，Sender向每一个mailmen发送门限密钥共享的SSi  BigInteger[i][1]
//                    DataUber.mailmen_id_tasks[i].SS_ind_i= Sender_Thres.ParaGroup[DataUber.mailmen_id_tasks[i].ind_i][1];
//                    //验证当前块的SSi的Hash值与原块中的Hash值是否相等
//                    if(DataUber.mailmen_id_tasks[i].SSiHash.equals(Hash_SHA256.getSHA256(new String(String.valueOf(Sender_Thres.ParaGroup[DataUber.mailmen_id_tasks[i].i][1]))))==false){
//                        System.out.println("reject the task");
//                    }
//                }
//            }
//            else{
//                System.out.println("verification fails");
//            }
//        }
//
//    }
//}
//
//
