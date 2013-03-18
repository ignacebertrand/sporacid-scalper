package sporacidscalper.view.presentation.util;

//import java.io.IOException;
//import java.io.BufferedOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.StringReader;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMResult;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.w3c.dom.Document;
//import org.xml.sax.InputSource;
//import javax.xml.parsers.ParserConfigurationException;

public final class HtmlUtilities
{
//	/**
//	 * Taken from http://technojeeves.com/joomla/index.php/free/99-java-xml-document-from-string
//	 * Format the html string to an xhtml compliant format.
//	 * @param htmlString String to format
//	 * @return A formatted String
//	 */
//	public static String formatHtml(String htmlString)
//		//throws IOException, ParserConfigurationException, Exception
//	{
//		Document result = null;
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        InputSource source = new InputSource(new StringReader(htmlString));
//
//        try 
//        {
//    		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
//        	Schema schema = schemaFactory.newSchema(new StreamSource(new StringReader(htmlString)));
//        	factory.setSchema(schema);
//            result = factory.newDocumentBuilder().parse(source);
//        } 
//        catch (Exception e)
//        {
//        	e.printStackTrace();//throw e;
//        }
//        
//        return result.getTextContent();
//	}
	
	/**
	 * Taken from http://technojeeves.com/joomla/index.php/free/99-java-xml-document-from-string
	 * Format the html string to an xhtml compliant format.
	 * @param htmlString String to format
	 * @return A formatted String
	 */
	public static String formatHtml(String htmlString)
		//throws IOException, ParserConfigurationException, Exception
	{
//	     try 
//	     {
//            DocumentBuilderFactory factory = DocumentBuilderFactory
//                    .newInstance();
//            factory.setValidating(true);
//            DocumentBuilder builder = factory.newDocumentBuilder();
//           
//            InputSource source = new InputSource(new StringReader(htmlString));
//            Document xmlDocument = builder.parse(source);
//            
//            DOMSource domSource = new DOMSource(xmlDocument);
//            DOMResult domResult = new DOMResult(domSource.getNode());
//
//            TransformerFactory tf = TransformerFactory.newInstance();
//            Transformer transformer = tf.newTransformer();
//            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
//                    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
//            transformer.transform(domSource, domResult);
//            
//            return domResult.getNode().getTextContent();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//   	     	return htmlString;
//        }
		return htmlString;
	}
}
