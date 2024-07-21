# RepoAnalytics

RepoAnalytics es una herramienta Java para obtener información detallada de repositorios en GitHub utilizando la API pública de GitHub.

## Funcionalidades

- **Obtener información del repositorio:**
  - Nombre del repositorio
  - Número de estrellas

- **Obtener lenguajes utilizados en el repositorio:**
  - Lista de lenguajes y la cantidad de bytes de código escritos en cada uno.

- **Obtener colaboradores del repositorio:**
  - Lista de colaboradores
  - Cantidad de contribuciones de cada colaborador
  - Enlace al perfil de GitHub de cada colaborador

## Configuración

1. **Obtener un token de acceso a la API de GitHub:**
    - Crea un archivo `.env` en la raíz del proyecto y añade tu token de acceso:
     ```
     API_TOKEN=tu_token_de_acceso
     ```

2. **Ejecución del programa:**
   - Asegúrate de tener Java y Maven instalados en tu sistema.
   - Clona el repositorio y abre el proyecto en tu IDE favorito.

3. **Ejecuta el programa:**
   - Abre `Main.java` y modifica las variables `username` y `repoName` con el usuario y el nombre del repositorio que deseas analizar.

4. **Compila y ejecuta:**
![image](https://github.com/user-attachments/assets/ed58285a-9d95-44aa-a12c-624c4eb5d5fe)

# Dependencias

Maven: Utilizamos Maven para gestionar las dependencias del proyecto.

### English

# RepoAnalytics

RepoAnalytics is a Java tool to retrieve detailed repository information from GitHub using GitHub's public API.

## Features

- **Get repository information:**
  - Repository name
  - Number of stars

- **Get languages used in the repository:**
  - List of languages and the amount of code bytes written in each.

- **Get repository collaborators:**
  - List of collaborators
  - Number of contributions from each collaborator
  - Link to each collaborator's GitHub profile

## Setup

1. **Get a GitHub API access token:**
   - Create a `.env` file in the root of the project and add your access token:
     ```
     API_TOKEN=your_access_token
     ```

2. **Running the program:**
   - Make sure you have Java and Maven installed on your system.
   - Clone the repository and open the project in your favorite IDE.

3. **Run the program:**
   - Open `Main.java` and modify the `username` and `repoName` variables with the GitHub username and repository name you want to analyze.

4. **Compile and execute:**
![image](https://github.com/user-attachments/assets/ed58285a-9d95-44aa-a12c-624c4eb5d5fe)

# Dependencies
Maven: We use Maven to manage project dependencies.

