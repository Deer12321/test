package com.lhj;

import java.awt.*;

public class Enamy {
    //定义图片
    Image img;
    //定义物体坐标
    int x;
    int y;
    int width;
    int height;
    //定义移动速度
    int speed;
    //定义移动方向,从左向右是1，从右向左是-1
    int dir = 1;
    //定义鱼的类型分值
    int type;
    int count;
    //编写元素绘制自身的方法，和获取自身矩形的方法，用于碰撞检测
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
//创建敌方鱼左类
class Enamy_1_L extends Enamy{
    //设置参数
    Enamy_1_L(){
        this.x = -45;
        this.y = (int)(Math.random()*700+100);
        this.width = 45;
        this.height = 69;
        this.speed = 10;
        this.count = 1;
        this.type = 1;
        this.img = GameUtils.enamy1_img;
    }
}
class Enamy_1_R extends Enamy_1_L{
    Enamy_1_R(){
        this.x = 1400;
        dir = -1;
        this.img = GameUtils.enamyr_img;
    }
}
class Enamy_2_L extends Enamy{
    //设置参数
    Enamy_2_L(){
        this.x = -100;
        this.y = (int)(Math.random()*700+100);
        this.width = 100;
        this.height = 100;
        this.speed = 5;
        this.count = 2;
        this.type = 2;
        this.img = GameUtils.enamyl_2img;
    }
}
class Enamy_2_R extends Enamy_2_L{
    Enamy_2_R(){
        this.x = 1400;
        dir = -1;
        this.img = GameUtils.enamyr_2img;
    }
}
class Enamy_3_L extends Enamy{
    //设置参数
    Enamy_3_L(){
        this.x = -300;
        this.y = (int)(Math.random()*700+100);
        this.width = 300;
        this.height = 150;
        this.speed = 15;
        this.count = 3;
        this.type = 3;
        this.img = GameUtils.enamyl_3img;
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x+40,y+30,width-80,height-60);
    }
}
class Enamy_3_R extends Enamy_3_L{
    Enamy_3_R(){
        this.x = 1400;
        dir = -1;
        this.img = GameUtils.enamyr_3img;
    }
}
class Enamy_Boss extends Enamy{
    Enamy_Boss() {
        this.x = -1000;
        this.y = (int)(Math.random()*700+100);
        this.width = 340;
        this.height = 340;
        this.speed = 50;
        this.count = 0;
        this.type = 10;
        this.img = GameUtils.bossimg;
    }
}