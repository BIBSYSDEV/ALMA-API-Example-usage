package no.unit.alma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import no.bibsys.alma.rest.bibs.Bibs;

public class ApiHelper {

    @Test
    void testReadBibs() {
        try {
            Bibs bib = readXmlFromFile("src/test/resources/bibs.xml", Bibs.class);
            System.out.println(bib);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readXmlFromFile(String fileName, Class<T> type) throws IOException {
        File file = new File(fileName);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        return xmlMapper.readValue(xml, type);
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
