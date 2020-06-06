

// this is the test class to test that is the twoHeads + twoTails + headTails == total number of trials
public class CoinTossSimulatorTester {

    public static void main(String[] args) {
          CoinTossSimulator cointosssimulator = new CoinTossSimulator();
//        System.out.println("After constructor: ");
//        System.out.println("Number of trials [exp:0]: " + cointosssimulator.getNumTrials());
//        System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
//        System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
//        System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
//        boolean state0 = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
//                        + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
//        System.out.println("Tosses add up correctly? " + state0);
//
//        System.out.println();
//        System.out.println("After run(1): ");
//        cointosssimulator.run(1);
//        System.out.println("Number of trials [exp:1]: " + cointosssimulator.getNumTrials());
//        System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
//        System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
//        System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
//        boolean state1 = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
//                + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
//        System.out.println("Tosses add up correctly? " + state1);
//        cointosssimulator.reset();
//
//        System.out.println();
//        System.out.println("After run(11): ");
//        cointosssimulator.run(11);
//        System.out.println("Number of trials [exp:11]: " + cointosssimulator.getNumTrials());
//        System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
//        System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
//        System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
//        boolean state2 = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
//                + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
//        System.out.println("Tosses add up correctly? " + state2);
//        cointosssimulator.reset();
//
//        System.out.println();
//        System.out.println("After run(111): ");
//        cointosssimulator.run(111);
//        System.out.println("Number of trials [exp:111]: " + cointosssimulator.getNumTrials());
//        System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
//        System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
//        System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
//        boolean state3 = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
//                + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
//        System.out.println("Tosses add up correctly? " + state3);
//        cointosssimulator.reset();
//
//        System.out.println();
//        System.out.println("After reset: ");
//        System.out.println("Number of trials [exp:0]: " + cointosssimulator.getNumTrials());
//        System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
//        System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
//        System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
//        boolean state4 = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
//                + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
//        System.out.println("Tosses add up correctly? " + state4);
//        cointosssimulator.reset();
//
//        System.out.println();
//        System.out.println("After run(1000): ");
//        cointosssimulator.run(1000);
//        System.out.println("Number of trials [exp:1000]: " + cointosssimulator.getNumTrials());
//        System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
//        System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
//        System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
//        boolean state5 = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
//                + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
//        System.out.println("Tosses add up correctly? " + state5);


        int[] trials = new int[]{1000, 5, 12};
        for(int i = 0; i < trials.length; i++) {
            int number = trials[i];
            cointosssimulator.run(number);
            System.out.println("Number of trials [exp: " + cointosssimulator.getNumTrials() +"]" + cointosssimulator.getNumTrials());
            System.out.println("Two-head tosses: " + cointosssimulator.getTwoHeads());
            System.out.println("Two-tail tosses: " + cointosssimulator.getTwoTails());
            System.out.println("One-head one-tail tosses: " + cointosssimulator.getHeadTails());
            boolean state = cointosssimulator.getNumTrials() == cointosssimulator.getHeadTails()
                + cointosssimulator.getTwoTails() + cointosssimulator.getTwoHeads();
            System.out.println("Tosses add up correctly? " + state);

        }
//        private static void runAndprint(CoinTossSimulatorTester cs, int currNumTrials, int expectedTotal) {
//            System.out.println("After run (" + currNumTrials + "): " +);
//            cs.run(currNumTrials);
//        }








    }
}
