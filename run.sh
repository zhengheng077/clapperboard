#!/bin/bash

# Clapperboard Runner Script
# Automatically detects and uses the correct Java version

JAR_FILE="target/clapperboard-1.0.0.jar"
REQUIRED_JAVA_VERSION=21

# Function to check if Java version is sufficient
check_java_version() {
    local java_cmd=$1
    if command -v "$java_cmd" >/dev/null 2>&1; then
        local version=$("$java_cmd" -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d'.' -f1-2)
        local major_version=$(echo "$version" | cut -d'.' -f1)
        # Handle Java 9+ versioning (major version is the first number)
        if [[ $major_version -ge $REQUIRED_JAVA_VERSION ]]; then
            return 0
        fi
    fi
    return 1
}

# Try different Java commands
JAVA_CMD=""
if check_java_version "java"; then
    JAVA_CMD="java"
elif check_java_version "/usr/lib/jvm/temurin-21-jdk-amd64/bin/java"; then
    JAVA_CMD="/usr/lib/jvm/temurin-21-jdk-amd64/bin/java"
elif check_java_version "/usr/lib/jvm/temurin-25-jdk-amd64/bin/java"; then
    JAVA_CMD="/usr/lib/jvm/temurin-25-jdk-amd64/bin/java"
fi

if [[ -z "$JAVA_CMD" ]]; then
    echo "Error: Java $REQUIRED_JAVA_VERSION or higher is required"
    echo "Please install Java $REQUIRED_JAVA_VERSION+ or set JAVA_HOME appropriately"
    exit 1
fi

if [[ ! -f "$JAR_FILE" ]]; then
    echo "Error: $JAR_FILE not found. Please run 'mvn clean package' first."
    exit 1
fi

echo "Using Java: $($JAVA_CMD -version 2>&1 | head -n 1)"
echo "Running Clapperboard..."
echo

"$JAVA_CMD" -jar "$JAR_FILE" "$@"