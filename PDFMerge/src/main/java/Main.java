import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String args[]) {
        FileInputStream fis;
        Properties property = new Properties();

        String fileFirst = null;
        String fileSecond = null;
        String fileThird = null;

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            fileFirst = property.getProperty("filefirst");
            fileSecond = property.getProperty("filesecond");
            fileThird = property.getProperty("filesthird");

        } catch(IOException e){
            System.err.println("Error: file properties not exist");
        }


        PDFMergerUtility ut = new PDFMergerUtility();

        try {
            ut.addSource(fileFirst);
            ut.addSource(fileSecond);
            ut.setDestinationFileName(fileThird);
            ut.mergeDocuments();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
