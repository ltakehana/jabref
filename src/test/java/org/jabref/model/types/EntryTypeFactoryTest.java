package org.jabref.model.types;

import org.jabref.model.database.BibDatabaseMode;
import org.jabref.model.entry.BibEntryType;
import org.jabref.model.entry.field.BibField;
import org.jabref.model.entry.field.FieldPriority;
import org.jabref.model.entry.field.OrFields;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.EntryType;
import org.jabref.model.entry.types.EntryTypeFactory;
import org.jabref.model.entry.types.UnknownEntryType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class EntryTypeFactoryTest {
    @Test
    void validateIsEqualNameAndFieldBased(){
        EntryType customizedType = new UnknownEntryType("customizedType");
        BibEntryType customizedBibType1 = new BibEntryType(
                customizedType,
                Arrays.asList(
                        new BibField(StandardField.TITLE, FieldPriority.IMPORTANT),
                        new BibField(StandardField.AUTHOR, FieldPriority.IMPORTANT),
                        new BibField(StandardField.DATE, FieldPriority.IMPORTANT),
                        new BibField(StandardField.YEAR, FieldPriority.IMPORTANT),
                        new BibField(StandardField.MONTH, FieldPriority.IMPORTANT),
                        new BibField(StandardField.PUBLISHER, FieldPriority.IMPORTANT)),
                Arrays.asList(
                        new OrFields(StandardField.TITLE),
                        new OrFields(StandardField.AUTHOR),
                        new OrFields(StandardField.DATE)));
        BibEntryType customizedBibType2 = new BibEntryType(
                customizedType,
                Arrays.asList(
                        new BibField(StandardField.TITLE, FieldPriority.IMPORTANT),
                        new BibField(StandardField.AUTHOR, FieldPriority.IMPORTANT),
                        new BibField(StandardField.PUBLISHER, FieldPriority.IMPORTANT)),
                Arrays.asList(
                        new OrFields(StandardField.TITLE)));
        boolean result = EntryTypeFactory.isEqualNameAndFieldBased(null,null);
        assertTrue(result);
        result = EntryTypeFactory.isEqualNameAndFieldBased(customizedBibType1,null);
        assertFalse(result);
        result = EntryTypeFactory.isEqualNameAndFieldBased(null,customizedBibType1);
        assertFalse(result);
        result = EntryTypeFactory.isEqualNameAndFieldBased(customizedBibType1,customizedBibType1);
        assertTrue(result);
        result = EntryTypeFactory.isEqualNameAndFieldBased(customizedBibType1,customizedBibType2);
        assertFalse(result);
    }
}
