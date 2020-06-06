import java.util.Random;

public class CoinTossSimulator1 {

    private Random rand;
    private int heads;
    private int tails;
    private int trails;



    public CoinTossSimulator1 (int numCoins) {
        heads = 0;
        tails = 0;
        tails = numCoins;

    }

    public int numCoins() {
        return tails;

    }

    public int getNumTrials() {
        return 0;

    }
    public int getResultsWith(int numHeads) {
        return 0;

    }

    public void run(int numTrials) {

    }
}
