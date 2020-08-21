package com.company.service;

import com.company.entity.GameInfo;

public class ComputerPlayerService {

    private static final int NUMBER_MATCHES_ON_FIRST_MOVE = 3;
    private static final int NEED_NUMBER_MATCHES_AT_THE_END = 5;
    private static final int SUM_MATCHES_USER_COMPUTER = 4;

    public ComputerPlayerService() {
    }

    public int makeMove(GameInfo gameInfo) {

        int matchesOnTable = gameInfo.getNumberMatchesOnTable();

        if (matchesOnTable == 20) {
            return NUMBER_MATCHES_ON_FIRST_MOVE;
        } else if (((matchesOnTable - NEED_NUMBER_MATCHES_AT_THE_END) >= 1) && ((matchesOnTable - NEED_NUMBER_MATCHES_AT_THE_END) <= 3)) {
            return matchesOnTable - NEED_NUMBER_MATCHES_AT_THE_END;
        } else if ((matchesOnTable - NEED_NUMBER_MATCHES_AT_THE_END) < 0) {
            return matchesOnTable - 1;
        } else {
            return SUM_MATCHES_USER_COMPUTER - gameInfo.getNumberMatchesOnLastStep();
        }

    }
}
