**Notepad App**

A simple Notes Android app using a single activity and multiple fragments. The app includes Google Sign-In for user authentication, and notes are saved and managed for each user individually.



**Features**

Google Sign-In authentication

Add, update, delete, and display notes

Notes are stored locally using SQLite

Notes persist across logins

Single activity with multiple fragments

Logout functionality




**Technologies Used**

Programming Languages: Java, Kotlin

Frameworks: AndroidX, Firebase


**Libraries:**

AndroidX

Firebase Authentication

Room Persistence Library

Google Sign-In

Build Tools: Gradle with Kotlin DSL

User Interface: RecyclerView, ConstraintLayout, Data Binding, View Binding


**Installation**

To set up and run this project locally, follow these steps:

  **Prerequisites**
  
  Android Studio
  
  Firebase account
    
  **Steps**
  
  **1. Clone the repository:**
  
      git clone https://github.com/yourusername/notepad.git
      cd notepad

  **2. Open the project in Android Studio:**

      Open Android Studio.
      Select File > Open and choose the notepad project directory.

  **3. Set up Firebase:**

      Go to the Firebase Console.
      Create a new project or select an existing project.
      Add an Android app to your Firebase project.
      Follow the instructions to download the google-services.json file.
      Place the google-services.json file in the app/ directory of your project.
      (make sure you have your web client id configured in the json file)

  **5. Sync the project with Gradle:**

      In Android Studio, click on File > Sync Project with Gradle Files.
      
      Build and run the project:

      Connect an Android device or start an emulator.
      
      Click on Run > Run 'app' or press Shift + F10.



  
















