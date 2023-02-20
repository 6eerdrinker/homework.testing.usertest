package user;

public class UserMain {
    public static void main(String[] args) {
        User user = new User();

        System.out.println(user.checkLogin("Ivan", "xxx@mail.ru"));
        System.out.println(user.getLogin() + user.getEmail());
    }


}
