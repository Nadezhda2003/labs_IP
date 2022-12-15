import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ArgumentsForTest implements ArgumentsProvider {
    public static class Argument {
        public int precision;
        public double argument;
        public Argument(double argument, int precision) {
            this.argument = argument;
            this.precision = precision;
        }
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new Argument(0.5, 4)),
                Arguments.of(new Argument(0.6, 6)),
                Arguments.of(new Argument(-0.7, 10)),
                Arguments.of(new Argument(0.1, 12)),
                Arguments.of(new Argument(12, 14))
        );
    }
}
