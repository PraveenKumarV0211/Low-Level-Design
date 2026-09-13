package Model;

public class EmailNotification implements Notifier{
    @Override
    public void sendNotification(String details) {
        System.out.println("Sent Notification via Email");
    }
}
