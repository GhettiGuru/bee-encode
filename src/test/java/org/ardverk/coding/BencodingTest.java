package org.ardverk.coding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BencodingTest {

    private ByteArrayOutputStream byteStream;
    private BencodingOutputStream bEncoder;

    @Before
    public void setup() {
        byteStream = new ByteArrayOutputStream();
        bEncoder = new BencodingOutputStream(byteStream);
    }

    private BencodingInputStream decoder() {
        return decoder(false);
    }

    private BencodingInputStream decoder(boolean decodeAsString) {
        final byte[] bytes = byteStream.toByteArray();
        System.out.println(new String(bytes));
        return new BencodingInputStream(new ByteArrayInputStream(bytes), decodeAsString);
    }

    @Test
    public void testString() throws IOException {
        bEncoder.writeString("test");
        String result = decoder().readString();
        assertEquals("test", result);
    }

    @Test
    public void testInt() throws IOException {
        bEncoder.writeInt(1);
        int result = decoder().readInt();
        assertEquals(1, result);
    }

    @Test
    public void testCollectionsDecoding() throws IOException {
        List<Object> list = new ArrayList<>();
        list.add("testA");
        list.add("testB");
        bEncoder.writeCollection(list);

        List<Object> result = decoder(true).readList();
        assertEquals(list, result);
    }

    @Test
    public void testMapDecoding() throws IOException {
        Map<String, String> map = new TreeMap<>();
        map.put("keyA", "valueA");
        map.put("keyB", "valueB");
        bEncoder.writeMap(map);

        Map<String, Object> result = decoder(true).readMap();
        assertEquals(map, result);
    }
}
