package com.github.throyer.migrations;

import static org.junit.Assert.*;

import com.github.throyer.utils.Resources;

import org.junit.Test;

public class FindTemplateTest {

    @Test
    public void should_read_template_file() {
        var template = Resources.getTemplate("java-based");
        assertTrue(template.contains("BaseJavaMigration"));
    }
}
