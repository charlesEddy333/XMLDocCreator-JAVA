import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLDocCreator {

    public static void main(String[] args) {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = null;

        try {
            b = f.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = b.newDocument();
        Element rootele = doc.createElement("students");
        Element studentele = doc.createElement("student");
        Element firstnameele = doc.createElement("firstname");
        Element lastnameele = doc.createElement("lastname");
        Element emailele = doc.createElement("email");
        Element phoneele = doc.createElement("phone");
        Element courseele = doc.createElement("courses"); // Changed to plural
        Element batchele = doc.createElement("batch");

        Text t1 = doc.createTextNode("Eddy");
        Text t2 = doc.createTextNode("Ukp");
        Text t3 = doc.createTextNode("edukp2023@gmail.com");
        Text t4 = doc.createTextNode("+2348063453360");

        String[] courses = {"HTML", "CSS", "JAVASCRIPT", "JAVA", "UI AND UX", "C", "SQL", "JSON", "XML"};
        for (int i = 0; i < courses.length; i++) {
            Element course = doc.createElement("course");
            Text courseText = doc.createTextNode(courses[i]);
            course.appendChild(courseText);
            courseele.appendChild(course);
        }

        Text t6 = doc.createTextNode("536");

        firstnameele.appendChild(t1);
        lastnameele.appendChild(t2);
        emailele.appendChild(t3);
        phoneele.appendChild(t4);
        batchele.appendChild(t6);

        studentele.appendChild(firstnameele);
        studentele.appendChild(lastnameele);
        studentele.appendChild(emailele);
        studentele.appendChild(phoneele);
        studentele.appendChild(courseele);
        studentele.appendChild(batchele);

        rootele.appendChild(studentele);
        doc.appendChild(rootele);
        Transformer t = null;

        try {
            t = TransformerFactory.newInstance().newTransformer();

        } catch (TransformerConfigurationException e1) {
            e1.printStackTrace();
        }

        try {
            assert t != null;
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("C:\\Aptech\\students.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("XML File Generated...");
    }
}
