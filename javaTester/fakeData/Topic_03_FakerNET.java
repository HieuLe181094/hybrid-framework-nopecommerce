package fakeData;

import net.datafaker.Faker;

public class Topic_03_FakerNET {
    public static void main(String[] agrs) {
        Faker fakeUS = new Faker();
        System.out.println(fakeUS.address().city());
        System.out.println(fakeUS.address().cityName());
        System.out.println(fakeUS.address().country());
        System.out.println(fakeUS.address().countryCode());
        System.out.println(fakeUS.name().firstName());
        System.out.println(fakeUS.name().lastName());
        System.out.println(fakeUS.address().fullAddress());
        System.out.println(fakeUS.address().state());
        System.out.println(fakeUS.address().streetName());
        System.out.println(fakeUS.address().zipCode());
        System.out.println(fakeUS.address().longitude());
        System.out.println(fakeUS.address().latitude());
        System.out.println(fakeUS.internet().ipV4Address());
        System.out.println(fakeUS.internet().privateIpV4Address());
        System.out.println(fakeUS.internet().publicIpV4Address());
        System.out.println(fakeUS.internet().ipV6Address());
        System.out.println(fakeUS.internet().macAddress());
        System.out.println(fakeUS.internet().password());
        System.out.println(fakeUS.internet().password(false));
        System.out.println(fakeUS.internet().url());
        System.out.println(fakeUS.internet().uuid());


    }
}
