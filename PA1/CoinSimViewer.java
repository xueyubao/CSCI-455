import javax.swing.*;


//this is the class consists main method to show the whole program
public class CoinSimViewer {

    public static void main(String[] args) {
        // create a variable of CoinSimComponent class
        CoinSimComponent coinsimcomponent = new CoinSimComponent();
        // call the getNumberOfTrials method
        coinsimcomponent.getNumberOfTrials();

        //create the window and set it.
        JFrame frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the variable of CoinSimComponent into thia frame
        frame.add(coinsimcomponent);
        frame.setVisible(true);


    }

}
