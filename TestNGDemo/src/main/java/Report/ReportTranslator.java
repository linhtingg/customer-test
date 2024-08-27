package Report;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportTranslator {
    ReadXMLFile xmlReader;

    public ReportTranslator(ReadXMLFile xmlReader) {
        this.xmlReader = xmlReader;
    }

    public String getTypeTranslate(String Type, String period) {
        String xmlContent = xmlReader.getXMLContent();

        String regPattern = "";
        if(period==null)
            regPattern = "<"+Type+">(.+)<\\/"+Type+">";
        else
            regPattern = "<"+Type+"><"+period+">(.+)<\\/"+period+"><\\/"+Type+">";

        Pattern typePattern = Pattern.compile(regPattern);
        Matcher matcher = typePattern.matcher(xmlContent);
        if(matcher.find())
        {
            return matcher.group(1);
        }
        return "";
    }

    public String getFileTranslation(String fileName)
    {
        String fileNameOnly = fileName.split("\\.")[0];
        String[] filePart = fileNameOnly.split("_");
        if(filePart.length==3)
        {
            return getTypeTranslate(filePart[0], null) +" "+ filePart[2];
        }
        else if(filePart.length==4)
        {
            return getTypeTranslate(filePart[0], filePart[2]) +" "+ filePart[3];
        }

        return fileName;
    }

}
