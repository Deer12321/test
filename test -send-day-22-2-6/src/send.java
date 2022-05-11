import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static java.lang.Math.*;

public class send {
    public static void main(String[] args) throws AWTException {
        //1.内容
        String str="111";
        //2.保存，获取粘贴板空间，加入内容
        Clipboard s = Toolkit.getDefaultToolkit().getSystemClipboard();
        s.setContents(new StringSelection(str),null);
        //3.创建机器人对象，操作键盘
        Robot robot = new Robot();
        //4.重复发送
        for (int i=0;i<3;i++){
            //按ctrl+v
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            //释放CTRL+v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            //发送
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            //间隔时间
            robot.delay(1000);
        }
    }
}
