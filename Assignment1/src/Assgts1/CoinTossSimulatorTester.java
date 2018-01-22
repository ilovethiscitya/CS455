package Assgts1;

/**
 * class CoinTossSimulatorTester
 * This class tests the functions in the CoinTossSimulator by using the unit test approach.
 */
public class CoinTossSimulatorTester {
    public static void main(String[] args) {
        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        System.out.println("After constructor");
        coinTossSimulator.run(0);
        System.out.println("Number of trials[exp:0]");
        System.out.println(coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses:");
        System.out.println(coinTossSimulator.getHeadTails());
        System.out.println("Two-trail tosses:");
        System.out.println(coinTossSimulator.getTwoTails());
        System.out.println("one-head one-trail tosses:");
        System.out.println(coinTossSimulator.getTwoHeads());
        System.out.println("Tosses add up correctly?");
        if(coinTossSimulator.getNumTrials() == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println();

        coinTossSimulator.run(1);
        System.out.println("Number of trials[exp:1]");
        System.out.println(coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses:");
        System.out.println(coinTossSimulator.getHeadTails());
        System.out.println("Two-trail tosses:");
        System.out.println(coinTossSimulator.getTwoTails());
        System.out.println("one-head one-trail tosses:");
        System.out.println(coinTossSimulator.getTwoHeads());
        System.out.println("Tosses add up correctly?");
        if(coinTossSimulator.getNumTrials() == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println();

        coinTossSimulator.run(10);
        System.out.println("Number of trials[exp:11]");
        System.out.println(coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses:");
        System.out.println(coinTossSimulator.getHeadTails());
        System.out.println("Two-trail tosses:");
        System.out.println(coinTossSimulator.getTwoTails());
        System.out.println("one-head one-trail tosses:");
        System.out.println(coinTossSimulator.getTwoHeads());
        System.out.println("Tosses add up correctly?");
        if(coinTossSimulator.getNumTrials() == 11) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
       System.out.println();

        coinTossSimulator.run(100);
        System.out.println("Number of trials[exp:111]");
        System.out.println(coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses:");
        System.out.println(coinTossSimulator.getHeadTails());
        System.out.println("Two-trail tosses:");
        System.out.println(coinTossSimulator.getTwoTails());
        System.out.println("one-head one-trail tosses:");
        System.out.println(coinTossSimulator.getTwoHeads());
        System.out.println("Tosses add up correctly?");
        if(coinTossSimulator.getNumTrials() == 111) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("After reset:");
        coinTossSimulator.reset();
        System.out.println("Number of trials[exp:0]");
        System.out.println(coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses:");
        System.out.println(coinTossSimulator.getHeadTails());
        System.out.println("Two-trail tosses:");
        System.out.println(coinTossSimulator.getTwoTails());
        System.out.println("one-head one-trail tosses:");
        System.out.println(coinTossSimulator.getTwoHeads());
        System.out.println("Tosses add up correctly?");
        if(coinTossSimulator.getNumTrials() == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println();

        System.out.println("After run(1000)");
        coinTossSimulator.run(1000);
        System.out.println("Number of trials[exp:1000]");
        System.out.println(coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses:");
        System.out.println(coinTossSimulator.getHeadTails());
        System.out.println("Two-trail tosses:");
        System.out.println(coinTossSimulator.getTwoTails());
        System.out.println("one-head one-trail tosses:");
        System.out.println(coinTossSimulator.getTwoHeads());
        System.out.println("Tosses add up correctly?");
        if(coinTossSimulator.getNumTrials() == 1000) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println();



    }
}
