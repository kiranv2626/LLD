package parkinglot.payment;

public class Pyament {
      public void doPayment(String paymentType,float amount){
          if(paymentType.equals("cash")){
              //here we can extend with classe
              System.out.println("payment done");
          }
          else if(paymentType.equals("card")){
              //here we can extend with classe
              System.out.println("payment done");
          }


      }
}
