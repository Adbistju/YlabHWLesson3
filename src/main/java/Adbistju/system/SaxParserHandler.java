package Adbistju.system;

import Adbistju.system.models.File;
import Adbistju.system.models.FolderMy;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxParserHandler extends DefaultHandler {
    private boolean currentIsFile = false;
    private FolderMy currentFolder;

    private String currentTagName;

    FolderMy f;

    public FolderMy getRot() {
        return f;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;

        if(currentTagName.equals("child")){
            currentIsFile = Boolean.parseBoolean(attributes.getValue("is-file"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(currentTagName.equals("child")){
            currentFolder = currentFolder.getPrevious();
        }
        if(currentTagName.equals("child")){
            currentIsFile = false;
        }
        currentTagName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) {
            return;
        }
        if (!new String(ch, start, length).isBlank()) {
            if(f == null){
                f = new FolderMy(new String(ch, start, length));
                currentFolder = f;
                return;
            }

            if(currentTagName.equals("name") && f != null){
                if(currentIsFile){
                    currentFolder.addFile(new File(new String(ch, start, length)));
                }else{
                    FolderMy my = new FolderMy(new String(ch, start, length), currentFolder);
                    currentFolder.addFile(my);
                    currentFolder = my;
                }
            }
        }

    }
}
