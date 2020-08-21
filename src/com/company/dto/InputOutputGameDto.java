package com.company.dto;

import com.company.entity.GameStatus;

import java.util.Scanner;

public class InputOutputGameDto {

    public InputOutputGameDto() {
    }

    public int inputUserMoveInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("- Ход игрока. Введите количество спичек: ");
        return scanner.nextInt();
    }

    public void outputErrorInfo(){
        System.out.println("Некорректное количество спичек.");
    }

    public void outputGameInfo(GameStatus gameStatus, int numberMatchesOnTable){
        switch (gameStatus){
            case GAME_BEGIN:
                System.out.println("Начало игры. На столе " + numberMatchesOnTable + " спичек.");
                break;
            case GAME_ON:
                System.out.println("На столе осталось " + numberMatchesOnTable + " спичек.");
                break;
            case GAME_OVER:
                System.out.println("Для игрока осталась последняя спичка. Игрок проиграл.");
                break;
        }

    }

    public void outputComputerMoveInfo(int matchesComputerTook){
        System.out.println("- Количество выбранных компьютером спичек = " + matchesComputerTook + ".");
    }

}
