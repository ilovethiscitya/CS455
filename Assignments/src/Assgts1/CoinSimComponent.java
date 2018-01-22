package Assgts1;

import javax.swing.*;
import java.awt.*;

/*
The CoinSimComponent defines all the necessary parameters for the Assgts1.Bar. It uses the CoinTossSimulator to get the result of all the tosses,
and transfers them to the Assgts1.Bar. All the necessary parameters that Assgts1.Bar needs are also defined in this component. To draw the figure, it finally execute the run().
 */
public class CoinSimComponent extends JComponent {
    private int numTrails;
    final int BARWIDTH = 100;
    final int BOTTOM = 100;
    final int VB = 20;
    public CoinSimComponent(int numTrails) {

        this.numTrails = numTrails;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        coinTossSimulator.run(this.numTrails);
         int numberTrials = coinTossSimulator.getNumTrials();
        final int width = getWidth()/8;
        final int height = getHeight() - VB ;
        double scale = height*1.00/numberTrials*1.00;
        int TwoHeadsBarHeight = (int)(coinTossSimulator.getTwoHeads()*scale);
        int TwoTailsBarHeight = (int)(coinTossSimulator.getTwoTails()*scale);
        int HeadTailsBarHeight = (int)(coinTossSimulator.getHeadTails()*scale);
        final Color TWO_HEADS_COLOR = Color.red;
        final Color HEAD_TAIL_COLOR = Color.green;
        final Color TWO_TAILS_COLOR = Color.BLUE;
        int twoHeadLeft = width;
        int headTailLeft = width*2 + BARWIDTH;
        int twoTailsLeft = width*3 + BARWIDTH*2;
        long proTwoHead = Math.round((coinTossSimulator.getTwoHeads()*1.0/numberTrials*1.0)*100);
        long proHeadTail = Math.round((coinTossSimulator.getHeadTails()*1.0/numberTrials*1.0)*100);

        String twoHeadBar = "Two Heads:" + coinTossSimulator.getTwoHeads() + "（" +proTwoHead +"%)";
        String headTailBar = "A Head and a Tail:" + coinTossSimulator.getHeadTails() + "（" + Math.round((coinTossSimulator.getHeadTails()*1.0/numberTrials*1.0)*100)+"%)";
        String twoTailsBar ="Two Tails:" + coinTossSimulator.getTwoTails() + "（" + Math.round((coinTossSimulator.getTwoTails()*1.0/numberTrials*1.0)*100)+"%)";
        Bar twoHead = new Bar(BOTTOM,twoHeadLeft,BARWIDTH,TwoHeadsBarHeight,scale,TWO_HEADS_COLOR,twoHeadBar);
        Bar headTail = new Bar(BOTTOM,headTailLeft,BARWIDTH,HeadTailsBarHeight,scale,HEAD_TAIL_COLOR,headTailBar);
        Bar twoTails = new Bar(BOTTOM,twoTailsLeft,BARWIDTH,TwoTailsBarHeight,scale,TWO_TAILS_COLOR,twoTailsBar);

        twoHead.draw(g2);
        twoTails.draw(g2);
        headTail.draw(g2);



    }
}
