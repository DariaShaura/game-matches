package com.company.entity;

public class GameInfo {
    public static final int MAX_MATCHES_ON_STEP = 3;
    public static final int MIN_MATCHES_ON_STEP = 1;

    private int numberMatchesOnTable;
    private int numberMatchesOnLastStep;
    private int moveNumber;
    private Player currentPlayer = Player.COMPUTER;
    private GameStatus gameStatus = GameStatus.GAME_BEGIN;

    public GameInfo() {
        numberMatchesOnTable = 30;
    }

    public int getNumberMatchesOnTable() {
        return numberMatchesOnTable;
    }

    public void setNumberMatchesOnTable(int numberMatchesOnTable) {
        this.numberMatchesOnTable = numberMatchesOnTable;
    }

    public int getNumberMatchesOnLastStep() {
        return numberMatchesOnLastStep;
    }

    public void setNumberMatchesOnLastStep(int numberMatchesOnLastStep) {
        this.numberMatchesOnLastStep = numberMatchesOnLastStep;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
