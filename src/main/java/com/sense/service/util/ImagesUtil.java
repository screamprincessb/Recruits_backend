package com.sense.service.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class ImagesUtil {

    /*  
    PG
    jpg
    tiff
    bmp
    BMP
    gif
    GIF
    WBMP
    png
    PNG
    JPEG
    tif
    TIF
    TIFF
    wbmp
    jpeg
     //--convert Image to BufferedImage    
     */
    public static BufferedImage resizedImage(byte[] bytes, int scaledWidth, int scaledHeight) throws IOException {
        InputStream is = new ByteArrayInputStream(bytes);
        Image image = ImageIO.read(is);
        return createResizedCopy(image, scaledWidth, scaledHeight, true);
    }

    public static BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha) {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetSize) throws IOException {
        return Scalr.resize(originalImage, targetSize);
    }

    public static String encoder(String filePath) {
        String base64File = "";
        File file = new File(filePath);
        try ( FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            byte fileData[] = new byte[(int) file.length()];
            imageInFile.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
        return base64File;
    }

    public static void main(String[] args) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encoder("C:\\Users\\User\\Downloads\\images_pun\\sku.jpg"));
            //BufferedImage img = resizedImage(decodedBytes, 200, 200);

            // save the resize image aka thumbnail
            // ImageIO.write(img, "jpg", new File("C:\\Users\\User\\Downloads\\11_test\\bonneville-custom-thumbnail.jpg"));
            InputStream is = new ByteArrayInputStream(decodedBytes);
            BufferedImage newBi = ImageIO.read(is);
            BufferedImage resizedImage = resizeImage(newBi, 200);
            File resizedFile = new File("C:\\Users\\User\\Downloads\\images_pun\\thumbnail_sku.jpg");
            ImageIO.write(resizedImage, "jpg", resizedFile);

            newBi.flush();
            resizedImage.flush();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }


    

}
