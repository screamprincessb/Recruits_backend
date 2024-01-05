package com.sense.service.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.apache.commons.net.ftp.FTPClient;
import java.net.InetSocketAddress;
import java.net.Socket;
import lombok.Data;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTP;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@Data
public class FtpUtil {

    private FTPClient ftp = null;
    private FtpUtil connection;
    private String pathLocal = "C:\\ftp_download\\branch_code\\rtu_code";
    //private String pathLocal = "/opt/WLMAPRO/branch_code/rtu_code";
    //private String pathLocal = "/Users/natthawat/Documents/ftp_download/branch_code/rtu_code";

    public FTPFile[] openConnect(String host, String user, String pass, int port, String ftpPath) throws IOException {
        FTPFile[] files = null;
        try {
            ftp = new FTPClient();
//            ftp.setControlEncoding("UTF-8");
            ftp.setConnectTimeout(5000);
            ftp.connect(host, port);
            ftp.login(user, pass);
            ftp.enterLocalActiveMode();
            //   ftp.enterRemoteActiveMode(InetAddress.getByName(host), port);
            //   ftp.setPassiveLocalIPAddress(host);
//            ftp.setActiveExternalIPAddress(host);
            files = ftp.listFiles(ftpPath);

        } catch (IOException ex) {
            throw (ex);
        }

        return files;
    }

    public String testOpenConnect(String host, String user, String pass, int port, String ftpPath) {
        String files = "";
        try {

            String test = "เข้าได้ ";
            ftp = new FTPClient();
            // ftp.setControlEncoding("UTF-8");
            ftp.setConnectTimeout(5000);
            ftp.connect(host, port);
            ftp.login(user, pass);
            ftp.setPassiveLocalIPAddress(host);
            if (!ftp.login(user, pass)) {
                test = "เข้าไม่ได้ ";
            }

            FTPFile[] dataList = ftp.listFiles();
            files = "สถานะ ".concat(test) + String.valueOf(dataList.length).concat(" HOST: ").concat(host).concat(" USER : ").concat(user).concat(" PASS : ").concat(pass);

        } catch (IOException ex) {
        }

        return files;
    }

    public String[] openConnectFtp(String server, String username, String password, int port, String remoteDirectoryPath) throws IOException {
        String[] files = null;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

            files = ftpClient.listNames(remoteDirectoryPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return files;
        }
    }

    public void downloadFile(
            String host,
            int port,
            String user,
            String password,
            String name,
            String remoteFilePath,
            String localFilePath) throws IOException {
        OutputStream outputStream = null;
        try {
            if (!(new File(localFilePath)).exists()) {
                new File(localFilePath).mkdirs();
            }
            String downloadPath = remoteFilePath.concat(name);
            File saveAs = new File(localFilePath.concat("/").concat(name));
            ftp.connect(host, port);
            ftp.login(user, password);
            outputStream = new BufferedOutputStream(new FileOutputStream(saveAs));
            boolean success = ftp.retrieveFile(downloadPath, outputStream);
            outputStream.close();

            if (success) {
                System.out.println(" downloaded successfully. ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                //ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean isReachable(String addr, int openPort, int timeOutMillis) {
        try {
            try ( Socket soc = new Socket()) {
                soc.connect(new InetSocketAddress(addr, openPort),
                        timeOutMillis);
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public FTPClient getFtp() {
        return ftp;
    }

    public void setFtp(FTPClient ftp) {
        this.ftp = ftp;
    }

    public static String getJSON(String url, String query) throws MalformedURLException, IOException {
        try {
            HttpURLConnection c = null;
            URL u = new URL(url + "?" + query);

            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setRequestProperty("Content-Type", "application/json; utf-8");
            c.setRequestProperty("Accept", "application/json");
            c.setDoOutput(true);
            c.setConnectTimeout(10000);
            c.connect();

            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "utf-8"));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.contains("<h2>")) {
                            String first = line.replace("<h2>", "");
                            String last = first.replace("</h2>", "");
                            sb.append(last);
                        }
                    }
                    br.close();

                    return sb.toString();
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return "";
    }
}
