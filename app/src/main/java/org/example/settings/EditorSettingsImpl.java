package org.example.settings;


import org.example.settings.theme.EditorTheme;

import java.awt.*;

public class EditorSettingsImpl implements EditorSettings{
    private final EditorTheme theme;
    private final int lineHeight;
    private int charWidth;
    private int leftMargin;
    private Font editorFont;

    public EditorSettingsImpl(EditorTheme theme, int lineHeight, int charWidth, int leftMargin, Font editorFont) {
        this.theme = theme;
        this.lineHeight = lineHeight;
        this.charWidth = charWidth;
        this.leftMargin = leftMargin;
        this.editorFont = editorFont;
    }

    @Override
    public EditorTheme getEditorTheme() {
        return theme;
    }

    @Override
    public int getLeftMargin() {
        return leftMargin;
    }

    @Override
    public Font getEditorFont() {
        return editorFont;
    }
}
