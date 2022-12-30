package br.tec.gvfsolucoes.ultimateracingcareer.util;

import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

public class FontAwsomeHelper {

    private static volatile FontAwsomeHelper instance;
    private static final Object MUTEX = new Object();

    private final GlyphFont glyphFont;

    private FontAwsomeHelper() {
        glyphFont = GlyphFontRegistry.font("FontAwesome");
    }

    public static FontAwsomeHelper getInstance() {
        FontAwsomeHelper result = instance;
        if (result == null) {
            synchronized (MUTEX) {
                result = instance;
                if (result == null)
                    instance = result = new FontAwsomeHelper();
            }
        }
        return result;
    }

    public GlyphFont getGlyphFont() {
        return glyphFont;
    }
}
