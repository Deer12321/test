import java.util.Scanner;

public class Test {
    public static void showMain(){
        System.out.println("欢迎使用“吃货联盟订餐系统”");
        System.out.println("***************************");
        System.out.println("1，我要订餐");
        System.out.println("2.查看餐袋");
        System.out.println("3，签收订单");
        System.out.println("4，删除订单");
        System.out.println("5，我要点赞");
        System.out.println("6，退出系统");
        System.out.println("****************************");
        System.out.println("请选择：");

    }
    //菜
    public static final double hongshao = 38.0;
    public static final double yuxaing = 20.0;
    public static final double shiling = 10.0;
    public static void showCai(){
        System.out.println("序号\t菜名\t单价");
        System.out.println("1\t红烧带鱼\t38.0元");
        System.out.println("2\t鱼香肉丝\t20.0\t");
        System.out.println("3\t时令蔬菜\t10.0元");
    }
    public static void dianCan(){
        System.out.println("***我要订餐***");
        System.out.println("请输入订餐人姓名：");
        String name = input.next();
        showCai();
        System.out.println("请选择您要点的菜品编号：");
        int caipinbianhao = input.nextInt();
        System.out.println("请输入您要点的份数：");
        int fenshu = input.nextInt();
        System.out.println("请输入送餐时间：送餐时间是10点至20点间送餐");
        String time = input.next();
        System.out.println("请输入送餐地址：");
        String adress = input.next();
        System.out.println("订餐成功！");
        Person person2 = new Person(name,caipinbianhao,fenshu,time,adress);
        person[index] = person2;
        System.out.println("您点的是"+person[index].cainame()+"\t"+person[index].fenshu+"份");
        System.out.println("送餐时间："+person[index].time+"点");
        System.out.println("餐费："+person[index].caifei()+"元，送餐费0.0元，总计："+person[index].caifei()+"元。");
        person[index].setDingdanzhuangtai("已预定");
        person[index].setBianhao(index);
        index++;
        System.out.println("输入0返回，输入6退出");
        int a = input.nextInt();
        if(a==0){
            showMain();
        }else{
            System.out.println("谢谢使用，再见!");
            System.exit(0);
        }
    }
    public static void chaKan(){
        System.out.println("***查看餐袋***");
        System.out.println("序号\t订餐人\t餐品信息\t送餐日期\t送餐地址\t总金额\t订单状态");
        for(int i=0;i<index;i++){
            System.out.println((person[i].bianhao+1)+"\t"+person[i].name+"\t"+person[i].cainame()+person[i].fenshu+"份\t"+person[i].time+"\t"+person[i].adress+"\t"+person[i].caifei()+"\t"+person[i].getDingdanzhuangtai());
        }
        System.out.println("输入0返回");
        int a = input.nextInt();
        if(a==0){
            showMain();
        }else{
            System.out.println("谢谢使用");
            System.exit(0);
        }
    }
    public static void qianShou(){
        System.out.println("***签收订单***");
        System.out.println("请输入要签收的订单序号:");
        int dingdanxuhao = input.nextInt()-1;
        if(index<=dingdanxuhao){
            System.out.println("没有该订单");
            showMain();
        }else{
            if(person[dingdanxuhao].getDingdanzhuangtai().equals("已完成")){
                System.out.println("您选择的订单已完成，请勿再次签收");
                showMain();
            }else{
                person[dingdanxuhao].setDingdanzhuangtai("已完成");
                System.out.println("您选择的订单已完成签收，不能再次签收！");
                System.out.println("输入0返回或输入6退出");
                int a = input.nextInt();

                if(a==0){
                    showMain();
                }else{
                    System.out.println("谢谢使用！！！");
                    System.exit(0);
                }
            }
        }
    }
    public static void shanChu(){
        System.out.println("***删除订单***");
        System.out.println("请输入要删除的订单序号：");
        int a = input.nextInt()-1;
        if(index<=a){
            System.out.println("没有该订单");
            showMain();
        }else{
            for(int i = a; i<index; i++){
                person[i] = person[i+1];
            }
            index--;
            for(int i=0; i<index; i++){
                person[i].setBianhao(i);
            }
           // person[index] = null;
            System.out.println("删除订单成功");
            System.out.println("输入0返回或输入6退出");
            int b = input.nextInt();
            if(b==0){
                showMain();
            }else{
                System.out.println("谢谢使用！！！");
                System.exit(0);
            }

        }
    }
    public static void dianZan(){
        System.out.println("***我要点赞***");
        System.out.println("序号\t菜名\t单价");
        System.out.println("1\t红烧带鱼\t38.0元\t"+hongshaodaiyu+"赞");
        System.out.println("2\t鱼香肉丝\t20.0元\t"+yuxaingrousi+"赞");
        System.out.println("3\t时令鲜蔬\t10.0元\t"+shilingxianshu+"赞");
        System.out.println("请选择您要点赞的菜品序号：");
        int a = input.nextInt();
        if(a==1){
            hongshaodaiyu++;
        }else if(a==2){
            yuxaingrousi++;
        }else if(a==3){
            shilingxianshu++;
        }else{
            System.out.println("输入错误，退出程序");
            System.exit(0);
        }
        System.out.println("点赞成功！！");
        System.out.println("输入0返回或输入6退出");
        int b = input.nextInt();
        if(b==0){
            showMain();
        }else{
            System.out.println("谢谢使用！！！");
            System.exit(0);
        }
    }
    public static Scanner input = new Scanner(System.in);
    public static  Person[] person = new Person[100];
    public static int index = 0;
    public static int hongshaodaiyu = 0;
    public static int yuxaingrousi = 0;
    public static int shilingxianshu = 0;

    public static void main(String[] args) {
            showMain();
            while(true){
                int select = input.nextInt();
                switch(select){
                    case 1:dianCan();break;
                    case 2:chaKan();break;
                    case 3:qianShou();break;
                    case 4:shanChu();break;
                    case 5:dianZan();break;
                    case 6:
                        System.out.println("谢谢使用，欢迎下次光临");System.exit(0);
                    default:
                        System.out.println("输入错误！！退出系统");
                        System.exit(0);

                }
            }
    }
}
