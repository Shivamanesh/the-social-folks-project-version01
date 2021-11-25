package com.company.Application;

import com.company.CallService.UserCalling;
import com.company.ChattingBox.ChatAnalysis;
import com.company.ChattingBox.ChatBox;
import com.company.Games.Hangman.Hangman;
import com.company.Login.LoginValidation;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class ApplicationOverview {

    public static void main(String[] args) {
        /*LoginValidation loginValidation = new LoginValidation();
        loginValidation.flockingIntoSocialFolks();
        String username = loginValidation.getUsername();
        System.out.println("username: " + username);
        ChatBox chatBox = new ChatBox(username, new ArrayList(loginValidation.getUsernamesData().keySet()));
        chatBox.chatFormulator();
        System.out.println("what you said: " + ChatAnalysis.returnWordsWithFreq(chatBox.getResponseStorage()));*/
        /*UserCalling.callAnotherUser(username, new ArrayList(loginValidation.getUsernamesData().keySet()));*/
        /*Hangman hangman = new Hangman(username);
        hangman.gameOverview();*/

        /*RockPaperScissors.play(username);
         */
       /* Hangman hangman = new Hangman(username);
        hangman.gameOverview();
          *//*"I am thinking a word and you have 10 seconds to try"*//**//**//*
        ChatBox chatBox = new ChatBox(username, new ArrayList(loginValidation.getUsernamesData().keySet()));
        chatBox.chatFormulator();
        System.out.println("what you said: " + ChatAnalysis.returnWordsWithFreq(chatBox.getResponseStorage()));*/
       /* Scanner scanner = new Scanner(System.in);
        int initialTime = LocalTime.now().getSecond();
        System.out.println("intial seconds: " + initialTime);
        System.out.println("final seconds: " + (initialTime + 5));
       for (int i = initialTime; i < initialTime + 10; i++){
            if(LocalTime.now().getSecond() <= (initialTime + 5)){
                System.out.println("Please write here");
                System.out.println("seconds: " + i);
                String answer = scanner.nextLine();
            }
        }
        System.out.println("final final seconds: " + LocalTime.now().getSecond());*/
        try {
            URL url = new URL("https://ahaslides.com/blog/170-general-knowledge-quiz-questions-and-answers-for-your-next-virtual-pub-quiz/");
            Scanner s = new Scanner(url.openStream());
            // read from your scanner
            System.out.println(url);
        }
        catch(IOException ex) {
            // there was some connection problem, or the file did not exist on the server,
            // or your URL was not in the right format.
            // think about what to do now, and put it here.
            ex.printStackTrace(); // for now, simply output it.
        }
    }


}
