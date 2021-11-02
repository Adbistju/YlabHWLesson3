package Adbistju.system;

import Adbistju.system.models.FolderMy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser {
    public FolderMy parse(String filePath) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();

        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File(filePath);
            parser.parse(file,handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return handler.getRot();
    }

}