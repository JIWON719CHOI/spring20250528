package com.example.spring.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Transactional
@Service
@RequiredArgsConstructor
public class Service9 {
    public void action1(String username, MultipartFile upload) {
        System.out.println("username = " + username);
        System.out.println("upload = " + upload.getOriginalFilename());

        try {
            InputStream is = upload.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            String filePath = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();

            OutputStream os = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            try (bos; os; bis; is) {
                byte[] buffer = new byte[1024];
                int length;

                while ((length = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);
                }
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
    }

    public void action2(String address, MultipartFile upload) {
        System.out.println("address = " + address);
        System.out.println("upload = " + upload.getOriginalFilename());

        if (upload != null) {
            if (upload.getSize() > 0) {
                try {
                    // inputStream
                    // outputStream
                    String path = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();
                    OutputStream os = new FileOutputStream(path);
                    BufferedOutputStream bos = new BufferedOutputStream(os);

                    InputStream is = new BufferedInputStream(upload.getInputStream());

                    try (is; bos; os;) {
//                        is.transferTo(bos);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) != -1) {
                            bos.write(buffer, 0, length);
                        }
                        bos.flush();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void action3(MultipartFile[] upload) {
        if (upload != null) {
            for (MultipartFile file : upload) {
                if (file.getSize() > 0) {
                    try {
                        String path = "C:/Temp/uploadFiles/" + file.getOriginalFilename();
                        var bis = new BufferedInputStream(file.getInputStream());
                        var bos = new BufferedOutputStream(new FileOutputStream(path));
                        try (bos; bis) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = bis.read(buffer)) != -1) {
                                bos.write(buffer, 0, length);
                            }
                            bos.flush();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}