package ss8_clean_code_va_refactoring.bai_tap;

public class TennisGame {
    static final int Love = 0;
    static final int Fifteen = 1;
    static final int Thirty = 2;
    static final int Forty = 3;

    public static String getScore(String firstPlayer, String secondPlayer, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        if (firstPlayerScore == secondPlayerScore) {
            switch (firstPlayerScore) {
                case Love:
                    score = "Love-All";
                    break;
                case Fifteen:
                    score = "Fifteen-All";
                    break;
                case Thirty:
                    score = "Thirty-All";
                    break;
                case Forty:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            int minusResult = firstPlayerScore - secondPlayerScore;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = firstPlayerScore;
                else {
                    score += "-";
                    tempScore = secondPlayerScore;
                }
                switch (tempScore) {
                    case Love:
                        score += "Love";
                        break;
                    case Fifteen:
                        score += "Fifteen";
                        break;
                    case Thirty:
                        score += "Thirty";
                        break;
                    case Forty:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}

//public class TennisGame {
//
//    public static String getPoint(String firstPlayer, String secondPlayer, int firstPlayerPoint, int secondPlayerPoint) {
//
//        String playerPoint = "";
//        int mainPoint = 0;
//        boolean checkDeuce = firstPlayerPoint == secondPlayerPoint;
//        boolean checkBreak = (firstPlayerPoint >= 4 || secondPlayerPoint >= 4);
//
//        if (checkDeuce) {
//            playerPoint = pointingDeuceCase(firstPlayerPoint);
//        } else if (checkBreak) {
//            playerPoint = pointingBreakCase(firstPlayerPoint, secondPlayerPoint);
//        } else {
//            playerPoint = pointingMainPoint(firstPlayerPoint, secondPlayerPoint);
//        }
//        return playerPoint;
//    }
//
//    public static String pointingDeuceCase(int playerPoint) {
//        switch (playerPoint) {
//            case 0:
//                return "Love-All";
//            case 1:
//                return "Fifteen-All";
//            case 2:
//                return "Thirty-All";
//            case 3:
//                return "Forty-All";
//            default:
//                return "Deuce";
//
//        }
//    }
//
//    public static String pointingBreakCase(int firstPlayerPoint, int secondPlayerPoint) {
//        int minusPlayerPoint = firstPlayerPoint - secondPlayerPoint;
//        if (minusPlayerPoint == 1) {
//            return "Advantage player1";
//        } else if (minusPlayerPoint == -1) {
//            return "Advantage player2";
//        } else if (minusPlayerPoint >= 2) {
//            return "Win for player1";
//        } else {
//            return "Win for player2";
//        }
//    }
//
//    public static String pointingMainPoint(int firstPlayerPoint, int secondPlayerPoint) {
//        int mainPoint;
//        String playerPoint = null;
//        for (int i = 1; i < 3; i++) {
//            if (i == 1) mainPoint = firstPlayerPoint;
//            else {
//                playerPoint += "-";
//                mainPoint = secondPlayerPoint;
//            }
//            switch (mainPoint) {
//                case 0:
//                    playerPoint += "Love";
//                    break;
//                case 1:
//                    playerPoint += "Fifteen";
//                    break;
//                case 2:
//                    playerPoint += "Thirty";
//                    break;
//                case 3:
//                    playerPoint += "Forty";
//                    break;
//            }
//        }
//        return playerPoint;
//    }
//}
