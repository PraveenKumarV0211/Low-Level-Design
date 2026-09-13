package Model;

public class SmsNotification implements Notifier{
    @Override
    public void sendNotification(String details) {
        System.out.println("Notification sent via SMS");
    }
}
