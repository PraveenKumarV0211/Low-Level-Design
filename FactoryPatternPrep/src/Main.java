import Model.Notifier;
import Service.NotificationService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        NotificationService notificationService = new NotificationService();
        Notifier notifier = notificationService.sendNotification("Email");
        notifier.sendNotification("Hellp");
    }
}