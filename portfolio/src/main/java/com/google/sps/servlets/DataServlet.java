// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");
        response.getWriter().println("<h1>Hello Thu!</h1>");
    
        ArrayList<String> listValues = new ArrayList<String>(); 
        listValues.add("Comment 1");
        listValues.add("Another comment number 2");
        listValues.add("A 3rd comment for testing");

        for(String element:listValues) {
            response.getWriter().println("<h3>" + element + "</h3>");
        }

        Gson gson = new Gson();
        String json = gson.toJson(listValues);

    }

    /*private String convertToJson(ArrayList<String> listValues) {
        String json = "{";
        
        for(String element:listValues) {
            json += "\"Comment\": ";
            json += "\"" + element + "\"";

            if(json.length() < (listValues.size() - 2))
                json += ", ";
        }

        json += "}";

        return json;
    }*/
}


