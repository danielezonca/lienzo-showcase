package org.kie.grid.showcase.client;

import com.ait.lienzo.client.core.mediator.EventFilter;
import com.ait.lienzo.client.core.mediator.IEventFilter;
import com.ait.lienzo.client.core.shape.Layer;
import com.ait.lienzo.client.widget.LienzoPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LienzoTests implements EntryPoint {

    public static final int WIDE = 1200;
    public static final int HIGH = 900;

    private final IEventFilter[] zommFilters = new IEventFilter[]{EventFilter.CONTROL};
    private final IEventFilter[] panFilters = new IEventFilter[]{EventFilter.SHIFT};

    private final static MyLienzoTest[] TESTS = new MyLienzoTest[]{
            new SimpleGreenGridTests(),
            new SimpleRedGridTests(),
    };

    private static final int MAX_BUTTONS_ROW = 7;
    private VerticalPanel mainPanel = new VerticalPanel();
    private VerticalPanel buttonsPanel = new VerticalPanel();
    private HorizontalPanel screenButtonsPanel = new HorizontalPanel();
    private HorizontalPanel buttonsRowPanel;
    private int buttonsPanelSize = 0;
    private FlowPanel testsPanel = new FlowPanel();

    public void onModuleLoad() {
        buttonsPanel.getElement().getStyle().setMargin(10, Style.Unit.PX);

        RootPanel.get().add(mainPanel);

        for (final MyLienzoTest test : TESTS) {

            final Button button = new Button(test.getClass().getSimpleName());
            button.addClickHandler(clickEvent -> createPanelForTest(test));

            addButton(button);
        }

        mainPanel.add(buttonsPanel);
        mainPanel.add(screenButtonsPanel);
        mainPanel.add(testsPanel);
    }

    private void createPanelForTest(MyLienzoTest test) {

        screenButtonsPanel.clear();
        testsPanel.clear();
//        testsPanel.getElement().getStyle().setMargin(10, Style.Unit.PX);
//        testsPanel.getElement().getStyle().setBorderWidth(1, Style.Unit.PX);
//        testsPanel.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
//        testsPanel.getElement().getStyle().setBorderColor("#000000");

        final LienzoPanel panel = new LienzoPanel(WIDE,
                                                  HIGH);
        Layer layer;
        if (test instanceof IsGrid) {
            layer = ((IsGrid) test).getGrid();
        } else {
            layer = new Layer();
        }

        testsPanel.add(panel);
        layer.setTransformable(true);
        panel.add(layer);

        test.test(layer);

        layer.draw();
    }

    private void addButton(final Button button) {

        if (buttonsPanelSize >= MAX_BUTTONS_ROW) {

            buttonsPanelSize = 0;
            buttonsRowPanel = null;
        }

        if (null == buttonsRowPanel) {
            buttonsRowPanel = new HorizontalPanel();
            buttonsPanel.add(buttonsRowPanel);
        }

        buttonsRowPanel.add(button);
        buttonsPanelSize++;
    }
}
