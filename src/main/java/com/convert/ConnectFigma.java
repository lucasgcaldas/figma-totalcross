package com.convert;

import com.convert.model.Application;
import com.convert.model.FigmaFrame;
import com.convert.model.FigmaText;
import com.convert.model.Node;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import totalcross.io.ByteArrayStream;
import totalcross.io.IOException;
import totalcross.json.JSONObject;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.ssl.SSLSocketFactory;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

import java.util.Objects;

public class ConnectFigma {

    /**
     * Method responsible for transform
     * the JSONObject to Java object
     */
    public void transformToObject() {
        try {
            JSONObject response = connectToFigmaAPI();
            ObjectMapper objectMapper = new ObjectMapper();
            Convert.application = objectMapper.readValue(response.toString(), Application.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method responsible to connect
     * this application to figma API
     *
     * @return JSONObject
     */
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

    /**
     * Method responsible to get only
     * the "export figma" frame
     */
    public void createTotalCrossUIByType() {
        for (Node node : Convert.application.getDocument().getChildren()) {
            if (Objects.equals(node.getName(), "ExportFigma")) {
                Convert.exportFigma = node;
                System.out.println();
                for (Node node1 : Convert.exportFigma.getChildren()) {
                    Convert.frame1 = (FigmaFrame) node1;
                    Container container = new Container();
                    Convert.containerList.add(container);
                }
            }
        }
        recursiveMethod(Convert.frame1);
    }

    /**
     * Method responsible for transform
     * all components from Figma API in
     * totalcross components
     */
    public void recursiveMethod(Node frame1) {
        for (Node node : frame1.getChildren()) {
            Label label;
            switch (node.getType()) {
                case "FRAME":
                    switch (node.getName()) {
                        case "Frame 2":
                        case "Frame 3":
                            Convert.frame2 = (FigmaFrame) node;
                            Container container = new Container();
                            container.setBackForeColors(Color.getRGB(Convert.frame2.getBackgroundColor().getR(), Convert.frame2.getBackgroundColor().getG(), Convert.frame2.getBackgroundColor().getB()), Color.WHITE );
                            Convert.containerList.add(container);
                            recursiveMethod(node);
                            break;
                    }
                case "INSTANCE":
                    if (node.getName().equals("Button")) {
                        Button button = new Button(node.getName());
                        button.setFont(Font.getFont("Roboto-Medium", true, 18));
                        button.setBackForeColors(Color.WHITE, Color.getRGB(Convert.frame1.getBackgroundColor().getR(), Convert.frame1.getBackgroundColor().getG(), Convert.frame1.getBackgroundColor().getB()));
                        button.roundBorderFactor = 2;
                        Convert.buttonList.add(button);
                    } else if (node.getName().equals("Edit")) {
                        Edit edit = new Edit();
                        Convert.editList.add(edit);
                        recursiveMethod(node);
                    }
                case "TEXT":
                    if (node.getName().equals("TEXTO")) {
                        Convert.figmaText = (FigmaText) node;
                        label = new Label(Convert.figmaText.getCharacters());
                        label.setFont(Font.getFont(Convert.figmaText.getStyle().getFontFamily(), true, Convert.figmaText.getStyle().getFontSize()));
                        label.setForeColor(Color.WHITE);
                        Convert.labelTextList.add(label);
                    } else if (node.getName().equals("Label:")){
                        Convert.figmaText = (FigmaText) node;
                        label = new Label(Convert.figmaText.getCharacters());
                        label.setFont(Font.getFont(Convert.figmaText.getStyle().getFontFamily(), true,Convert.figmaText.getStyle().getFontSize()));
                        label.setForeColor(Color.WHITE);
                        Convert.labelList.add(label);
                    }
            }
        }
    }
}
