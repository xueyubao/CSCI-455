import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

// this is the CoinSimComponent class, used to create the component of frame and finally added into frame.
// In this class, we have two methods, one is Scanner in the trails you want, and the other is painting component.
public class CoinSimComponent extends JComponent {

    //the number of trials, result of three different situations
    private int totalTrials;
    private int twoHeads;
    private int headTails;
    private int twoTails;

    // The fixed value of bar width, vertical buffer and labelHeight and they are designed by the developer.
    private final int BAR_WIDTH = 50;
    private final int VERTICAL_BUFFER = 30;
    private final int LABEL_HEIGHT = 25;

    //this is the method that type in total trials you want and get the results of different types.
    public void getNumberOfTrials() {
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter the total number that you want to trail: ");
        //enter total number of trials;
        int totalTrials = input.nextInt();
        while(totalTrials <= 0) {
            System.out.println("Wrong! please enter a number larger than 0: ");
            totalTrials = input.nextInt();
        }

        // call CoinTossSimulator class
        CoinTossSimulator cointosssimulator = new CoinTossSimulator();
        // call the run method in CoinTossSimulate class
        cointosssimulator.run(totalTrials);
        this.twoHeads = cointosssimulator.getTwoHeads();
        this.twoTails = cointosssimulator.getTwoTails();
        this.headTails = cointosssimulator.getHeadTails();
        this.totalTrials = cointosssimulator.getNumTrials();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Height and width of the window
        int windowsHeight = getHeight();
        int windowsWidth = getWidth();
        //compute the bottom of the label
        int bottom = windowsHeight - VERTICAL_BUFFER;
        // computes how many pixels per application unit
        double scale = (windowsHeight - 2 * VERTICAL_BUFFER - LABEL_HEIGHT) * 1.0 / totalTrials;
        //the whole window could be seen like it is quarter divided by 3 bars.
        int widthBetweenBar = (windowsWidth - 3 * BAR_WIDTH) / 4;
        // get the result of x coordinate of each bar
        int leftBar1 = widthBetweenBar;
        int leftBar2 = 2 * widthBetweenBar + BAR_WIDTH;
        int leftBar3 = 3 * widthBetweenBar + 2 * BAR_WIDTH;
        // get the result of each bar's corresponding percent
        int percentBar1 = (int)Math.round(twoHeads * 100.0 / totalTrials);
        int percentBar2 = (int)Math.round(headTails * 100.0 / totalTrials);
        int percentBar3 = (int)Math.round(twoTails * 100.0 / totalTrials);
        //create the 3 string labels
        String label1 = "Two heads: " + twoHeads + "(" + percentBar1 + "%)";
        String label2 = "A head and a tail: " + headTails + "(" + percentBar2 + "%)";
        String label3 = "Two tails: " + twoTails + "(" + percentBar3 + "%)";
        //use Bar class to create three bars
        Bar bar1 = new Bar(bottom, leftBar1, BAR_WIDTH, twoHeads, scale, Color.RED, label1);
        Bar bar2 = new Bar(bottom, leftBar2, BAR_WIDTH, headTails, scale, Color.GREEN, label2);
        Bar bar3 = new Bar(bottom, leftBar3, BAR_WIDTH, twoTails, scale, Color.BLUE, label3);
        //call the draw method in Bar class.
        bar1.draw(g2);
        bar2.draw(g2);
        bar3.draw(g2);
    }
}
