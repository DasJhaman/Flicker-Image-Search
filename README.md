📸 Flickr Search App

A Kotlin Multiplatform (KMP) application that allows users to search for photos using the Flickr API. The app follows modern development practices, including Jetpack Compose, MVVM architecture, and unit testing.

🚀 Features

Search for photos using the Flickr API

Display search results in a grid format

View image details

Save search history

Unit tested repository, database, and utility functions

🛠️ Tech Stack

Kotlin Multiplatform (KMP) - Shared logic across Android & other platforms

Jetpack Compose - UI Toolkit for building native UI

Retrofit - For networking and API calls

SQLDelight - For local database storage

Kotlin Coroutines & Flow - For asynchronous operations

MockK - For unit testing

Kotlinx DateTime - For date and time formatting

🔧 Setup & Installation

1️⃣ Clone the Repository

git clone https://github.com/your-repo/flickr-search.git
cd flickr-search

2️⃣ Open in Android Studio

Open this directory in Android Studio.

Wait for Gradle to sync dependencies.

3️⃣ Configure API Keys

Add the following values to your local.properties file:

SEARCH_METHOD=value
API_KEY=value
API_BASE_URL=https://api.flickr.com/services/rest/

Please replace value with original value.

4️⃣ Run the App

Build & Run the app on an emulator or physical device.

🧪 Unit Tests

The project includes unit tests for core functionalities:

✅ Repository Tests

SearchRepositoryTest - Tests API calls and search history storage.

✅ Utility Function Tests

DateTimeFormatterTest - Validates date formatting logic.

✅ Database Tests

SearchHistoryTableQueriesTest - Tests queries for storing and retrieving search history.

Run tests using:

gradlew testDebugUnitTest

📜 License

This project is licensed under the MIT License.

🤝 Contribution

Contributions are welcome! Feel free to open an issue or submit a pull request.