/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.wenba.convert.util;

import com.aspose.words.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) throws Exception {
//        new Test().loadLicense();
        String dataDir = "D:/lijie/8621076/";
        // Load the document from the absolute path on disk.
        Document doc = new Document(dataDir + "�ʰɻ�ʽ����ϵͳ.doc");
//        HtmlSaveOptions saveOptions=new HtmlSaveOptions();
//        saveOptions.setImageResolution(10000);
        // Save the document as DOCX document.");
        SaveOptions saveOptions;
        doc.save(dataDir + "����ʡ������2014���п��������⣨word�棬���𰸣�.doc.html");
    }

    /**
     * ��Classpath��jar�ļ��У��ж�ȡLicense
     */
    public void loadLicense() {
        //���ض�ȡָ����Դ��������
        License license = new License();
        InputStream is = null;
        try {
            System.out.println(new File("src/aspose.word.license.xml").exists());
            is = new FileInputStream("src/aspose.word.license.xml");
            if (is == null) {
                throw new RuntimeException("Cannot find licenses file. Please contact wdmsyf@yahoo.com or visit http://sheng.javaeye.com for get more information.");
            }
            license.setLicense(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                };
                is = null;
            }
        }
    }
}
