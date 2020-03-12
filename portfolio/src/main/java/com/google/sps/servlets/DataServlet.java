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
import java.util.Arrays;
import com.google.gson.Gson;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;");
        //response.getWriter().println("<h1>Hello Thu!</h1>");
    
        ArrayList<String> listValues = new ArrayList<String>(); 
        //listValues.add("Comment 1");
        //listValues.add("Another comment number 2");
        //listValues.add("A 3rd comment for testing");

        Gson gson = new Gson();
        String json = gson.toJson(listValues);
        response.getWriter().println(json);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*// Get the input from the form.
        String text = getParameter(request, "text-input", "");
        //boolean someText = Boolean.parseBoolean(getParameter(request, "some-case", "false"));
       
        // Break the text into individual words.
        String[] words = text.split("\\s*,\\s*");

        //if (someText){}


        // Respond with the result.
            //response.setContentType("text/html;");
            //response.getWriter().println(Arrays.toString(words));
        // Redirect back to the HTML page.
        response.sendRedirect("/index.html");*/

        response.setContentType("application/json;");
        String text = getParameter(request, "text-input", "");
    
        ArrayList<String> listValues = new ArrayList<String>(); 
        if(text != ""){
            listValues.add(text);
        }

        Gson gson = new Gson();
        String json = gson.toJson(listValues);
        //response.getWriter().println(json);

        // Redirect back to the HTML page.
        response.sendRedirect("/form.html");

    }

    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
}


