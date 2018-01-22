package Assgts1;

import javax.swing.*;
import java.util.Scanner;

/**
 * Class CoinSimViewer
 * It prompts for the number of trials and creates the JFrame containing in the CoinSimComponent.
 * It defines the numTrails and then calls the CoinSimComponent to execute the toss.
 */

public class CoinSimViewer {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(800,500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Please enter the number of trails");
        Scanner in = new Scanner(System.in);
        int numTrails = in.nextInt();
        if(numTrails <= 0) {
            System.out.println("Error input! Please enter valid number of trails.");
        } else {
            CoinSimComponent coinSimComponent = new CoinSimComponent(numTrails);
            frame.add(coinSimComponent);

            frame.setVisible(true);
        }
    }
}
