package com.prithu.simw.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.extensions.model.layout.LayoutOptions;

@RequestScoped
@Named
public class MainLayout implements Serializable {

    private LayoutOptions layoutOptions;

    @PostConstruct
    protected void initialize() {
        layoutOptions = new LayoutOptions();

        // for all panes
        LayoutOptions panes = new LayoutOptions();
        panes.addOption("resizable", true);
        panes.addOption("closable", true);
        panes.addOption("slidable", false);
        panes.addOption("spacing", 4);
        panes.addOption("resizeWithWindow", false);
        panes.addOption("resizeWhileDragging", true);
        layoutOptions.setPanesOptions(panes);

        // north pane
        LayoutOptions north = new LayoutOptions();
        north.addOption("resizable", true);
        north.addOption("closable", true);
        north.addOption("size", 40);
        north.addOption("spacing_open", 0);
        layoutOptions.setNorthOptions(north);

        // south pane
        LayoutOptions south = new LayoutOptions();
        south.addOption("resizable", false);
        south.addOption("closable", false);
        south.addOption("size", 28);
        south.addOption("spacing_open", 0);
        layoutOptions.setSouthOptions(south);

        // center pane
        LayoutOptions center = new LayoutOptions();
        center.addOption("resizable", false);
        center.addOption("closable", false);
        center.addOption("resizeWhileDragging", false);
        center.addOption("minWidth", 200);
        center.addOption("minHeight", 60);
        layoutOptions.setCenterOptions(center);

        // west pane
        LayoutOptions west = new LayoutOptions();
        west.addOption("size", 210);
        west.addOption("minSize", 180);
        west.addOption("maxSize", 350);
        west.addOption("initClosed", true);
        layoutOptions.setWestOptions(west);

        // east pane
        LayoutOptions east = new LayoutOptions();
        east.addOption("size", 210);
        east.addOption("minSize", 185);
        east.addOption("maxSize", 350);
        east.addOption("initClosed", true);
        layoutOptions.setEastOptions(east);
    }

    /**
     *
     * @return
     */
    public LayoutOptions getLayoutOptions() {
        return layoutOptions;
    }

    /**
     *
     * @param layoutOptions
     */
    public void setLayoutOptions(LayoutOptions layoutOptions) {
        this.layoutOptions = layoutOptions;
    }

}
