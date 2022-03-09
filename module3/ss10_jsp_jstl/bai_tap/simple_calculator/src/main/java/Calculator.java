public class Calculator {
    public double calculate(double firstOperator, double secondOperator, String operator) throws Exception {
        if (operator.equals(":") && secondOperator == 0) {
            throw new Exception("Invalid number!");
        } else {
            switch (operator) {
                case "+":
                    return firstOperator + secondOperator;
                case "-":
                    return firstOperator - secondOperator;
                case "x":
                    return firstOperator * secondOperator;
                case ":":
                    return firstOperator / secondOperator;
                default:
                    throw new Exception("Invalid number!");
            }
        }
    }
}
