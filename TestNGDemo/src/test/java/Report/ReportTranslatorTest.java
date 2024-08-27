package Report;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class ReportTranslatorTest {
    @Mock
    ReadXMLFile xmlReader;

    @BeforeClass
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void should_return_translate_for_report_type_only()
    {
        //Setup Mock
        when(xmlReader.getXMLContent()).thenReturn("<Translate><IR>Interim Report</IR></Translate>");
        //Arrange
        String type = "IR";
        String expected = "Interim Report";
        ReportTranslator translator = new ReportTranslator(xmlReader);
        //Act
        String result = translator.getTypeTranslate(type, null);
        assertEquals(result, expected);
    }

    @Test
    public void should_return_translate_for_report_type_and_period()
    {
        //Setup Mock
        when(xmlReader.getXMLContent()).thenReturn("<Translate><ER><Q1>Earning Report Q1</Q1></ER></Translate>");
        //Arrange
        String type = "ER";
        String period = "Q1";
        String expected = "Earning Report Q1";
        ReportTranslator translator = new ReportTranslator(xmlReader);
        //Act
        String result = translator.getTypeTranslate(type, period);
        assertEquals(result, expected);
    }

    @Test
    public void should_return_file_name_with_type_only()
    {
        //Setup Mock
        when(xmlReader.getXMLContent()).thenReturn("<Translate><AR>Annual Report</AR></Translate>");
        String fileName = "AR_ENG_2024.pdf";
        String expected = "Annual Report 2024";
        ReportTranslator translator = new ReportTranslator(xmlReader);
        //Act
        String result = translator.getFileTranslation(fileName);

        //Assert
        assertEquals(result, expected);
    }

    @Test
    public void should_return_file_name_with_type_and_period()
    {
        //Setup Mock
        when(xmlReader.getXMLContent()).thenReturn("<Translate><ER><Q1>Earning Report Q1</Q1></ER></Translate>");
        String fileName = "ER_ENG_Q1_2024.pdf";

        String expected = "Earning Report Q1 2024";
        ReportTranslator translator = new ReportTranslator(xmlReader);

        //Act
        String result = translator.getFileTranslation(fileName);

        //Assert
        assertEquals(result, expected);

    }
}
