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
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.gfx.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Convert extends MainWindow {

    public static Application application;
    public static Node exportFigma, frame1;
    public static FigmaText figmaText;
    public static FigmaInstance figmaInstance;
    public static FigmaFrame figmaFrame;
    private Button button;
    private Label label;
    private List<Button> buttonList = new ArrayList<>();
    private List<Label> labelList = new ArrayList<>();

    public Convert() {
        setUIStyle(Settings.MATERIAL_UI);
        transformToObject();
    }

    @Override
    public void initUI() {
        Label helloWord = new Label("Hello World!");
        add(helloWord, CENTER, CENTER);
        createTotalCrossUI();
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

    public void createTotalCrossUI() {
        for (Node node : application.getDocument().getChildren()) {
            if (Objects.equals(node.getName(), "ExportFigma")) {
                exportFigma = node;
                for (Node node1 : exportFigma.getChildren()) {
                    frame1 = node1;
                }
            }
        }

        for (Node node : frame1.getChildren()) {
//            System.out.println(node.getName() + " " + node.getClass().toString().substring(24));
            if (node.getClass().toString().contains("Instance")) {
                //cria instancia
                System.out.println("tem Instance");
                if (node.getName().equals("Button")) { // name : Button
                    for (Node instanceNode : node.getChildren()) {
                        if (instanceNode.getName().equals("Button")) {
                            //cria button
                            Button button = new Button(instanceNode.getName());
                            buttonList.add(button);
                            System.out.println("#tem button");
                        }
                    }
                } else if (node.getName().equals("Edit")) { // name : Edit
                    figmaInstance = (FigmaInstance) node;
                    Edit edit = new Edit();
                    edit.setBackColor(Color.WHITE);
//                    figmaInstance.getAbsoluteBoundingBox().getHeight();
//                    figmaInstance.getAbsoluteBoundingBox().getWidth();
//                    figmaInstance.getAbsoluteBoundingBox().getX();
//                    figmaInstance.getAbsoluteBoundingBox().getY();
//                    figmaInstance.getConstrains().getHorizontal();
//                    System.out.println(figmaInstance.getConstrains().getVertical());

                    for (Node instanceNode : node.getChildren()) {
                        if (instanceNode.getClass().toString().contains("Text")) {
                            figmaText = (FigmaText) instanceNode;
                            //cria text
                            Label label = new Label(figmaText.getCharacters());
                            System.out.println("#tem text");
                        }
                    }
                }
            } else if (node.getClass().toString().contains("Text")) {
                //cria text
                System.out.println("tem Text");
            } else if (node.getClass().toString().contains("Frame")) {
                //cria frame
                System.out.println("tem Frame");
            }
        }
    }
}