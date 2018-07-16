package org.kie.grid.showcase.client;

import com.ait.lienzo.client.core.shape.Layer;

public class SimpleRedGridTests implements MyLienzoTest,
                                           IsGrid {

    @Override
    public void test(Layer layer) {
        final SimpleRedGrid simpleGrid = new SimpleRedGrid(new AbstractSimpleGrid.SimpleGridModel(), (AbstractSimpleGrid.SimpleGridLayer) layer);
        layer.add(simpleGrid);
    }

    @Override
    public Layer getGrid() {
        return new SimpleGreenGrid.SimpleGridLayer();
    }
}
