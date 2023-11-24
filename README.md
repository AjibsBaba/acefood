# Acefood

Acefood helps people do more with your smartphone Camera by detecting up to 10 classes of diseases
in tomato plants, built with [Jetpack Compose](https://developer.android.com/jetpack/compose).

To try out this sample app, use the latest stable version
of [Android Studio](https://developer.android.com/studio).

### Status: 🚧 In progress 🚧

Acefood is still in the early stages of development, and as such only few screens has been created
so far. However most of the screen layouts has been implemented as well as custom theming.

## Screenshots

<img src="https://res.cloudinary.com/developerlomo/image/upload/v1697300249/portfolio/Acefood_k97jp2.png" alt="Screenshot">

## Features

This app contains 4 screens so far: the home screen, login screen, registration screen, password
reset screen and a screen to scan a plant.

### App scaffolding

Package [`com.ajibsbaba.acefood.ui`][1]

[`MainActivity.kt`][2] is the entry point of the app `Acefood`.

[`NavGraph.kt`][3] configures the navigation routes and actions in the app.

[`OnboardingManager.kt`][4] configures the onboarding screen logic for the app.


[1]: app/src/main/java/com/ajibsbaba/acefood

[2]: app/src/main/java/com/ajibsbaba/acefood/MainActivity.kt

[3]: app/src/main/java/com/ajibsbaba/acefood/navigation/NavGraph.kt

[4]: app/src/main/java/com/ajibsbaba/acefood/OnboardingManager.kt

## License

```
Copyright (c) 2023 Samuel Ajibade

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```