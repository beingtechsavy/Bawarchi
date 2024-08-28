# 🍲 Bawarchi - Recipe App

Bawarchi is a modern, stylish recipe app built using Jetpack Compose and the MVVM architecture. It seamlessly integrates with the MealDB API to fetch and display a wide variety of recipes. This project is a perfect example of the core concepts learned from Denis Panjuta, showcasing state management, UI building with Compose, and working with REST APIs.

## 📱 Features

- **Jetpack Compose**: A modern, declarative UI toolkit for Android.
- **MVVM Architecture**: Clean and maintainable code with separation of concerns.
- **MealDB Integration**: Fetch and display recipes from the MealDB API.
- **Search Functionality**: Easily search for recipes by name or ingredients.
- **Favorite Recipes**: Save your favorite recipes for quick access.
- **Dark Mode Support**: A beautifully designed dark mode for better user experience.
- **Offline Access**: Caching of recipes to access them even when offline.

## 🛠️ Tech Stack

- **Kotlin**: The programming language used for Android development.
- **Jetpack Compose**: For creating a modern, reactive UI.
- **MVVM (Model-View-ViewModel)**: Architecture pattern for separation of concerns.
- **Retrofit**: For making network calls to the MealDB API.
- **Room Database**: For local data storage and offline caching.
- **Coil**: For efficient image loading and caching.
- **Hilt**: For dependency injection.

## 🔧 Setup and Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/bawarchi.git
    cd bawarchi
    ```

2. **Open the project in Android Studio**:  
   Open Android Studio and select "Open an existing project". Navigate to the cloned repository.

3. **Build the project**:  
   Wait for the Gradle build to finish. If there are any dependencies to be resolved, Android Studio will prompt you.

4. **Run the app**:  
   Connect your Android device or use an emulator, then click the "Run" button in Android Studio.

## 🌐 API Key Configuration

To use the MealDB API, you need to configure the API key:

1. Go to the `res/values` folder and create a new file named `apikeys.xml`.
2. Add the following content to `apikeys.xml`:
    ```xml
    <resources>
        <string name="mealdb_api_key">YOUR_API_KEY_HERE</string>
    </resources>
    ```
   Replace `YOUR_API_KEY_HERE` with your actual MealDB API key.

## 🧩 Modules

- **app**: The main application module containing all the UI components, activities, and view models.
- **data**: Responsible for data management, including repositories and data sources.
- **network**: Contains all the networking logic for interacting with MealDB API.
- **di**: Dependency injection setup using Hilt.

## 💡 Lessons Learned

This project demonstrates the practical implementation of several core concepts:
- **Jetpack Compose**: Learning to build UIs with Compose components and managing state efficiently.
- **MVVM Architecture**: Understanding the importance of architecture patterns in Android development.
- **API Integration**: Working with REST APIs and handling asynchronous data fetching.
- **State Management**: Managing UI state in a declarative UI environment like Jetpack Compose.

## 📚 Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [MealDB API](https://www.themealdb.com/api.php)
- [MVVM Pattern](https://developer.android.com/jetpack/guide)

## 🙏 Acknowledgements

- A huge thank you to [Denis Panjuta](https://www.linkedin.com/in/denis-panjuta/) for his amazing tutorials and guidance.

## 📧 Contact

For any questions or feedback, please reach out at [arpanpadhi2004@gmail.com](mailto:arpanpadhi2004@gmail.com) or create an issue in the GitHub repository.

