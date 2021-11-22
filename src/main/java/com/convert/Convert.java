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
    public static FigmaText figmaText, figmaText2;
    public static FigmaInstance figmaInstance, buttonInstance;
    public static FigmaFrame frame1, frame2;
    public static Button button;
    public static Label label, label1;
    public static Edit edit;
    public static List<Button> buttonList = new ArrayList<>();
    public static List<Container> containerList = new ArrayList<>();
    public static List<Label> labelList = new ArrayList<>();
    public static List<Label> labelTextList = new ArrayList<>();
    public static List<Edit> editList = new ArrayList<>();
    public static List<FigmaInstance> figmaInstances = new ArrayList<>();

    public Convert() {
        setUIStyle(Settings.uiStyle);
        transformToObject();
    }

    @Override
    public void initUI() {
        createTotalCrossUI();
        setBackForeColors(Color.getRGB(frame1.getBackgroundColor().getR(), frame1.getBackgroundColor().getG(), frame1.getBackgroundColor().getB()), Color.WHITE);

        for (Button button : buttonList) {
            add(button, AFTER + (int) buttonInstance.getAbsoluteBoundingBox().getX(),
                    TOP + 38,
                    (int) buttonInstance.getAbsoluteBoundingBox().getWidth(),
                    (int) buttonInstance.getAbsoluteBoundingBox().getHeight());
        }

        int i = 0;
        for (Edit edit : editList) {
            Convert.edit = editList.get(i);
            add(edit, (int) figmaInstance.getAbsoluteBoundingBox().getX() * (-1),
                    (int) figmaInstance.getAbsoluteBoundingBox().getY() * (-1) + 39,
                    (int) figmaInstance.getAbsoluteBoundingBox().getWidth(),
                    (int) (figmaInstance.getAbsoluteBoundingBox().getHeight() - figmaText.getAbsoluteBoundingBox().getHeight()));
            i++;
        }

        for (Label label : labelList) {
            add(label, SAME, BEFORE);
        }

        i = 0;
        for (Label label : labelTextList) {
            if (i == 0) {
                add(label, LEFT + 31, AFTER + 50, edit);
                i++;
            } else {
                add(label, SAME, AFTER + 50);
            }
        }

        for (Container container : containerList) {
            add(container, CENTER, AFTER + 50,
                    (int) frame2.getAbsoluteBoundingBox().getWidth(),
                    (int) frame2.getAbsoluteBoundingBox().getHeight());
        }
    }

    public void transformToObject() {
        try {
            JSONObject response = connectToFigmaAPI();
            ObjectMapper objectMapper = new ObjectMapper();
            application = objectMapper.readValue(response.toString(), Application.class);
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

    public void createTotalCrossUI() {
        for (Node node : application.getDocument().getChildren()) {
            if (Objects.equals(node.getName(), "ExportFigma")) {
                exportFigma = node;
                for (Node node1 : exportFigma.getChildren()) {
                    frame1 = (FigmaFrame) node1;
                }
            }
        }

        for (Node node : frame1.getChildren()) {
            if (node.getClass().toString().contains("Instance")) {
                //cria instancia
                if (node.getName().equals("Button")) { // name : Button
                    for (Node instanceNode : node.getChildren()) {
                        buttonInstance = (FigmaInstance) node;
                        if (instanceNode.getName().equals("Button")) {
                            //cria button
                            figmaText = (FigmaText) instanceNode;
                            Button button = new Button(instanceNode.getName());
                            button.setFont(Font.getFont(figmaText.getStyle().getFontFamily(), true, figmaText.getStyle().getFontSize()));
                            button.setBackForeColors(Color.WHITE, Color.getRGB(frame1.getBackgroundColor().getR(), frame1.getBackgroundColor().getG(), frame1.getBackgroundColor().getB()));
                            button.setBorder(BORDER_ROUNDED);
                            button.roundBorderFactor = 2;
                            buttonList.add(button);
                        }
                    }
                } else if (node.getName().equals("Edit")) { // name : Edit
                    figmaInstance = (FigmaInstance) node;
                    figmaInstances.add(figmaInstance);
                    Edit edit = new Edit();
                    editList.add(edit);
                    for (Node instanceNode : figmaInstance.getChildren()) {
                        if (instanceNode.getClass().toString().contains("Text")) {
                            figmaText = (FigmaText) instanceNode;
                            //cria text
                            label = new Label(figmaText.getCharacters());
                            label.setFont(Font.getFont(figmaText.getStyle().getFontFamily(), true, figmaText.getStyle().getFontSize()));
                            label.setForeColor(Color.WHITE);
                            labelList.add(label);
                        }
                    }
                }
            } else if (node.getClass().toString().contains("Text")) {
                //cria text
                figmaText2 = (FigmaText) node;
                label1 = new Label(figmaText2.getCharacters());
                label1.setFont(Font.getFont(figmaText2.getStyle().getFontFamily(), true, figmaText2.getStyle().getFontSize()));
                label1.setFont(Font.getFont(figmaText2.getStyle().getFontFamily(), true, figmaText2.getStyle().getFontSize()));
                label1.setForeColor(Color.WHITE);
                labelTextList.add(label1);
            } else if (node.getClass().toString().contains("Frame")) {
                //cria frame
                frame2 = (FigmaFrame) node;
                Container container = new Container();
                container.setBackForeColors(Color.getRGB(frame2.getBackgroundColor().getR(), frame2.getBackgroundColor().getG(), frame2.getBackgroundColor().getB()),
                        Color.getRGB(frame2.getBackgroundColor().getR(), frame2.getBackgroundColor().getG(), frame2.getBackgroundColor().getB()));
                containerList.add(container);
            }
        }
    }
}