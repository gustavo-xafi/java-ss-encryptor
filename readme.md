# Excel Encryptor



## Overview



Excel Encryptor is a Java-based application designed to read and manipulate Excel spreadsheets. It includes functionality for encrypting and decrypting data using RSA and AES encryption algorithms.



## Features



- Read and manipulate Excel spreadsheets using Apache POI.

- Generate RSA and AES keys for encryption and decryption.

- Encrypt and decrypt data using the generated keys.



## Project Structure



The project is organized as follows:



```plaintext

app

├── build.gradle.kts

├── src

│   ├── main

│   │   └── java

│   │       └── org

│   │           └── excelencryptor

│   │               ├── App.java

│   │               ├── ConfidentialKeys.java

│   │               ├── ExcelReader.java

│   │               ├── KeysEncryptor.java

│   │               ├── KeysGenerator.java

│   │               └── Person.java

│   └── test

│       └── java

│           └── org

│               └── excelencryptor

│                   ├── AppTest.java

│                   ├── ConfidentialKeysTest.java

│                   ├── ExcelReaderTest.java

│                   ├── KeysGeneratorTest.java

│                   └── PersonTest.java

└── readme.md

```



## Dependencies



- Java 17

- Apache POI 5.2.3

- JUnit 5



## Getting Started



### Prerequisites



- Java 17

- Gradle



### Building the Project



To build the project, run the following command:



```sh

./gradlew build

```



### Running the Application



To run the application, use the following command:



```sh

./gradlew run

```



### Running Tests



To run the tests, use the following command:



```sh

./gradlew test

```



## Usage



### Reading an Excel File



The `ExcelReader` class provides functionality to read an Excel file. By default, it reads the file located at `/Users/xafixav/Downloads/datafrscrap/Igreja.xlsx`.



### Generating Keys



The `KeysGenerator` class provides methods to generate RSA and AES keys.



### Encrypting Data



The `KeysEncryptor` class can be used to encrypt data using the generated keys.



## License



This project is licensed under the Apache License 2.0. See the `LICENSE` file for details.
