public class Menu{

    private User user;
    public static void main(String[] args) {
        new Menu();
    }

    public Menu() {
        user = new User();
        System.out.println("test3");
        gui f = new gui(this.user);
    }

    public User getUser() {
        return user;
    }
}
