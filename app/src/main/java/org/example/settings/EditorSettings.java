package org.example.settings;

import org.example.settings.theme.EditorTheme;

import java.awt.*;

public interface EditorSettings {
    EditorTheme getEditorTheme();
    int getLeftMargin();
    Font getEditorFont();
}
