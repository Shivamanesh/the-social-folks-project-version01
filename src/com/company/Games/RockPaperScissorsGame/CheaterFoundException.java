package com.company.Games.RockPaperScissorsGame;

public class CheaterFoundException extends RuntimeException{

    public CheaterFoundException(String message) {

    }

    public String getMessage(){
        return "Totally wrong";
    }
}
