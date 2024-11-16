package org.example.editor;



import org.example.settings.EditorSettings;
import org.example.text.Cursor;
import org.example.text.EditorTextData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class EditorTextPanel extends JPanel implements KeyListener {
    private final EditorTextData textData;
    private final EditorSettings settings;

    public EditorTextPanel(EditorTextData textData, EditorSettings settings) {
        this.textData = textData;
        this.settings = settings;
        setBackground(settings.getEditorTheme().getBackGroundColor());
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawTheText(g);

        drawTheCursor(g);
    }

    private void drawTheCursor(Graphics g) {
        g.setColor(settings.getEditorTheme().getCursorColor());

        Cursor cursor = textData.getCursor();
        int charWidth = g.getFontMetrics().charWidth('m');
        int lineHeight = g.getFontMetrics().getHeight();
        settings.getEditorFont();
        g.drawLine(
                settings.getLeftMargin() + cursor.col * charWidth,
                (cursor.row + 1) * lineHeight,
                settings.getLeftMargin() + (cursor.col + 1) * charWidth,
                (cursor.row + 1) * lineHeight
        );
    }

    private void drawTheText(Graphics g) {
        g.setColor(settings.getEditorTheme().getTextColor());
        g.setFont(settings.getEditorFont());

        final int Y = g.getFontMetrics().getHeight();
        int y = Y;
        for (String line : textData.getLines()) {
            g.drawString(line, settings.getLeftMargin(), y);
            y += Y;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        textData.typeCharacter(c);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle special keys if needed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Optional
    }
}