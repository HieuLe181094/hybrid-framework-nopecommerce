package utilities;

import net.datafaker.Faker;

public class FakerNet {
    public Faker faker = new Faker();

    public static FakerNet getFaker() {
        return new FakerNet();
    };

    public String getEmailAddress(){
        return faker.internet().emailAddress();
    }

    public String getCity(){
        return faker.address().city();
    }

    public String getAddress(){
        return faker.address().fullAddress();
    }

    public String getCompanyName(){
        return faker.company().name();
    }

    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getFullName(){
        return faker.name().fullName();
    }

    // 10-20
    public String getPassword(){
        return faker.internet().password(10,20);
    }
}
