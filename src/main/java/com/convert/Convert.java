package com.convert;

import com.convert.model.Application;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import totalcross.io.ByteArrayStream;
import totalcross.io.IOException;
import totalcross.json.JSONObject;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.ssl.SSLSocketFactory;
import totalcross.sys.Settings;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;

public class Convert extends MainWindow {

    public static Application application;

    public Convert() {
        setUIStyle(Settings.MATERIAL_UI);
        transformToObject();
    }

    @Override
    public void initUI() {
        Label helloWord = new Label("Hello World!");
        add(helloWord, CENTER, CENTER);
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
}