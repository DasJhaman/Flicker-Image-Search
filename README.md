# 📸 Flickr Search App

A Kotlin Multiplatform (KMP) application that allows users to search for photos using the Flickr API. The app follows modern development practices, including Jetpack Compose, MVVM architecture, and unit testing.

## 🚀 Features

-   **Search for Photos:** Search for photos using the Flickr API with various search terms.
-   **Grid Display:** Display search results in an aesthetically pleasing grid format.
-   **Search History:** Save and access your search history for quick re-access.
-   **Unit Tested:** Core components, including the repository, database, and utility functions, are thoroughly unit tested.

## 🛠️ Tech Stack

-   **Kotlin Multiplatform (KMP):** Shared logic across Android and other platforms.
-   **Jetpack Compose:** UI Toolkit for building native UI.
-   **Retrofit:** For networking and API calls.
-   **SQLDelight:** For local database storage.
-   **Kotlin Coroutines & Flow:** For asynchronous operations.
-   **Mokkery:** For unit testing.
-   **Kotlinx DateTime:** For date and time formatting.

## 🏛️ Architecture: MVVM with Clean Architecture

This application is built using a combination of the **MVVM (Model-View-ViewModel)** architectural pattern and **Clean Architecture** principles to create a robust, testable, and maintainable codebase. This approach ensures a clear separation of concerns and promotes a modular design.

### Core Principles

-   **Separation of Concerns:** Each part of the application has a specific responsibility, making the code easier to understand and modify.
-   **Testability:** The architecture facilitates unit testing of individual components in isolation.
-   **Maintainability:** The modular design makes it easier to update or replace parts of the application without affecting other parts.
-   **Independence:** The core business logic is independent of the UI and data sources.

### Layers

The application is divided into three main layers:

#### 1. Domain Layer

-   **Responsibilities:** Contains the core business logic and use cases of the application. It's the heart of the app and is independent of any external frameworks or UI.
-   **Components:**
    -   **Entities:** Represent the core business objects (e.g., `Photo`, `SearchQuery`).
    -   **Use Cases:** Define the specific actions that can be performed in the application (e.g., `SearchPhotosUseCase`, `GetAllSearchHistoryUseCase`). Use cases encapsulate the business rules.
    -   **Interfaces (Repositories):** Define contracts for interacting with the Data layer (e.g., `SearchRepository`).
-   **Benefits:**
    -   **Testability:** Business logic can be tested in isolation.
    -   **Flexibility:** Changes in the outer layers don't affect the core business logic.
    -   **Reusability:** Use cases can be reused by different parts of the application.

#### 2. Presentation Layer (MVVM)

-   **Responsibilities:** Handles the UI logic and user interactions. It's responsible for displaying data and responding to user events. This layer implements the MVVM pattern.
-   **Components:**
    -   **ViewModels:** Prepare data from the Domain layer (Use Cases) for the View and handle user input. They expose data streams (using Kotlin Flows) to the View.
    -   **UI (Jetpack Compose):** The actual UI components that display data and handle user interactions. The View observes data streams from the ViewModels and updates accordingly.
-   **Interactions:**
    -   ViewModels interact with Use Cases from the Domain layer to perform actions.
    -   The UI observes data streams from the ViewModels and updates accordingly.
- **MVVM:**
    - **Model:** The data and business logic provided by the Domain Layer.
    - **View:** The UI built with Jetpack Compose.
    - **ViewModel:** The intermediary between the View and the Model, preparing data and handling user input.

#### 3. Data Layer

-   **Responsibilities:** Handles data retrieval and storage, both from local and remote sources.
-   **Components:**
    -   **Repositories:** Implement the interfaces defined in the Domain layer. They abstract the data sources.
    -   **Data Sources:** Handle interactions with specific data sources (e.g., Retrofit for the Flickr API, SQLDelight for the local database).
    -   **Data Models:** Represent the data structures used by the data sources (e.g., API responses, database tables).
-   **Interactions:**
    -   Repositories interact with data sources to fetch or store data.
    -   The Domain layer interacts with Repositories to access data.


## 🔧 Setup & Installation

### 1. Clone the Repository
bash git clone https://github.com/DasJhaman/Flicker-Image-Search.git.

### 2. Open in Android Studio

-   Open Android Studio.
-   Select "Open" and navigate to the `flickr-search` directory you just cloned.
-   Wait for Gradle to sync and download all necessary dependencies. This might take a few minutes.

### 3. Configure API Keys

-   Create a file named `local.properties` in the root directory of your project (the same level as `build.gradle.kts`).
-   Add the following lines to `local.properties`, replacing `value` with your actual API key and parameters:


`SEARCH_METHOD=flickr.photos.search`

`API_KEY=value`

`API_BASE_URL=https://api.flickr.com/services/rest/`

**Note:** You'll need to obtain a Flickr API key from the Flickr website to use the API.

### 4. Run the App

-   Connect an Android emulator or a physical Android device to your computer.
-   In Android Studio, select the `androidApp` configuration.
-   Click the "Run" button (green play icon) to build and run the app on your selected device.

## 🧪 Unit Tests

The project includes unit tests for core functionalities:

### ✅ Repository Tests

-   **`SearchRepositoryTest`:** Tests API calls and search history storage.

### ✅ Utility Function Tests

-   **`DateTimeFormatterTest`:** Validates date formatting logic.

### ✅ Database Tests

-   **`SearchHistoryTableQueriesTest`:** Tests queries for storing and retrieving search history.

### How to Run Tests

-   Open the terminal in Android Studio.
-   Navigate to the root directory of the project.
-   Run the following command:
    bash ./gradlew testDebugUnitTest

## 📜 License

This project is licensed under the [MIT License](LICENSE).

## 🤝 Contribution

Contributions are welcome!

-   Feel free to open an issue to report bugs or suggest new features.
-   If you'd like to contribute code, please submit a pull request.
-   Make sure to update tests as appropriate when making changes.

---