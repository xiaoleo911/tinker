package singleton;

/**
 * 枚举的方式
 *
 * author: fupeng
 * time: 2020-03-30 21:59
 */
public class User {

    private User() {}

    public static User getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public enum SingletonEnum {

        INSTANCE;

        SingletonEnum() {
            this.user = new User();
        }

        private User user;

        public User getInstance() {
            return user;
        }
    }

    public static void main(String[] args) {
        System.out.println(User.getInstance());
        System.out.println(User.getInstance());
        System.out.println(User.getInstance() == User.getInstance());
    }

}
