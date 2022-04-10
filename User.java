public class User{

    private Account account;
    
    public User(){
    this.account = new Account();
    }

    public Account getAccount(){
        return this.account;
    }
    
    public void setAccount(Account account){
        this.account = account;
    }
    
}
