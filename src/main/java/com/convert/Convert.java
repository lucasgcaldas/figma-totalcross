package com.convert;

import com.convert.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import totalcross.io.ByteArrayStream;
import totalcross.io.IOException;
import totalcross.json.JSONObject;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.ssl.SSLSocketFactory;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Convert extends MainWindow {

    public static Application application;
    public static Node exportFigma;
    public static FigmaText figmaText;
    public static FigmaFrame frame1, frame2;
    public static Button button;
    public static Label label;
    public static Edit edit;
    public static List<Button> buttonList = new ArrayList<>();
    public static List<Container> containerList = new ArrayList<>();
    public static List<Label> labelList = new ArrayList<>();
    public static List<Label> labelTextList = new ArrayList<>();
    public static List<Edit> editList = new ArrayList<>();

    public Convert() {
        setUIStyle(Settings.uiStyle);
        transformToObject();
    }

    @Override
    public void initUI() {
        createTotalCrossUIByType();
        setBackForeColors(Color.getRGB(frame1.getBackgroundColor().getR(), frame1.getBackgroundColor().getG(), frame1.getBackgroundColor().getB()), Color.WHITE);

        // Container 1
        add(containerList.get(0), CENTER, CENTER, (int) frame1.getAbsoluteBoundingBox().getWidth(), (int) frame1.getAbsoluteBoundingBox().getHeight());

        containerList.get(0).add(buttonList.get(0), AFTER + 26, TOP + 38, 151,50);
        containerList.get(0).add(buttonList.get(1), AFTER + 38, SAME, 151,50);

        int i = 0;
        for (Edit edit : editList) {
            Convert.edit = editList.get(i);
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
                containerList.get(0).add(label, LEFT + 31, AFTER + 50, edit);
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

    public void transformToObject() {
        try {
            JSONObject response = connectToFigmaAPI();
            ObjectMapper objectMapper = new ObjectMapper();
            application = objectMapper.readValue(response.toString(), Application.class);
            System.out.println();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public JSONObject connectToFigmaAPI() {
        String request = "";
        try {
            HttpStream.Options o = new HttpStream.Options();
            o.readTimeOut = 5000;
            o.socketFactory = new SSLSocketFactory();
            o.requestHeaders.put("X-FIGMA-TOKEN", "245245-fea25cdb-bcbc-4e70-a3af-1b18e5dfc1be");
            HttpStream hs = new HttpStream(new URI("https://api.figma.com/v1/files/nzNmkqqqgT5ZRe16StmZyR"), o);
            ByteArrayStream bas = new ByteArrayStream(4096);
            bas.readFully(hs, 10, 4096);
            hs.close();
            request = new String(bas.getBuffer(), 0, bas.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(request);
    }

    public void createTotalCrossUIByType() {
        for (Node node : application.getDocument().getChildren()) {
            if (Objects.equals(node.getName(), "ExportFigma")) {
                exportFigma = node;
                System.out.println();
                for (Node node1 : exportFigma.getChildren()) {
                    frame1 = (FigmaFrame) node1;
                    Container container = new Container();
                    containerList.add(container);
                }
            }
        }
        recursiveMethod(frame1);
    }

    public void recursiveMethod(Node frame1) {
        for (Node node : frame1.getChildren()) {
            switch (node.getType()) {
                case "FRAME":
                    switch (node.getName()) {
                        case "Frame 2":
                        case "Frame 3":
                            frame2 = (FigmaFrame) node;
                            Container container = new Container();
                            container.setBackForeColors(Color.getRGB(frame2.getBackgroundColor().getR(), frame2.getBackgroundColor().getG(), frame2.getBackgroundColor().getB()), Color.WHITE );
                            containerList.add(container);
                            recursiveMethod(node);
                            break;
                    }
                case "INSTANCE":
                    if (node.getName().equals("Button")) {
                        Button button = new Button(node.getName());
                        button.setFont(Font.getFont("Roboto-Medium", true, 18));
                        button.setBackForeColors(Color.WHITE, Color.getRGB(Convert.frame1.getBackgroundColor().getR(), Convert.frame1.getBackgroundColor().getG(), Convert.frame1.getBackgroundColor().getB()));
                        button.setBorder(BORDER_ROUNDED);
                        button.roundBorderFactor = 2;
                        buttonList.add(button);
                    } else if (node.getName().equals("Edit")) {
                        Edit edit = new Edit();
                        editList.add(edit);
                        recursiveMethod(node);
                    }
                case "TEXT":
                    if (node.getName().equals("TEXTO")) {
                        figmaText = (FigmaText) node;
                        label = new Label(figmaText.getCharacters());
                        label.setFont(Font.getFont(figmaText.getStyle().getFontFamily(), true, figmaText.getStyle().getFontSize()));
                        label.setForeColor(Color.WHITE);
                        labelTextList.add(label);
                    } else if (node.getName().equals("Label:")){
                        figmaText = (FigmaText) node;
                        label = new Label(figmaText.getCharacters());
                        label.setFont(Font.getFont(figmaText.getStyle().getFontFamily(), true, figmaText.getStyle().getFontSize()));
                        label.setForeColor(Color.WHITE);
                        labelList.add(label);
                    }
            }
        }
    }
}