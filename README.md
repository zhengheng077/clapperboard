# Clapperboard - 录制视频用场记板

A command-line video recording clapperboard tool built with Maven and Java.

## Features

- Command-line executable JAR 
- Support for JDK 25 (currently configured for JDK 21 compatibility)
- Uses Lombok annotations including @Setter
- Chinese language support
- Customizable project information

## Building

```bash
mvn clean package
```

## Usage

Run the JAR with command line arguments:

```bash
java -jar target/clapperboard-1.0.0.jar [project_name] [scene_number] [take_number] [director]
```

### Examples

Default usage:
```bash
java -jar target/clapperboard-1.0.0.jar
```

Custom parameters:
```bash
java -jar target/clapperboard-1.0.0.jar "我的电影项目" "A001" "T003" "张导演"
```

## Requirements

- JDK 21 or higher (configured for JDK 25 compatibility)
- Maven 3.6+
