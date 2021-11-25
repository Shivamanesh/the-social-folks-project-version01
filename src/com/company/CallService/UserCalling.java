package com.company.CallService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserCalling {

    public static void callAnotherUser(String username, List <String> existingUsernames){
        int randomNumber = generateRandomNumber(existingUsernames.size());
        String callingPartner = existingUsernames.get(randomNumber);

        if (!callingPartner.equals(username.toLowerCase())){
            calling(username, callingPartner);
        }
    }

    private static int generateRandomNumber(int size){
        Random random = new Random();
        return random.nextInt(size);
    }

    private static void calling(String username, String callingPartner){
        System.out.println(username + " is calling " + callingPartner);
        String callingMessage = "I am not available. Please can you call me later";
        System.out.println("");
        for (String word: callingMessage.split(" ")){
            System.out.println(word);
        }
    }
}
