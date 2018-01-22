package Assgts1;// Name:
// USC NetID:
// CS 455 PA1
// Fall 2017
// it has accessors to get the results of the simulation

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 *
 *
 *
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class  CoinTossSimulator {


   private int numberTwoHead;
   private int numberTwoTrail;
   private int numberBoth;
   private int numberTrail;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      this.numberTwoHead = 0;
      this.numberTwoTrail = 0;
      this.numberBoth = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      for(int i = 0; i < numTrials; i++) {
         Random random = new Random();
         int rand = random.nextInt(3);
         if(rand == 0) {
            this.numberTwoHead++;
         }
         if(rand == 1) {
            this.numberTwoTrail++;
         }
         if(rand == 2) {
            this.numberBoth++;
         }
         this.numberTrail++;
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return this.numberTrail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return numberTwoHead; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return numberTwoTrail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return numberBoth; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      this.numberTwoHead = 0;
      this.numberTwoTrail = 0;
      this.numberBoth = 0;
      this.numberTrail = 0;
   }

}
