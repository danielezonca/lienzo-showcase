package org.roger600.lienzo.client;

import com.ait.lienzo.client.core.shape.Layer;

public class SimpleGridTests implements MyLienzoTest {

    @Override
    public void test(Layer layer) {
        final SimpleGrid simpleGrid = new SimpleGrid(new SimpleGrid.SimpleGridModel(), new SimpleGrid.SimpleGridLayer(), new SimpleGrid.SimpleGridRender());
        layer.add(simpleGrid);
    }

}
