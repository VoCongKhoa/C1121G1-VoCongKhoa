package ss8_clean_code_va_refactoring.bai_tap;

public class TennisGame {

    public static String getPoint(String firstPlayer, String secondPlayer, int firstPlayerPoint, int secondPlayerPoint) {

        String playerPoint = "";
        int mainPoint = 0;
        boolean checkDeuce = firstPlayerPoint == secondPlayerPoint;
        boolean checkBreak = (firstPlayerPoint >= 4 || secondPlayerPoint >= 4);

        if (checkDeuce) {
            playerPoint = pointingDeuceCase(firstPlayerPoint);
        } else if (checkBreak) {
            playerPoint = pointingBreakCase(firstPlayerPoint, secondPlayerPoint);
        } else {
            playerPoint = pointingMainPoint(firstPlayerPoint, secondPlayerPoint);
        }
        return playerPoint;
    }

    public static String pointingDeuceCase(int playerPoint) {
        switch (playerPoint) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }
    }

    public static String pointingBreakCase(int firstPlayerPoint, int secondPlayerPoint) {
        int minusPlayerPoint = firstPlayerPoint - secondPlayerPoint;
        if (minusPlayerPoint == 1) {
            return "Advantage player1";
        } else if (minusPlayerPoint == -1) {
            return "Advantage player2";
        } else if (minusPlayerPoint >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public static String pointingMainPoint(int firstPlayerPoint, int secondPlayerPoint) {
        int mainPoint;
        String playerPoint = null;
        for (int i = 1; i < 3; i++) {
            if (i == 1) mainPoint = firstPlayerPoint;
            else {
                playerPoint += "-";
                mainPoint = secondPlayerPoint;
            }
            switch (mainPoint) {
                case 0:
                    playerPoint += "Love";
                    break;
                case 1:
                    playerPoint += "Fifteen";
                    break;
                case 2:
                    playerPoint += "Thirty";
                    break;
                case 3:
                    playerPoint += "Forty";
                    break;
            }
        }
        return playerPoint;
    }
}
