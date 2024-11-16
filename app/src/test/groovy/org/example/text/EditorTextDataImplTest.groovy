package org.example.text

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EditorTextDataImplTest {

    EditorTextData editorTextData;
    private final String sampleFile = "src/test/resources/sampleFile.cpp";

    @BeforeEach
    public void setUp() {
        editorTextData = new EditorTextDataImpl()

//        println System.getProperty("user.dir")

//        byte[] fileBytes = new FileInputStream(sampleFile).readAllBytes();
//        ByteBuffer.wrap(fileBytes)
//                .asCharBuffer()
//                .chars() // Stream of characters
//                .forEach(c -> editorTextData.typeCharacter((char) c));
    }

    void assertState(List<String> lines) {
        def cpos = lines.indexOf(null)
        Assertions.assertNotEquals(-1, cpos, "Bad Test")
        Assertions.assertNotEquals(0, cpos, "Bad Test")
        Assertions.assertNotEquals(lines.size() - 1, cpos, "Bad Test")

        def cursor = new Cursor(cpos-1, lines.get(cpos - 1).length())

        lines = lines.getAt(0..<cpos - 1) +
                [lines.get(cpos - 1) + lines.get(cpos + 1)] +
                lines.getAt(cpos + 2..<lines.size());

        Assertions.assertEquals lines.size(), editorTextData.getLineCount()
        Assertions.assertEquals lines, editorTextData.getLines()
        for (i in 0..<lines.size()) {
            Assertions.assertEquals lines[i], editorTextData.getTextAtLine(i)
        }
        Assertions.assertEquals cursor, editorTextData.getCursor()
    }

    void injectKeyStrokes(String chars) {
        chars.toCharArray().collect().forEach { c -> editorTextData.typeCharacter(c as char) }
    }

    @Test
    void testTyping() {
        def lines =

                injectKeyStrokes(String.join '\n', [
                        "Apple",
                        "Bee",
                ])
        assertState([
                "Apple",
                "Bee", null, ""
        ])

        injectKeyStrokes("\b")
        assertState([
                "Apple",
                "Be", null, ""
        ])

        injectKeyStrokes("\b\b")
        assertState([
                "Apple",
                "", null, ""
        ])

        injectKeyStrokes("\b")
        assertState([
                "Apple", null, ""
        ])

    }


}