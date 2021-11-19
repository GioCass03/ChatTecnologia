/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class gestioneFile {

    private String percorso;
    private File file;
    ArrayList<String> record;

    public gestioneFile() {
        this.percorso = "meteo.csv";
        this.file = new File(percorso);
    }

    public void toCSV(String op) throws IOException {
        FileWriter fw = new FileWriter(this.file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(op);
        bw.flush();
        bw.close();
        fw.close();

    }

    public ArrayList<String> fromCSV() throws FileNotFoundException, IOException {
        record = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("meteo.csv"));
        String line = "";
        while (line != null) {
            line = reader.readLine();
            record.add(line);
        }
        return record;
    }

}
