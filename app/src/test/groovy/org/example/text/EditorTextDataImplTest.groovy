package org.example.text

import org.example.editorData.EditorData
import org.example.editorData.EditorDataImpl
import org.example.editorData.cursor.Cursor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.awt.event.KeyEvent

class EditorTextDataImplTest {

    EditorData editorTextData
    private final String sampleFile = "src/test/resources/sampleFile.cpp"

    @BeforeEach
    void setUp() {
        editorTextData = new EditorDataImpl()

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
                lines.getAt(cpos + 2..<lines.size())

        Assertions.assertEquals lines, editorTextData.getLines()
        Assertions.assertEquals cursor, editorTextData.getCursor()
    }

    void injectKeyStrokes(List<Object> keys) {
        keys.forEach {
            it instanceof String
                    ? it.toCharArray().collect().forEach { c -> editorTextData.typeCharacter(c as char) }
                    : editorTextData.handleKeyEvent(it as int)
        }
    }

    @Test
    void testTyping() {
        injectKeyStrokes([
                String.join('\n', [
                        "Apple",
                        "Bee",
                ])
        ])
        assertState([
                "Apple",
                "Bee", null, "",
        ])

        injectKeyStrokes(["\b"])
        assertState([
                "Apple",
                "Be", null, "",
        ])

        injectKeyStrokes(["\b\b"])
        assertState([
                "Apple",
                "", null, "",
        ])

        injectKeyStrokes(["\b"])
        assertState([
                "Apple", null, "",
        ])

        injectKeyStrokes(["\b", "icaton", "\n", "Program"])
        assertState([
                "Applicaton",
                "Program", null, "",
        ])

        injectKeyStrokes([KeyEvent.VK_UP, KeyEvent.VK_RIGHT, "i"])
        assertState([
                "Applicati", null, "on",
                "Program",
        ])

        injectKeyStrokes([KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN])
        assertState([
                "Application",
                "Program",  null, "",
        ])


    }


}