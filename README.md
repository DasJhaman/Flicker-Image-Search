Flickr Image Search App

📌 Overview

This is a Kotlin Multiplatform (KMP) application that allows users to search for images using the Flickr API and displays results in a scrollable grid. The app also maintains a search history, enabling users to revisit previous searches.

✨ Features

🔍 Image Search: Users can search for images using the Flickr API.

📜 Search History: Previous searches are saved and can be accessed later.

📷 Image Grid View: Display search results in a beautiful, scrollable grid using Jetpack Compose.

🛠 Offline Persistence: Search history is stored using SQLDelight.

📡 Networking with Ktor: Handles API requests and responses efficiently.

🏗 MVVM Clean Architecture: Ensures separation of concerns for scalability and maintainability.

🚀 Multiplatform Support: Built using Compose Multiplatform, making it adaptable for different platforms.

🏛 Architecture

This project follows MVVM Clean Architecture, which is divided into three main layers:

1️⃣ Data Layer

This layer is responsible for data handling and consists of:

Repositories: Serve as a bridge between the data sources and the domain layer.

Data Sources: Handle API calls using Ktor and local database interactions with SQLDelight.

Models: Define data structures using Kotlin Serialization.

2️⃣ Domain Layer

This layer is independent of any framework and consists of:

Use Cases: Business logic that acts as an intermediary between the repository and the presentation layer.

Repository Interfaces: Define the contract for data handling, implemented by the data layer.

3️⃣ Presentation Layer

This layer is responsible for UI and consists of:

ViewModel (MVVM Pattern): Uses Koin for Dependency Injection and exposes state for UI.

Jetpack Compose UI: Implements the UI using Compose Multiplatform, ensuring a reactive and declarative approach.

State Management: Follows a unidirectional data flow pattern.

🏗 Tech Stack

Tech

Purpose

Kotlin Multiplatform (KMP)

Enables code-sharing across platforms

Compose Multiplatform

UI framework for a reactive and declarative UI

Ktor

Networking library for API requests

Kotlin Serialization

JSON parsing and serialization

Koin

Dependency injection framework

SQLDelight

Local database for storing search history

BuildKonfig

Embeds API keys and configuration from Gradle

Version Catalogs

Manages dependencies efficiently

🔧 Setup & Installation

Prerequisites:

Android Studio Giraffe (or later)

Kotlin Multiplatform Plugin

Steps to Run:

Clone this repository:

git clone <repo-url>

Open the project in Android Studio.

Sync Gradle dependencies.

Run the app on an emulator or a physical device.

🚀 Run the App

Open this directory in Android Studio.

Wait for Gradle to sync dependencies.

Add the following values to your local.properties file:

SEARCH_METHOD=value
API_KEY=value
API_BASE_URL=https://api.flickr.com/services/rest/

Please replace value with your real value.

Build & run the app.

📂 Project Structure

📂 app/
┣ 📂 data/       # Data sources (API, Database, Models)
┣ 📂 domain/     # Business logic and Use Cases
┣ 📂 presentation/  # ViewModel & UI (Jetpack Compose)
┣ 📂 di/         # Dependency Injection (Koin)

🧪 Testing

The project includes unit tests for critical functionalities:

Repository Tests: Verifies data retrieval and caching mechanisms.

Database Tests: Validates queries and persistence using SQLDelight.

Utility Function Tests: Ensures helper functions work as expected.

To run tests, execute:

./gradlew test

🎯 Improvements & Future Enhancements

✅ Paging for Infinite Scroll

✅ Dark Mode Support

✅ Better Error Handling

✅ Platform-Specific UI Customization

🤝 Credits

Developed by Jhaman 🚀

If you have any questions, feel free to reach out!

📜 License

This project is licensed under the MIT License.