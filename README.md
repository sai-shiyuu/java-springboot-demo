# Java + Spring boot Web Project Demo

This is a web application built using the Java programming language and Spring boot framework.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
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
## Features

- Protocol: http
- Database connection: MariaDB by Mybatis
- Cache: Redis
- Logging: log4j2
- Password encrypt: sha256
- Job: quartz(waitting)

## License

This project is just a demo.