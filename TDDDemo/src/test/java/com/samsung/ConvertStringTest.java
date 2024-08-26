package com.samsung;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ConvertStringTest
{
    ConvertString convertString = null;
    @Before
    public void Setup()
    {
        convertString = new ConvertString();
    }
    @Test
    public void Should_return_string_without_bracket()
    {
        //Arrange
        String content = "This is content without bracket";

        //Act
        String returnContent = convertString.removeBracketContent(content);

        //Assertion
        Assert.assertEquals(content, returnContent);
    }

    @Test
    public void Should_return_content_after_single_bracket_is_removed()
    {
        //Arrange
        String content = "This is content (in braket)";
        String expectedOutput = "This is content";

        //Act
        String output = convertString.removeBracketContent(content);

        //Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void Should_remove_content_in_bracket()
    {
        ConvertString fnUnderTest = new ConvertString();
        Assert.assertEquals( "This is content", fnUnderTest.removeBracketContent("This is content (in braket)"));
        Assert.assertEquals( "This is content", fnUnderTest.removeBracketContent("This is content (in brakcet (in more bracket))"));
        Assert.assertEquals( "This is content with ( open bracket", fnUnderTest.removeBracketContent("This is content with ( open bracket"));
        Assert.assertEquals("This is content and one more", fnUnderTest.removeBracketContent("This is content (in bracket (and more)) and one more (bracket)"));
        Assert.assertEquals("This is content", fnUnderTest.removeBracketContent("This is content (in bracket (in bracket (in bracket)))"));
    }

    @Test
    public void Should_remove_content_in_group()
    {
        ConvertString fnUnderTest = new ConvertString();
        Assert.assertEquals("This is content with", fnUnderTest.removeContentInGroup("This is content with test"));
        Assert.assertEquals("This is content with", fnUnderTest.removeContentInGroup("This is content with tst"));
        Assert.assertEquals("This is content with", fnUnderTest.removeContentInGroup("This is content with st"));
        Assert.assertEquals("This is content with", fnUnderTest.removeContentInGroup("This is content with app"));
        Assert.assertEquals("This is content with", fnUnderTest.removeContentInGroup("This is content with application"));
    }

}
