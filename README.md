# Java + Spring boot Web Project Demo

This is a web application built using the Java programming language and Spring boot framework.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Quartz Cron Expression](#quartz-cron-expression)
- [Features](#features)
- [License](#license)

## Installation

To install the project, clone the repository and navigate to the project directory:

```sh
git clone git@github.com:sai-shiyuu/java-springboot-demo.git
cd java-springboot-demo
```

First, download and install JDK21
https://www.oracle.com/java/technologies/downloads/#java21

extract
```sh
sudo tar -C /usr/local -xzf jdk-21_linux-x64_bin.tar.gz
```
Add to system env
```sh
sudo nvim /etc/profile
```
add the following script
```
export JAVA_HOME=/usr/local/jdk-21
export PATH=$PATH:$JAVA_HOME/bin
```
reboot system

Then, build the project:

```sh
./gradlew build
```

Run all tests
```sh
./gradlew test
```

## Usage

To run the application, execute the following command:

```sh
./gradlew bootRun
```

Open your web browser and navigate to `http://localhost:8080` to see the application in action.

API test file
```
test/java/com/hana/demo/request.http
```

To run the application in docker, execute the following command in project root:

```
docker build -t spring-demo .
docker run -p 8080:8080 -d spring-demo
```
## Quartz Cron Expression
Fields: Quartz cron expressions have 6 or 7 fields:

Seconds Minutes Hours Day-of-Month Month Day-of-Week [Year]

    Seconds: 0-59
    Minutes: 0-59
    Hours: 0-23
    Day-of-Month: 1-31
    Month: 1-12 or JAN-DEC
    Day-of-Week: 0-6 (Sunday = 0 or 7) or SUN-SAT
    Year: (Optional) - usually 4 digits

Special Characters: Quartz supports a wide range of special characters:

    *: All values
    ?: No specific value (used for Day-of-Month or Day-of-Week when one is specified)
    -: Range
    ,: List
    /: Increment
    L: Last day of the month or last specific day of the week in a month
    W: Nearest weekday to the specified day
    #: nth day of the week in a month

Example: 0 0 10 ? * MON-FRI (Every weekday at 10:00 AM)

## Features

- Protocol: http
- Database connection: MariaDB by Mybatis
- Cache: Redis
- Logging: log4j2
- Password encrypt: sha256
- Job: quartz

## License

This project is just a demo.