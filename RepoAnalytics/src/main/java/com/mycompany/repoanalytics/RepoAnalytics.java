package com.mycompany.repoanalytics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

import io.github.cdimascio.dotenv.Dotenv;

public class RepoAnalytics 
{
    // Cargar el archivo .env
    Dotenv dotenv = Dotenv.load();
    // Obtener el valor de la variable de entorno API_KEY
    String API_TOKEN = dotenv.get("API_TOKEN");

    public void getRepoLanguages(String username, String repoName) throws Exception 
    {
        try
        {
            String url = "https://api.github.com/repos/" + username + "/" + repoName + "/languages";

            // Obtener la respuesta de la API (reemplaza con tu solicitud HTTP real)
            String apiResponse = sendGetRequest(url);
            JSONObject languageData = new JSONObject(apiResponse);

            System.out.println("Language:");
            for (String language : languageData.keySet()) 
            {
                int bytesOfCode = languageData.getInt(language);
                System.out.println("- " + language + " " + bytesOfCode + " Bytes");
            }
            System.out.println("");
            
        } catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }

    public void getRepoCollaborators(String username, String repoName) 
    {
        try 
        {
            String url = "https://api.github.com/repos/" + username + "/" + repoName + "/contributors";

            String jsonResponse = sendGetRequest(url);
            JSONArray collaboratorsArray = new JSONArray(jsonResponse);

            System.out.println("Colaboradores:");
            for (int i = 0; i < collaboratorsArray.length(); i++) 
            {
                JSONObject collaborator = collaboratorsArray.getJSONObject(i);
                String login = collaborator.getString("login");
                String profileUrl = collaborator.getString("html_url");
                int contributions = collaborator.getInt("contributions");

                System.out.println("- User: " + login);
                System.out.println("  Contributions: " + contributions);
                System.out.println("  Profile: " + profileUrl);
                System.out.println();
            }
        } catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public void getRepoInfo(String username, String repoName) 
    {
        try 
        {
            String url = "https://api.github.com/repos/" + username + "/" + repoName;

            String jsonResponse = sendGetRequest(url);
            JSONObject repoInfo = new JSONObject(jsonResponse);
            
            System.out.println("Repository name: " + repoInfo.getString("name"));
            
            int stargazersCount = repoInfo.getInt("stargazers_count");
            System.out.println("Stars: " + stargazersCount);

            System.out.println("");
        } catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }

    private String sendGetRequest(String urlString) throws Exception 
    {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "token " + API_TOKEN);
        connection.setRequestProperty("Accept", "application/vnd.github.v3+json");

        int responseCode = connection.getResponseCode();
        
        if (responseCode != 200) 
        {
            throw new RuntimeException("Error al conectarnos a la API. Code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) 
        {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }
}
