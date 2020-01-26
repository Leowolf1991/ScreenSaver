import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {


    public static void main(String[] args) throws DbxException {

        MyThread myThread = new MyThread();

        myThread.start();
    }
}
