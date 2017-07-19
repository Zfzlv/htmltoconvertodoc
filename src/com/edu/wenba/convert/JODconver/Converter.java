/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.wenba.convert.JODconver;

import java.io.File;

import com.artofsolving.jodconverter.DocumentFormat;

/**
 *
 * @author Administrator
 */
public interface Converter {

    public void convert(File inputFile, File outputFile);

    public void convert(File inputFile, DocumentFormat inputFormat,
            File outputFile, DocumentFormat outputFormat);
}
