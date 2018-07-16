package org.kie.grid.showcase.client;

import com.ait.lienzo.client.core.shape.Layer;

public class SimpleGreenGridTests implements MyLienzoTest,
                                             IsGrid {

    @Override
    public void test(Layer layer) {
        final SimpleGreenGrid simpleGrid = new SimpleGreenGrid(new SimpleGreenGrid.SimpleGridModel(), (SimpleGreenGrid.SimpleGridLayer) layer);
        layer.add(simpleGrid);
    }

    @Override
    public Layer getGrid() {
        return new SimpleGreenGrid.SimpleGridLayer();
    }
}
