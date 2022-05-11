package com.lhj;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;

public class Bg {
    //编写绘制背景的方法
    void paintSelf(Graphics g,int finshLevel){
        //定义所需参数
        g.drawImage(GameUtils.bgimg,0,0,null);
        switch (GameWin.state){
            case 0:
                GameUtils.drawWord(g,"开始",Color.red,80,700,500);
                break;
            case 1:
                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.orange,50,200,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.orange,50,600,120);
                GameUtils.drawWord(g,"等级"+finshLevel,Color.orange,50,1000,120);
                break;
            case 2:
                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.orange,50,200,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.orange,50,600,120);
                GameUtils.drawWord(g,"等级"+finshLevel,Color.orange,50,1000,120);
                GameUtils.drawWord(g,"失败",Color.red,80,700,500);
                break;
            case 4:
                break;
            case 3:
                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.orange,50,200,120);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.orange,50,600,120);
                GameUtils.drawWord(g,"等级"+finshLevel,Color.orange,50,1000,120);
                GameUtils.drawWord(g,"胜利",Color.red,80,700,500);
                break;
            default:
        }
    }
}
