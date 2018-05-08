# Inci_e4b
Incidence system e4b

# Subsistemas

## Loader
[![Build Status](https://travis-ci.org/Arquisoft/Loader_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/Loader_e4b)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/aeca0021c27447d1abfaec98ceed9508)](https://www.codacy.com/app/jelabra/Loader_e4b?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Loader_e4b&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/Arquisoft/Loader_e4b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Loader_e4b)

## Agents
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e4b)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e680327c40a44a6b8378a8171066e341)](https://www.codacy.com/app/jelabra/Agents_e4b?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/Agents_e4b&utm_campaign=badger)
[![codecov](https://codecov.io/gh/Arquisoft/Agents_e4b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e4b)

## InciManager
[![Build Status](https://travis-ci.org/Arquisoft/InciManager_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/InciManager_e4b)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e680327c40a44a6b8378a8171066e341)](https://www.codacy.com/app/jelabra/InciManager_e4b?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/InciManager_e4b&utm_campaign=badger)
[![codecov](https://codecov.io/gh/Arquisoft/InciManager_e4b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciManager_e4b)

## InciDashboard
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_e4b)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e9d0acdac1f4427698134e010ffbd3fe)](https://www.codacy.com/app/AlexGPlay/InciDashboard_e4b?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciDashboard_e4b&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/Arquisoft/InciDashboard_e4b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciDashboard_e4b)

# Descripción

## Ejecución

1. Base de Datos MySql, no requiere despliegue. <br>
2. Arranque Apache Zookeeper: bin\windows\zookeeper-server-start.bat config\zookeeper.properties <br>
3. Arranque Apache Kafka: bin\windows\kafka-server-start.bat config\server.properties <br>
4. Para el despliegue del sitio Web: Agents, InciManager e InciDashboard: mvn spring-boot:run <br>
5. Carga de datos con Loader: mvn exec:java -Dexec.mainClass="main.LoadUsers" -Dexec.args="load fichero.xlsx" <br>
6. Abrir en el navegador:
  - http://localhost:8070/ para el Agents. <br>
  - http://localhost:8080/ para el InciManager. <br>
  - http://localhost:8090/ para el InciDashboard. <br>
<br>
Ejecución detallada paso a paso dentro del "README.md" de cada subsistema.

# Autores
- Sergio Muñiz Rosas (UO245346)<br>
- Darío Alonso Díaz (UO237089)<br>
- Francisco Manuel Mendoza Soto (UO251129)<br>
- Victor David Acebes Caballo (UO251117)<br>
- Óscar Marín Iglesias (UO251857)<br>
- Ángela María Val Cadena (UO250972)<br>
- Alejandro García Parrondo (UO253144)<br>
- Samuel Steven Ludeña Vela (UO251461)<br>
- Juan Granda Molaguero (UO244759)<br>
