package com.ns.tm.charting;


import ca.weblite.codename1.components.charts.Chart;
import ca.weblite.codename1.components.charts.ChartBuilder;
import ca.weblite.codename1.components.charts.ChartView;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;

public class ChartingApp {
   
    private Form current;

    public void init(Object context) {
    }

    public void start() {
        
        Form f = new Form();
        final Label l = new Label("Loading Chart....pls wait");
        f.setLayout(new BorderLayout());
        ChartBuilder b = new ChartBuilder();
        Chart chart = b.newBarChart(
                new double[][]{
                    {1, 3, 2, 5},
                    {3, 1, 2, 4},
                    {7, 4, 1, 6},
                    {2, 3, 4, 1}
                },
                new String[]{"BC", "Alberta", "Ontario", "Saskatchewan"},
                new String[]{"June", "July", "August", "Sept"}
        );
        ChartView v = new ChartView(chart);
        v.initLater(new Runnable() {

            public void run() {
                l.setText("Chart loaded!");

            }
        });

       

        f.addComponent(BorderLayout.CENTER, v);
        f.addComponent(BorderLayout.NORTH, l);
        f.show();
        
//        if(current != null){
//            current.show();
//            return;
//        }
//        new StateMachine("/theme");        
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }
}
