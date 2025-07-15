// import java.awt.AWTException;
// import java.awt.Robot;
// import java.awt.datatransfer.Clipboard;
// import java.awt.datatransfer.StringSelection;
// import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

public class MyNewApp {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Message: ");
        String text = sc.nextLine();
        System.out.print("Enter the Size: ");
        int size = sc.nextInt();

        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Thread.sleep(3000);

        Robot robot = new Robot();

        for (int i = 1; i <= size; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            System.out.println(i);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(500);
        }

        sc.close();
    }
}