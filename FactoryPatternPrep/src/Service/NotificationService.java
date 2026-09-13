package Service;

import Model.EmailNotification;
import Model.Notifier;
import Model.SmsNotification;

public class NotificationService {
    Notifier notifier;

    public Notifier sendNotification(String method) {
        switch (method) {
            case "Email":
                return new EmailNotification();
            case "SMS":
                return new SmsNotification();
            default:
                throw new IllegalArgumentException("Notification method does not exists");
        }

    }
}
