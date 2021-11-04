package Adbistju.system;


import Adbistju.system.comarator.Comparator;
import Adbistju.system.comarator.FabricComparator;
import Adbistju.system.exception.ArgumentException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser {
    private String filePath;
    private Comparator comparator;
    public void parse() {
        if(filePath == null && comparator == null){
            throw new ArgumentException("parameter not found");
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler(comparator);

        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File(filePath);
            parser.parse(file,handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public SaxMyParser setFilePath(String[] args) {
        this.filePath = new ParserFilePathArg().addParams(args);
        return this;
    }

    public SaxMyParser setComparator(String[] args) {
        this.comparator = new FabricComparator().FabricComparator(args);
        return this;
    }
}