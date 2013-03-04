package sporacidscalper.view.presentation.util;

//import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public final class HtmlUtilities
{
	/**
	 * Taken from http://technojeeves.com/joomla/index.php/free/99-java-xml-document-from-string
	 * Format the html string to an xhtml compliant format.
	 * @param htmlString String to format
	 * @return A formatted String
	 */
	public static String formatHtml(String htmlString)
		//throws IOException, ParserConfigurationException, Exception
	{
		/*Document result = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputSource source = new InputSource(new StringReader(htmlString));

        try 
        {
            result = factory.newDocumentBuilder().parse(source);
        } 
        catch (Exception e)
        {
        	e.printStackTrace();//throw e;
        }
        
        return result.getTextContent();*/
		
		return htmlString;
	}
}
