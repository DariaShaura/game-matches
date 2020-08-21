package com.company.service;

import com.company.dto.InputOutputGameDto;
import com.company.entity.GameInfo;
import com.company.entity.GameStatus;
import com.company.entity.Player;

public class GameService {

    private GameInfo gameInfo;

    public GameService() {
    }

    private void changeGameInfo(int numberMatchesOnLastStep, Player currentPlayer) {

        gameInfo.setNumberMatchesOnLastStep(numberMatchesOnLastStep);
        gameInfo.setNumberMatchesOnTable(gameInfo.getNumberMatchesOnTable() - numberMatchesOnLastStep);
        gameInfo.setMoveNumber(gameInfo.getMoveNumber() + 1);
        gameInfo.setCurrentPlayer(currentPlayer);

        if (gameInfo.getNumberMatchesOnTable() == 1) {
            gameInfo.setGameStatus(GameStatus.GAME_OVER);
        } else {
            gameInfo.setGameStatus(GameStatus.GAME_ON);
        }
    }

    public void play() {

        ComputerPlayerService computerPlayerService = new ComputerPlayerService();
        InputOutputGameDto inputOutputGameDto = new InputOutputGameDto();
        gameInfo = new GameInfo();
        int matchesUserTook;

        inputOutputGameDto.outputGameInfo(gameInfo.getGameStatus(), gameInfo.getNumberMatchesOnTable());

        // ход компьютера
        // изменение состояния игры,вывод информации
        Player currentPlayer = Player.COMPUTER;
        changeGameInfo(computerPlayerService.makeMove(gameInfo), currentPlayer);
        inputOutputGameDto.outputComputerMoveInfo(gameInfo.getNumberMatchesOnLastStep());
        inputOutputGameDto.outputGameInfo(gameInfo.getGameStatus(), gameInfo.getNumberMatchesOnTable());

        while (gameInfo.getGameStatus() == GameStatus.GAME_ON) {
            // ход человека
            // изменение состояния игры,вывод информации
            matchesUserTook = inputOutputGameDto.inputUserMoveInfo();
            while ((matchesUserTook < 1) || (matchesUserTook > 3)) {
                inputOutputGameDto.outputErrorInfo();
                inputOutputGameDto.outputGameInfo(gameInfo.getGameStatus(), gameInfo.getNumberMatchesOnTable());
                matchesUserTook = inputOutputGameDto.inputUserMoveInfo();
            }
            currentPlayer = Player.USER;
            changeGameInfo(matchesUserTook, currentPlayer);
            inputOutputGameDto.outputGameInfo(gameInfo.getGameStatus(), gameInfo.getNumberMatchesOnTable());

            // ход компьютера
            // изменение состояния игры,вывод информации
            currentPlayer = Player.COMPUTER;
            changeGameInfo(computerPlayerService.makeMove(gameInfo), currentPlayer);
            inputOutputGameDto.outputComputerMoveInfo(gameInfo.getNumberMatchesOnLastStep());
            inputOutputGameDto.outputGameInfo(gameInfo.getGameStatus(), gameInfo.getNumberMatchesOnTable());
        }
        // вывод

    }
}

