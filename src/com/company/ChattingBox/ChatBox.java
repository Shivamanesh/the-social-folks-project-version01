package com.company.ChattingBox;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;


public class ChatBox implements AllowingChatAnalysis{
    final private String username;

    final private List<String> existingUsernames;
    Scanner scanner;
    private final List<String> responseStorage;


    public ChatBox(String username, List<String> existingUsernames) {
        this.username = username;
        this.existingUsernames = existingUsernames;
        this.scanner = new Scanner(System.in);
        this.responseStorage = new ArrayList<>();
    }

    public List<String> getResponseStorage() {
        return responseStorage;
    }

    private List <String> questionsGenerator() {
        List <String> listsOfQuestions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/com/company/ChattingBox/Questions.txt"));
        ) {
            String next;
            while ((next = reader.readLine()) != null) {
                listsOfQuestions.add(next);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listsOfQuestions;
    }

    public void chatFormulator(){
        System.out.print(generateGreetings());
        System.out.print(" and how are you?" );
        System.out.println("");
        System.out.println("You are chatting with: " + getChattingPartner());
        chatWithUser();
    }

    private String generateGreetings(){
        int hour = LocalTime.now().getHour();
        if (hour < 12){
            return "Good morning to you, " + username;
        }
        else if (hour < 18){
            return "Good afternoon to you, " + username;
        }
        else{
            return "Good evening to you, " + username;
        }
    }

    private String getChattingPartner(){
        List <String> chatableUsernames = new ArrayList<>();
        for (String user: existingUsernames){
            if (!user.equals(username.toLowerCase())){
                chatableUsernames.add(user);
            }
        }
        int randomNumber = generateRandomNumber(chatableUsernames.size());
        return chatableUsernames.get(randomNumber);
    }

    private int generateRandomNumber(int size){
        Random random = new Random();
        return random.nextInt(size);
    }

    private void chatWithUser(){
        int questionLimit = 2;
        List <String> questions = questionsGenerator();
        for (int i = 0; i < questionLimit; i++){
            int randomNumber = generateRandomNumber(questionLimit);
            System.out.println(questions.get(randomNumber));
            String userResponse = scanner.nextLine();
            if (isAnalysisAllowed()){
                responseStorage.add(userResponse);
            }

        }


    }


    @Override
    public boolean isAnalysisAllowed() {
        System.out.println("Do you permit us to store your data for analysis? Yes (y)/ No (n)");
        String response = scanner.nextLine();
        if (response.toLowerCase().equals("no") || response.toLowerCase().equals("n")) {
            return false;
        } else {
            return true;
        }
    }
}
