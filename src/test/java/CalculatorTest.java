import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("5+3");
        calculator.equalButton.doClick();
        assertEquals("8.0", calculator.screen.getText(), "Addition test failed");
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("10-4");
        calculator.equalButton.doClick();
        assertEquals("6.0", calculator.screen.getText(), "Subtraction test failed");
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("5*3");
        calculator.equalButton.doClick();
        assertEquals("15.0", calculator.screen.getText(), "Multiplication test failed");
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("10/2");
        calculator.equalButton.doClick();
        assertEquals("5.0", calculator.screen.getText(), "Division test failed");
    }

    @Test
    void testPercentage() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("50");
        calculator.percentButton.doClick();
        assertEquals("0.5", calculator.screen.getText(), "Percentage test failed");
    }

    @Test
    void testSquareRoot() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("25");
        calculator.squareRootButton.doClick();
        assertEquals("5.0", calculator.screen.getText(), "Square root test failed");
    }

    @Test
    void testClearButton() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.clearButton.doClick();
        assertEquals("", calculator.screen.getText(), "Clear button test failed");
    }

    @Test
    void testBackButton() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.backButton.doClick();
        assertEquals("12", calculator.screen.getText(), "Back button test failed");
    }

    @Test
    void testDecimalButton() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.decimalButton.doClick();
        assertEquals("123.", calculator.screen.getText(), "Decimal button test failed");
    }

    @Test
    void testZeroButton() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.zeroButton.doClick();
        assertEquals("1230", calculator.screen.getText(), "Zero button test failed");
    }

    // Test division by zero
    @Test
    void testDivisionByZero() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("10/0");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Division by zero test failed");
    }

    // Test invalid expression
    @Test
    void testInvalidExpression() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("10++2");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid expression test failed");
    }

    // Test for invalid input in percentage button
    @Test
    void testInvalidInputPercentageButton() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("abc");
        calculator.percentButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid input in percentage button test failed");
    }


    @Test
    void testClearButtonWithResultDisplayed() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.equalButton.doClick();
        calculator.clearButton.doClick();
        assertEquals("", calculator.screen.getText(), "Clear button with result displayed test failed");
    }

    @Test
    void testClearButtonWithPartialExpression() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123+");
        calculator.clearButton.doClick();
        assertEquals("", calculator.screen.getText(), "Clear button with partial expression test failed");
    }

    @Test
    void testInvalidExpressionWithNoOperand2() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("10+");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid expression with no operand 2 test failed");
    }

    @Test
    void testInvalidExpressionWithNoOperator() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("10");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid expression with no operator test failed");
    }

    @Test
    void testBackButtonWithEmptyScreen() {
        Calculator calculator = new Calculator();
        calculator.backButton.doClick();
        assertEquals("", calculator.screen.getText(), "Back button with empty screen test failed");
    }

    @Test
    void testZeroButtonAfterNonZeroDigit() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.zeroButton.doClick();
        assertEquals("1230", calculator.screen.getText(), "Zero button after non-zero digit test failed");
    }

    @Test
    void testInvalidExpressionWithSingleOperator() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("+");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid expression with single operator test failed");
    }

    @Test
    void testInvalidExpressionWithOnlyOperators() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("+*-/");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid expression with only operators test failed");
    }

    @Test
    void testInvalidExpressionWithOnlyOperands() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("12345");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Invalid expression with only operands test failed");
    }

    @Test
    void testMixedValidAndInvalidExpression() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("12+34*");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Mixed valid and invalid expression test failed");
    }

    @Test
    void testClearButtonWithPartialResult() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("12+34*2");
        calculator.clearButton.doClick();
        assertEquals("", calculator.screen.getText(), "Clear button with partial result test failed");
    }

    @Test
    void testClearButtonAfterError() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123/");
        calculator.equalButton.doClick();
        calculator.clearButton.doClick();
        assertEquals("", calculator.screen.getText(), "Clear button after error test failed");
    }

    @Test
    void testClearButtonWithMultipleBackButtonClicks() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("123");
        calculator.backButton.doClick();
        calculator.backButton.doClick();
        calculator.backButton.doClick();
        calculator.clearButton.doClick();
        assertEquals("", calculator.screen.getText(), "Clear button with multiple back button clicks test failed");
    }

    @Test
    void testExpressionWithLeadingZero() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("012+3");
        calculator.equalButton.doClick();
        assertEquals("15.0", calculator.screen.getText(), "Expression with leading zero test failed");
    }

    @Test
    void testExpressionWithTrailingOperator() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("12+");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Expression with trailing operator test failed");
    }

    @Test
    void testExpressionWithTrailingDecimal() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("12.5+");
        calculator.equalButton.doClick();
        assertEquals("Error", calculator.screen.getText(), "Expression with trailing decimal test failed");
    }

    @Test
    void testScientificNotation() {
        Calculator calculator = new Calculator();
        calculator.screen.setText("1.2E3*0.5");
        calculator.equalButton.doClick();
        assertEquals("600.0", calculator.screen.getText(), "Scientific notation multiplication test failed");

        calculator.screen.setText("1.5E2+2.5E2");
        calculator.equalButton.doClick();
        assertEquals("400.0", calculator.screen.getText(), "Scientific notation addition test failed");
    }
}
