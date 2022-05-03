public class Assignment {


 /** 
  * Random generator 
  */
 private static java.util.Random generator = new java.util.Random();

  /** 
   * In this second method, we will select a line at random.
   *  1) we select a line y = ax + b, with a randomly selected
   * between -100 and +100 and b randomly selected between 
   * -250 and +250
   *  2) we add 500 samples randomly selected on the line
   * between -100 and +300. For each sample we add a "noise" 
   * randomly selected between -1000 and +1000 (that is, for
   * each randomly selected x, we add the sample (x, ax+b+noise).
   * where "noise" is randomly selected between -1000 and 1000
   *  3) We create an instance of Display
   *  4) we iterate gradient descent (find a number of iterations,
   * a number of updates to the instance of Display, and a 
   * step alpha that seems to work
  */
 private static void randomLine(){
   LinearRegression regression = new LinearRegression(500);
   Display graph = new Display(regression);
   double a = (generator.nextDouble()*200)-100;
   double b = (generator.nextDouble()*500)-250;
   graph.setTarget(a,b);
   for(int i=0;i<500;i++){
     double x = (generator.nextDouble()*400)-100;
     double y = (a*x+b) + (generator.nextDouble()*2000)-1000;
     regression.addSample(x,y);
   }
   for(int j=0;j<=49;j++){
     System.out.println("Current hypothesis: "+regression.currentHypothesis());
     System.out.println("Current cost: "+regression.currentCost());
     System.out.println("Aiming for: "+b+"+"+a+"x_1");
     
     graph.update();
     regression.gradientDescent(0.00000007,100);
   }
   graph.update();
 }


 public static void main(String[] args) {

  randomLine();

 }

}