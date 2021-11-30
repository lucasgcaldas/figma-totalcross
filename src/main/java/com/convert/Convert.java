package com.convert;

import com.convert.model.Application;
import com.convert.model.FigmaFrame;
import com.convert.model.FigmaText;
import com.convert.model.Node;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that extends MainWindow
 * responsible for convert the code
 * in totalcross UI
 * @author Lucas Gomes
 */
public class Convert extends MainWindow {

    public static Application application;
    public static Node exportFigma;
    public static FigmaText figmaText;
    public static FigmaFrame frame1, frame2;
    public static List<Button> buttonList = new ArrayList<>();
    public static List<Container> containerList = new ArrayList<>();
    public static List<Label> labelList = new ArrayList<>();
    public static List<Label> labelTextList = new ArrayList<>();
    public static List<Edit> editList = new ArrayList<>();
    ConnectFigma connectFigma = new ConnectFigma();

    /**
     * Convert constructor setting
     * the UI style and getting connect
     * to method transformToObject
     */
    public Convert() {
        setUIStyle(Settings.uiStyle);
        connectFigma.transformToObject();
    }

    /**
     * Method responsible for add all
     * components in screen
     */
    @Override
    public void initUI() {
        connectFigma.createTotalCrossUIByType();
        setBackForeColors(Color.getRGB(frame1.getBackgroundColor().getR(), frame1.getBackgroundColor().getG(), frame1.getBackgroundColor().getB()), Color.WHITE);

        // Container 1
        add(containerList.get(0), CENTER, CENTER, (int) frame1.getAbsoluteBoundingBox().getWidth(), (int) frame1.getAbsoluteBoundingBox().getHeight());
        for (Button button : buttonList){
            button.setBorder(BORDER_ROUNDED);
        }
        containerList.get(0).add(buttonList.get(0), AFTER + 26, TOP + 38, 151,50);
        containerList.get(0).add(buttonList.get(1), AFTER + 38, SAME, 151,50);

        int i = 0;
        for (Edit edit : editList) {
            edit = editList.get(i);
            containerList.get(0).add(edit, LEFT + 101,
                    TOP + 147,
                    169,
                    38);
            i++;
        }

        for (Label label : labelList) {
            containerList.get(0).add(label, SAME, BEFORE);
        }

        i = 0;
        for (Label label : labelTextList) {
            if (i == 0) {
                containerList.get(0).add(label, LEFT + 31, AFTER + 50);
                i++;
            } else {
                containerList.get(0).add(label, SAME, AFTER + 50);
            }
        }

        // Container 2
        add(containerList.get(1), LEFT + 40, TOP + 334, 320, 280);
        containerList.get(1).add(buttonList.get(2), LEFT + 26, TOP + 38, 151, 50);

        // Container 3
        containerList.get(1).add(containerList.get(2), LEFT, TOP + 124, 320, 119);
        containerList.get(2).add(buttonList.get(3), LEFT + 26, TOP + 38, 151, 50);
    }
}