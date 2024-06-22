package com.mycompany.repoanalytics;

public class Main 
{

    public static void main(String[] args) 
    {
        try {
            String username = "SebastianMayG", repoName = "MicroWeb";
            
            RepoAnalytics apiClient = new RepoAnalytics();
            
            // Obtener información del repositorio específico 
            apiClient.getRepoInfo(username, repoName);
            
            // Obtener lenguajes utilizados en el repositorio 
            apiClient.getRepoLanguages(username, repoName);
            
            // Obtener colaboradores del repositorio 
            apiClient.getRepoCollaborators(username, repoName);
        } catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }
}
