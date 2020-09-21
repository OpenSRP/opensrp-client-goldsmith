package org.smartregister.goldsmith.pinlogin;

public class PinLoginUtil {
    private static PinLogger pinLogger;
    public static PinLogger getPinLogger() {
        if (pinLogger == null) {
            pinLogger = new SecurePinLogger();
        }
        return pinLogger;
    }
}
