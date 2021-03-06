package org.kie.grid.showcase.client;

import java.util.List;
import java.util.Optional;

import com.ait.lienzo.client.core.types.Point2D;
import com.ait.lienzo.client.core.types.Transform;
import org.kie.grid.client.model.GridCellValue;
import org.kie.grid.client.model.impl.BaseGridCell;
import org.kie.grid.client.model.impl.BaseGridCellValue;
import org.kie.grid.client.model.impl.BaseGridColumn;
import org.kie.grid.client.model.impl.BaseGridData;
import org.kie.grid.client.model.impl.BaseGridRow;
import org.kie.grid.client.model.impl.BaseHeaderMetaData;
import org.kie.grid.client.widget.context.GridBodyCellEditContext;
import org.kie.grid.client.widget.context.GridBodyCellRenderContext;
import org.kie.grid.client.widget.grid.impl.BaseGridWidget;
import org.kie.grid.client.widget.grid.renderers.columns.GridColumnRenderer;
import org.kie.grid.client.widget.grid.renderers.columns.impl.StringColumnRenderer;
import org.kie.grid.client.widget.grid.renderers.grids.GridRenderer;
import org.kie.grid.client.widget.grid.renderers.grids.impl.BaseGridRenderer;
import org.kie.grid.client.widget.grid.renderers.themes.GridRendererTheme;
import org.kie.grid.client.widget.layer.impl.DefaultGridLayer;
import org.kie.grid.client.widget.layer.impl.GridLienzoPanel;

public abstract class AbstractSimpleGrid extends BaseGridWidget {

    public AbstractSimpleGrid(SimpleGridModel model, SimpleGridLayer gridLayer, GridRenderer renderer) {
        super(model, gridLayer, gridLayer, renderer);
        model.appendColumn(new SimpleGridColumn(new SimpleHeaderMetaData("T"), new SimpleGridColumnRender(), 100));
        model.appendColumn(new SimpleGridColumn(new SimpleHeaderMetaData(""), new SimpleGridColumnRender(), 100));
        model.appendColumn(new SimpleGridColumn(new SimpleHeaderMetaData("Column 1"), new SimpleGridColumnRender(), 100));
        model.appendColumn(new SimpleGridColumn(new SimpleHeaderMetaData("Column 2"), new SimpleGridColumnRender(), 100));

        model.appendRow(new SimpleGridRow());
        model.appendRow(new SimpleGridRow());
//        model.appendRow(new SimpleGridRow());

        model.setCell(0, 0, () -> new SimpleGridCell(new SimpleGridCellValue("T")));
        model.setCell(0, 1, () -> new SimpleGridCell(new SimpleGridCellValue("")));
        model.setCell(0, 2, () -> new SimpleGridCell(new SimpleGridCellValue("Cell 1")));
        model.setCell(0, 3, () -> new SimpleGridCell(new SimpleGridCellValue("Cell 2")));

        model.setCell(1, 0, () -> new SimpleGridCell(new SimpleGridCellValue("1")));
        model.setCell(1, 1, () -> new SimpleGridCell(new SimpleGridCellValue("Simple Description")));
        model.setCell(1, 2, () -> new SimpleGridCell(new SimpleGridCellValue("1")));
        model.setCell(1, 3, () -> new SimpleGridCell(new SimpleGridCellValue("2")));
    }

    public static class SimpleGridModel extends BaseGridData {

        public SimpleGridModel() {
            super();
        }

        public SimpleGridModel(boolean isMerged) {
            super(isMerged);
        }
    }

    public static class SimpleGridLayer extends DefaultGridLayer {

        public SimpleGridLayer() {
            super();
        }
    }

    public static class SimpleGridRender extends BaseGridRenderer {

        public SimpleGridRender(GridRendererTheme theme) {
            super(theme);
        }
    }

    public static class SimpleGridRow extends BaseGridRow {

        public SimpleGridRow() {
            super();
        }

        public SimpleGridRow(double height) {
            super(height);
        }
    }

    public static class SimpleGridCell extends BaseGridCell<String> {

        public SimpleGridCell(GridCellValue<String> value) {
            super(value);
        }
    }

    public static class SimpleGridCellValue extends BaseGridCellValue<String> {

        public SimpleGridCellValue(String value) {
            super(value);
        }
    }

    public static class SimpleGridColumn extends BaseGridColumn<String> {

        public SimpleGridColumn(HeaderMetaData headerMetaData, GridColumnRenderer<String> columnRenderer, double width) {
            super(headerMetaData, columnRenderer, width);
        }

        public SimpleGridColumn(List<HeaderMetaData> headerMetaData, GridColumnRenderer<String> columnRenderer, double width) {
            super(headerMetaData, columnRenderer, width);
        }
    }

    public static class SimpleGridColumnRender extends StringColumnRenderer {

    }

    public static class SimpleGridBodyCellRenderContext extends GridBodyCellRenderContext {

        public SimpleGridBodyCellRenderContext(double absoluteCellX, double absoluteCellY, double cellWidth, double cellHeight, double clipMinY, double clipMinX, int rowIndex, int columnIndex, boolean isFloating, Transform transform, GridRenderer renderer) {
            super(absoluteCellX, absoluteCellY, cellWidth, cellHeight, clipMinY, clipMinX, rowIndex, columnIndex, isFloating, transform, renderer);
        }
    }

    public static class SimpleGridBodyCellEditContext extends GridBodyCellEditContext {

        public SimpleGridBodyCellEditContext(double absoluteCellX, double absoluteCellY, double cellWidth, double cellHeight, double clipMinY, double clipMinX, int rowIndex, int columnIndex, boolean isFloating, Transform transform, GridRenderer renderer, Optional<Point2D> relativeLocation) {
            super(absoluteCellX, absoluteCellY, cellWidth, cellHeight, clipMinY, clipMinX, rowIndex, columnIndex, isFloating, transform, renderer, relativeLocation);
        }
    }

    public static class SimpleHeaderMetaData extends BaseHeaderMetaData {

        public SimpleHeaderMetaData(String columnTitle) {
            super(columnTitle);
        }

        public SimpleHeaderMetaData(String columnTitle, String columnGroup) {
            super(columnTitle, columnGroup);
        }
    }

    public static class SimpleGridPanel extends GridLienzoPanel {

        public SimpleGridPanel() {
            super();
        }

        public SimpleGridPanel(int width, int height) {
            super(width, height);
        }
    }
}
