package by.a1qa.userinterface.utils;

import by.a1qa.userinterface.enums.Domain;
import by.a1qa.userinterface.enums.Interest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomItemUtil {
    private static Random random = new Random();

    private RandomItemUtil() {
    }

    public static List<Interest> getRandomInterests(int interestQuantity) {
        List<Interest> interestList = new ArrayList<>();
        Interest[] arrayOfInterests = Interest.values();

        while (interestList.size() < interestQuantity){
            int interestPosition = random.nextInt(arrayOfInterests.length - 1);
            Interest interest = arrayOfInterests[interestPosition];
            if(!interestList.contains(interest)){
                interestList.add(interest);
            }
        }
        return interestList;
    }

    public static Domain getRandomDomain() {
        Domain[] domains = Domain.values();
        return domains[random.nextInt(domains.length)];
    }
}
