# What is this repository?

Auto-Scale supported `CoroutineDispatcher`.

# Example.

```kotlin
// Max 4 thread(min 0 thread).
// Kee-Alive 1 seconds. 
val dispatcher =
    FlexibleThreadPoolDispatcher.newDispatcher(4, 1, TimeUnit.SECONDS)

withContext(dispatcher) {
    // do something.
}
```

# How to Install

```groovy
// build.gradle
dependencies {
    implementation 'io.github.eaglesakura.flexible-thread-pool-dispatcher:flexible-thread-pool-dispatcher:${replace version}'
}
```
