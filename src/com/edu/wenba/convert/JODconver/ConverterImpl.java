/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.wenba.convert.JODconver;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.XmlDocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ConverterImpl implements Converter {

    public DocumentConverter converter;
    public DocumentFormatRegistry registry;

    public ConverterImpl(DocumentConverter converter,
            DocumentFormatRegistry registry) {
        super();
        this.converter = converter;
        this.registry = registry;
    }

    public ConverterImpl(String host, int port) {
        try {
            SocketOpenOfficeConnection openOfficeConnection = new SocketOpenOfficeConnection(host, port);
            System.out.println(new File("documentFormats.xml").getAbsolutePath());
            XmlDocumentFormatRegistry documentFormatRegistry = new XmlDocumentFormatRegistry(new FileInputStream("src/documentFormats.xml"));
            OpenOfficeDocumentConverter documentConverter = new OpenOfficeDocumentConverter(openOfficeConnection, documentFormatRegistry);
            this.converter = documentConverter;
            this.registry = documentFormatRegistry;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConverterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void convert(File inputFile, File outputFile) {

        DocumentFormat inputFormat = registry
                .getFormatByFileExtension(FilenameUtils.getExtension(inputFile
                                .getAbsolutePath()));
        DocumentFormat outputFormat = registry
                .getFormatByFileExtension(FilenameUtils.getExtension(outputFile
                                .getAbsolutePath()));
        converter.convert(inputFile, inputFormat, outputFile, outputFormat);

    }

    @Override
    public void convert(File inputFile, DocumentFormat inputFormat,
            File outputFile, DocumentFormat outputFormat) {
        converter.convert(inputFile, inputFormat, outputFile, outputFormat);

    }

    public static void main(String[] args) {
        Converter c = new ConverterImpl("127.0.0.1", 8100);
        c.convert(new File("D:\\lijie\\8621076\\问吧花式推题系统.html"), new File("D:\\lijie\\8621076\\历史试卷.doc"));
    }

}
