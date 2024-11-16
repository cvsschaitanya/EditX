package org.example.settings;

import org.example.settings.theme.EditorTheme;

import java.awt.*;

public interface EditorSettings {
    public EditorTheme getEditorTheme();
    public int getLeftMargin();
    public Font getEditorFont();
}
