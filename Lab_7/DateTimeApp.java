import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeApp {
    public static void main(String[] args) {
        // إنشاء نافذة التطبيق
        JFrame frame = new JFrame("Time & Date Application Thread");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // إضافة Label لعرض الوقت والتاريخ
        JLabel dateTimeLabel = new JLabel("", SwingConstants.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(dateTimeLabel, BorderLayout.CENTER);

        // تحديث الوقت باستخدام Thread
        Thread updateTimeThread = new Thread(() -> {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            while (true) {
                // تحديث الوقت كل ثانية
                String currentTime = formatter.format(new Date());
                dateTimeLabel.setText(currentTime);
                try {
                    Thread.sleep(1000); // تأخير لمدة ثانية واحدة
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // تشغيل Thread التحديث
        updateTimeThread.start();

        // عرض النافذة
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

