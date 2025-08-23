package getSetter;

public class Test {
    public static void main(String[] args){
        UserGetter user = new UserGetter();
        System.out.println(user.getEmailAddress());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());

        UserSetter userSetter = new UserSetter();
        userSetter.setFirstName("Essie");
        userSetter.setLastName("Geard");
        userSetter.setEmailAddress("egeard4@craigslist.org");

        User use = new User();

        // Validate dữ liệu trước khi gán
        use.setEmailAddress("egeard4@craigslist.org");
        use.setFirstName("Essie");
        use.setLastName("Geard");

        System.out.println(user.getEmailAddress());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());

        UserLombok userLombok = new UserLombok();

        userLombok.setEmail("egeard4@craigslist.org");
        userLombok.setFirstName("Essie");
        userLombok.setLastName("Geard");

        System.out.println(userLombok.getEmail());
        System.out.println(userLombok.getFirstName());
        System.out.println(userLombok.getLastName());


    }
}
