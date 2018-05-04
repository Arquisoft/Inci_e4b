[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e9d0acdac1f4427698134e010ffbd3fe)](https://www.codacy.com/app/AlexGPlay/InciDashboard_e4b?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciDashboard_e4b&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_e4b)
[![codecov](https://codecov.io/gh/Arquisoft/Inci_e4b/InciDashboard_e4b-master/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Inci_e4b/InciDashboard_e4b-master)


# InciDashboard_e4b

[![Join the chat at https://gitter.im/Arquisoft/participants0](https://badges.gitter.im/Arquisoft/participants0.svg)](https://gitter.im/Arquisoft/participants0?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


# Descripción
Este módulo se encarga de recibir y gestionar las incidencias enviadas por el módulo InciManager a través de Apache Kafka.

# Cómo ejecutar

Para poder ejecutar la aplicación es necesario tener instalado Apache Maven, Apache Kafka y una base de datos local HSQLDB.

1. Arrancar la base de datos. Situandose en la carpeta bin de la base de datos hay que ejecutar lo siguiente:
    * Para Windows:
         ```
          runServer.bat
         ```
    * Para MacOS/Linux:
         ```
          sh runServer.sh
         ```

2. Arrancar servidor zookeeper. Situandose en la carpeta bin de Apache Kafka ejecutar lo siguiente:
    * Para Windows:
         ```
          bin\windows\zookeeper-server-start.bat config\zookeeper.properties
         ```
    * Para MacOs/Linux:
         ```
          bin/zookeeper-server-start.sh config/zookeeper.properties
         ```

3. Arrancar Apache Kafka. Situandose en la carpeta bin de Apache Kafka ejecutar lo siguiente:
    * Para Windows:
         ```
          bin\windows\kafka-server-start.bat config\server.properties
         ```
    * Para MacOs/Linux:
         ```
          bin/kafka-server-start.sh config/server.properties
         ``` 

4. En la carpeta del proyecto ejecutar lo siguiente (independiente del SO):
         ```
          mvn spring-boot:run
         ``` 

5. Desde el navegador:
        ``` 
         http://localhost:8090
        ```
# Usuarios de prueba
DNI: 111111Z
<br>Contraseña: 123456

DNI: 000000Z
<br>Contraseña: 123456

# Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)

# Modificadores

- Alejandro García Parrondo
- Óscar Marín Iglesias
- Samuel Steven Ludeña Vela
- Ángela Val Cadena
- Juan Granda Molaguero
