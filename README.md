# [sample-htmx-javalin][00]

Sample application showing how htmx teams up with javalin

## Dependencies

- java 21
- kotlin 1.9
- jdbi 3.44
- htmx 2.x
- docker 25
- spock 2.3

A [good kotlin ide][10] is also recommended.

## How to build

we have [shadow jar plugin][20] to ease runnable jar creation

```bash
./gradlew shadowJar
```

## How to run

we have [application plugin][30] to ease runnable jar creation options

```bash
./gradlew run
```

alternatively, run the jar built in previous step:

```bash
java -jar build/libs/sample-htmx-javalin-1.0-SNAPSHOT-all.jar
```

## Noteworthy

- [Shadow plugin][20] does similar job done by [maven shade plugin][40]
- 

## Next steps

## Reference

[00]: https://github.com/sombriks/sample-htmx-javalin
[10]: https://www.jetbrains.com/idea/download
[20]: https://imperceptiblethoughts.com/shadow/getting-started/
[30]: https://docs.gradle.org/current/userguide/application_plugin.html
[40]: https://github.com/sombriks/sample-jdbi-javalin/blob/main/pom.xml
