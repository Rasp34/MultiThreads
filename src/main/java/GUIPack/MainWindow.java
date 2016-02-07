package GUIPack;

import Threads.ThreadOne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Art_me
 */
public class MainWindow {
    private JButton startButton;
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public MainWindow() {
        startButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {

                try {
                    ThreadOne thread1 = new ThreadOne(10, 800, "LeftTextThread", textArea1);
                    ThreadOne thread2 = new ThreadOne(4, 500, "RightTextThread", textArea2);
//                    thread2.join();
                } catch (Exception e1) {
                    System.out.println("error!!!");
                    e1.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame mainFrame = new JFrame("ThreadTesting");
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.setSize(new Dimension(400, 400));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

//        Create frame
        MainWindow mainWindow = new MainWindow();
//        Set panel to frame
        mainFrame.setContentPane(mainWindow.mainPanel);

        mainWindow.mainPanel.setVisible(true);
        mainFrame.setVisible(true);


    }

}
