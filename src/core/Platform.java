package core;

public class Platform {
    public static void main(String[] args) {
        User u1 = new User("Joe", 10000, 10000);
        User u2 = new User("Tom",50000, 50000);
        u1.sellBC(5000, u2);
        u2.buyBC(2000, u1);

        if(checkValidTransaction(u1, u2)){
            System.out.println("Valid Transaction");
            System.out.println("User1: BitClout Amount - " + u1.getBcVolume() + " Ethereum Amount - " + u1.getEthVolume());
            System.out.println("User2: BitClout Amount - " + u2.getBcVolume() + " Ethereum Amount - " + u2.getEthVolume());
        } else {
            System.out.println("Invalid Transaction");
        }
    }

    public static boolean checkValidTransaction(User u1, User u2) {
        if (u1.getBcVolume() < 0 || u1.getEthVolume() < 0) {
            return false;
        }
        return true;
    }
}
