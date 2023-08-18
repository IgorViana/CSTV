# CSTV - CS:GO Matches (Android App)

CSTV is an Android app that provides a list of CS:GO matches taking place across various worldwide tournaments. Built using the MVVM (Model-View-ViewModel) architecture, CSTV offers a user-friendly interface for staying connected with the exciting world of CS:GO esports.

## Features

- **Splash Screen**: Initial Splash screen.
  ![Splash](https://github.com/IgorViana/CSTV/assets/38112268/4a60133a-59b5-4fbc-9315-b458cd2cca72)


- **List of Matches**: Screen with a list o matches.
  ![Main](https://github.com/IgorViana/CSTV/assets/38112268/92b563bd-4c41-41b7-b881-e32747d233f1)


- **Match Detail**: Screen of match details of a selected game.
  ![Detail](https://github.com/IgorViana/CSTV/assets/38112268/1c8f10ac-d386-493c-9ae1-ae20318f40a2)

## Installation

1. Clone this repository to your local machine using `git clone https://github.com/IgorViana/CSTV.git`
2. Open the project in Android Studio.
3. You may need to add a PandaScore apikey to your local.properties, like this: API_KEY = KEY, or add manually in your project to test
4. Build and run the app on an Android emulator or physical device.

## Technologies Used

- **MVVM Architecture**: CSTV is built using the MVVM (Model-View-ViewModel) architecture, promoting separation of concerns and maintainability.

- **Retrofit**: Use Retrofit to handle network requests and seamlessly fetch CS:GO match data from APIs.

- **OkHttp Interceptor**: Utilize OkHttp interceptors for adding logging and headers to network requests.

- **Gson**: Use Gson for efficient JSON serialization and deserialization of API responses.

- **Dagger Hilt**: Benefit from Dagger Hilt for dependency injection and managing app-level and activity-level components.

- **Compose Navigation**: Implement Jetpack Compose Navigation for seamless navigation between different screens.

- **Coroutines**: Utilize Kotlin Coroutines for managing asynchronous operations and background tasks.

- **Flow**: Use Kotlin Flow to handle reactive data streams and ensure a smooth user experience.

- **Coil**: Leverage Coil for efficient image loading and caching of team logos and match images.
