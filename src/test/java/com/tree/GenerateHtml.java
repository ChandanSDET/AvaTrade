package com.tree;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.*;

public class GenerateHtml {

  public static void main(String[] args) {
    List<String> time =  new ArrayList<>();
    time.add("13-May-24 04.02 PM");
    time.add("13-May-24 04.07 PM");
    time.add("13-May-24 04.12 PM");
    time.add("13-May-24 04.02 PM");
    time.add("13-May-24 04.07 PM");
    time.add("13-May-24 04.12 PM");
    time.add("13-May-24 04.02 PM");
    time.add("13-May-24 04.07 PM");
    time.add("13-May-24 04.12 PM");
    List<String> result =  new ArrayList<>();
    result.add("Pass");
    result.add("Fail");
    result.add("Pass");
    result.add("Pass");
    result.add("Fail");
    result.add("Pass");
    result.add("Pass");
    result.add("Fail");
    result.add("Pass");

    List<JSONObject> lsmp = new ArrayList<>();

    for(int i = 0 ; i<time.size();i++){
      JSONObject m = new JSONObject();
      m.put("Time",time.get(i));
      m.put("Result", result.get(i));
      lsmp.add(m);
    }
    System.out.println(lsmp);

    try {
      FileWriter file = new FileWriter(new File("data.json"), false );
      file.write(lsmp.toString());
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder buf = new StringBuilder();
    buf.append("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<style>\n" +
            "      table, th, tr, td{\n" +
            "      border:1px solid black\n" +
            "      }\n" +
            "      #collapse1{\n" +
            "      overflow-y:scroll;\n" +
            "      height:300px;\n" +
            "      tr:nth-child(even) {\n" +
            "      background-color: #E9EAEC;\n" +
            "      }\n" +
            "td{text-align:center}"+
            "\n" +
            "   </style>\n" +
            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
            "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
            "<head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">\n" +
            "  <h2>Collapsible List with table</h2>\n" +
            "  <div class=\"panel-group\">\n" +
            "    <div class=\"panel panel-default\">\n" +
            "      <div class=\"panel-heading\">\n" +
            "        <h4 class=\"panel-title\">\n" +
            "          <a data-toggle=\"collapse\" href=\"#collapse1\">Collapsible list group with table</a>\n" +
            "        </h4>\n" +
            "      </div>\n" +
            "      <div id=\"collapse1\" class=\"panel-collapse collapse\">\n" +
            "        <table class=\"table\">\n" +
            "          <thead>\n" +
            "          <tr>\n" +
            "            <th bgcolor=\"#87CEFA\" style=\"text-align:center;width:30%\">Timings</th>\n" +
            "            <th bgcolor=\"#87CEFA\" style=\"text-align:center;width:30%\">Result</th>\n" +
            "          </tr>\n" +
            "          </thead>\n" +
            "          <tbody>");
    for (int i = 0; i < time.size(); i++) {
      if(result.get(i).equals("Pass")) {
        buf.append("<tr><td>")
                .append(time.get(i))
                .append("</td><td  style=\"background-color:MediumSeaGreen;\">")
                .append(result.get(i))
                .append("</td>");
      }else{
        buf.append("<tr><td>")
                .append(time.get(i))
                .append("</td><td  style=\"background-color:Tomato;\">")
                .append(result.get(i))
                .append("</td>");
      }
    }
    buf.append("</tbody>\n" +
            "        </table>\n" +
            "      </div>\n" +
            "      <h4>Total Up Time: </h4>\n" +
                   "<h4>Total Down Time: </h4>"+
            "    </div>\n" +
            "  </div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>");
    String html = buf.toString();;
    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    // LocalDateTime now = LocalDateTime.now();
    // System.out.println(dtf.format(now));

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm aa");
    String formattedDate = dateFormat.format(new Date()).toString();
    System.out.println(formattedDate.toString());
    System.out.println(formattedDate.toString().split(" ")[0]);
    System.out.println(formattedDate.toString().split(" ")[1]+ " "+ formattedDate.toString().split(" ")[2]);
    File f = new File(System.getProperty("user.dir")+"/src/main/resources/test.html");


    try{
      BufferedWriter bw = new BufferedWriter(new FileWriter(f));
      bw.write(html);
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
