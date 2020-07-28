package utils;

public class waitUtils {

    public enum WaitTime {

        TINY(500),
        SMALL(1000),
        MEDIUM(3000),
        LARGE(9000);

        private final int milsec;

        WaitTime(int milsec) {
            this.milsec = milsec;
        }

        public int getValue() {

            return milsec;
        }
    }
}
