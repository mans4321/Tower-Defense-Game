package gamemodel.bankaccount;
/**
 * This class is responsible for initializing the player balance.
 *     
 * The balance means the amount of money that player has.
 * The player  can use the amount of money  to buy or upgrade their tower.  
 * also the player can sell their towers and receive certain amount of money for that.
 *   
 *@author yongpinggao
 *@version 1.0
 *@since 26/1/16
 *   
 */
public class BankAccout {

    private double balance;
    /**
     * A constructor for initializing the player balance.
     * @param initialBalance the initial amount of money the player has 
     */
    public BankAccout(int initialBalance){
        this.balance = initialBalance;
    }
    /**
     * get the balance 
     * @return the balance 
     */
    public double getBalance() {
        return balance;
    }
/**
 * set the balance 
 * @param balance  amount of money the player has
 */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
