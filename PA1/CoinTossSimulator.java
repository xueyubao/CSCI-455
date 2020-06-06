// Name:
// USC NetID:
// CS 455 PA1
// Spring 2020

import java.util.Random;

/**
 * class CoinTossSimulator
 *
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 *
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants,
 * and private methods to the class.  You will also be completing the
 * implementation of the methods given.
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
public class CoinTossSimulator {
    private int numTrials;  // this is the number of total trials
    private int twoHeads;     // number of two heads
    private int twoTails;     // number of two tails
    private int headTails;    // number of one head and one tail




    /**
     Creates a coin toss simulator with no trials done yet.
     */
    public CoinTossSimulator() {
        this.numTrials = 0;
        this.twoHeads = 0;
        this.twoTails = 0;
        this.headTails = 0;

    }


    /**
     Runs the simulation for numTrials more trials. Multiple calls to this method
     without a reset() between them *add* these trials to the current simulation.

     @param numTrials  number of trials to for simulation; must be >= 1
     */
    public void run(int numTrials) {
        this.numTrials += numTrials;
        for(int i = 0; i < numTrials; i++) {
            Random randomNumber = new Random();
            int firstNumber = randomNumber.nextInt(2);
            int secondNumber = randomNumber.nextInt(2);
            if (firstNumber == 0 && secondNumber == 0) {
                twoHeads++;
            } else if (firstNumber == 1 && secondNumber == 1) {
                twoTails++;
            } else {
                headTails++;
            }
        }

    }


    /**
     Get number of trials performed since last reset.
     */
    public int getNumTrials() {
        return this.numTrials; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up two heads since last reset.
     */
    public int getTwoHeads() {
        return this.twoHeads; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up two tails since last reset.
     */
    public int getTwoTails() {
        return this.twoTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up one head and one tail since last reset.
     */
    public int getHeadTails() {
        return this.headTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {
        this.twoHeads = 0;
        this.twoTails = 0;
        this.headTails = 0;
        this.numTrials = 0;

    }

}
