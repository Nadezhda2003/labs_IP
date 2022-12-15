import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.NumberFormat;

class CalculationTest {

    @ParameterizedTest
    @ArgumentsSource(ArgumentsForTest.class)
    public void Cos_ValidParameters_ReturnsRightResult(ArgumentsForTest.Argument argument) {

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(argument.precision);
        double scale= Math.pow(10, -argument.precision);
        double expectedValue = Math.cos(argument.argument);
        double expectedRoundedValue = Math.ceil(expectedValue * scale) / scale;

        double resultValue = Calculation.cosi(argument.argument, argument.precision);
        double resultRoundedValue = Math.ceil(resultValue * scale) / scale;
        Assertions.assertEquals(expectedRoundedValue, resultRoundedValue, scale);
    }
}