# Android Mutation Testing

An example Android project showcasing mutation testing set up with [PIT](http://pitest.org/) and [Robolectric](http://robolectric.org/).

## UI

![Imgur](http://i.imgur.com/HCO5ShV.png)

The app consists of a single Activity with two `SeekBar`s each representing an angle. A label text below displays the currently greatest angle.

## Running unit tests

1. Import this project in Android Studio.
2. Create a new JUnit run configuration by selecting **Run > Edit Configurations**
3. Click on the `+` sign and choose **JUnit**
4. In the Name field write a name for your configuration (e.g. _All unit tests_).
5. In the Test kind field select **All in package**
6. In the Package field write the package name (e.g. _com.trifork.ckp.androidmutationtesting_).
7. Click **OK** and run your new test configuration..

## Running PIT mutation tests

`pitest` Gradle tasks will be created for each build variant. To run the task for all the variants (_debug_ and _release_) type the following on the command line:

```$ ./gradlew pitest
```

HTML reports will be placed in the `/app/build/reports/pitest/` directory. For more information see the [README for the gradle-pitest-plugin](https://github.com/koral--/gradle-pitest-plugin/blob/master/README.md).

## Libraries

 * [gradle-pitest-plugin](https://github.com/koral--/gradle-pitest-plugin) - experimental Gradle plugin by [koral--](https://github.com/koral--)
 * [Robolectric](http://robolectric.org/) - for unit testing Activity code 