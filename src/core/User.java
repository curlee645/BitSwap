package core;
import java.util.Random;

public class User {
    private String username;
    private int userHash;
    private double bcVolume;
    private double ethVolume;

    public static double ETH_USD = 3483.053;
    public static double price_BC = 178;

    public User(String n, double bcAmount, double ethAmount) {
        username = n;
        bcVolume = bcAmount;
        ethVolume = ethAmount;
        Random rand = new Random();
        userHash = rand.nextInt(1999219292);
    }

    //user gives bc and gets eth
    public void sellBC(int bcAmount, User buyer) {
        /**seller side*/
        bcVolume = bcVolume - bcAmount;
        //convert bcAmount to ethAmount
        double ethAmount = bcAmount *  price_BC * ETH_USD;
        ethVolume = ethVolume + ethAmount;

        /**buyer side*/
        double buyerBcVolume = buyer.getBcVolume() + bcAmount ;
        double buyerEthVolume = buyer.getEthVolume() - ethAmount;
        buyer.setBcVolume(buyerBcVolume);
        buyer.setEthVolume(buyerEthVolume);

    }

    //user gives eth and get bc
    public void buyBC(int bcAmount, User seller) {
        /**buyer side*/
        bcVolume = bcVolume + bcAmount;
        //convert bcAmount to ethAmount
        double ethAmount = bcAmount *  price_BC * ETH_USD;
        ethVolume = ethVolume - ethAmount;

        /**seller side*/
        double sellerBcVolume = seller.getBcVolume() - bcAmount ;
        double sellerEthVolume = seller.getEthVolume() + ethAmount;
        seller.setBcVolume(sellerBcVolume);
        seller.setEthVolume(sellerEthVolume);
    }

    public void setUsername(String n){
        username = n;
    }

    public void setBcVolume(double amt){
        bcVolume = amt;
    }

    public void setEthVolume(double amt) {
        ethVolume = amt;
    }

    public String getUsername(){
        return username;
    }

    public double getBcVolume(){
        return bcVolume;
    }

    public double getEthVolume() {
        return ethVolume;
    }
}
