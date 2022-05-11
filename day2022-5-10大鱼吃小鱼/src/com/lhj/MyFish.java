package com.lhj;

import java.awt.*;

public class MyFish {
    //定义图片
    Image img = GameUtils.MyFish_L;
    //坐标
    int x = 700;
    int y = 500;
    int width = 50;
    int height = 50;
    //速度
    int speed = 20;
    //等级
    int level = 1;
    //控制
    void logic(){
        if(GameUtils.UP){
            y = y - speed;
        }
        if(GameUtils.DOWN){
            y = y + speed;
        }
        if(GameUtils.LEFT){
            x = x - speed;
            img = GameUtils.MyFish_L;
        }
        if(GameUtils.RIGHT){
            x = x + speed;
            img = GameUtils.MyFish_R;
        }
    }
    //绘制自身的方法
    public void paintSelf(Graphics g){
        logic();
        g.drawImage(img,x,y,width+GameUtils.count,height+GameUtils.count,null);

    }
    //获取自身矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,width+GameUtils.count,height+GameUtils.count);
    }
}
