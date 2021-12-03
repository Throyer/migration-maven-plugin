package com.github.throyer.migrations;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameFormatterTests {
    
    @Test
    public void should_remove_especial_characters() {
        var result = "EBomQueEleAceiteEssaBagaca";
        var name = NameFormatter.formatNameMigrationJavaBased("é-bom-que-ele-aceite-essa-bagaça");
        assertEquals(name, result);
    }
}
