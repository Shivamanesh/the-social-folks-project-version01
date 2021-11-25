package com.company.Games.RockPaperScissorsGame;

import com.company.Games.RockPaperScissorsGame.CheaterFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors  {
    //If the user wins, return true, otherwise return false
    // rock beats scissor, scissor beats paper, paper beats rock

    private static char getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose between R, S and P: ");
        return scanner.nextLine().charAt(0);
    }

    private static char generateComputerInput(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        List<Character> playableCharacters = getPlayableCharacters();
        return playableCharacters.get(randomNumber);
    }

    public static boolean play(String username) throws CheaterFoundException {
        gameIntro(username);
        char userInput = getUserInput();
        char computerInput = generateComputerInput();
        List<Character> playableInput = getPlayableCharacters();

        if (playableInput.contains(userInput) && playableInput.contains(computerInput)){
            return gameMechanics(username, userInput, computerInput);
        }else{
            throw new CheaterFoundException("Please input S, P or R and all must be in caps");
        }
    }

    private static boolean gameMechanics(String username, Character userInput, Character computerInput){
        String userInputString = userInput.toString().toUpperCase();
        String computerInputString = computerInput.toString().toUpperCase();
        System.out.println("You played " + userInput + " and the computer played " + computerInput);
        if (userInputString.equals("R") && computerInputString.equals("R")){
            System.out.println(username.toUpperCase() + " won!!!!");
            return true;
        }
        else if (userInputString.equals("S") && computerInputString.equals("P")){
            System.out.println(username.toUpperCase() + " won!!!!");
            return true;
        }
        else if (userInputString.equals("P") && computerInputString.equals("R")){
            System.out.println(username.toUpperCase() + " won!!!!");
            return true;
        }
        else{
            System.out.println(username.toUpperCase() + " lost!!!!. Sorry");
            return false;
        }
    }

    private static void gameIntro(String username){
        System.out.println("Everyone, " + username.toUpperCase() + " is playing " + "RockPaperScissors !!!");

    }

    private static List<Character> getPlayableCharacters(){
        List<Character> playableInput = new ArrayList<>();
        playableInput.add('R');
        playableInput.add('S');
        playableInput.add('P');
        return playableInput;
    }
}