public class Client extends User {    
     
    private Account account;
    
    public Client(){
	    this.account = new Account();
    }


    public Account getAccount(){
	    return this.account;
    }

    public void setAccount(Account account){
	    this.account = account;
    }
    
    public void setCurrency(String currency) {
        this.account.setCurrency(currency);
    }

    public String getCurrency() {
        return this.account.getCurrency();
    }

    public void deposit(int amount){
        this.account.deposit(amount);
    }

    public void withdraw(int amount){
        this.account.withdraw(amount);
    }

    public int getBalance(){
        return this.account.getBalance();
    }
}
