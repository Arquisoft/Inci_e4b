

# Agents_e4b

[![Build Status](https://travis-ci.org/Arquisoft/Agents_e4b.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e4b)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e680327c40a44a6b8378a8171066e341)](https://www.codacy.com/app/jelabra/Agents_e4b?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/Agents_e4b&utm_campaign=badger)
[![codecov](https://codecov.io/gh/Arquisoft/Agents_e4b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e4b)

# Autores originales

- David Lorenzo González (UO244795)
- Martín Peláez Díaz (UO236974)
- Laura Menéndez Pérez (UO244646)
- Fernando Palazuelo Ginzo (UO244588)

# Autores de la modificación
- Sergio Muñiz Rosas (UO245346)
- Darío Alonso Díaz (UO237089)
- Francisco Manuel Mendoza Soto (UO251129)
- Victor David Acebes Caballo (UO251117)

# Descripción

Agents es una aplicación elaborada para la asignatura Arquitectura del Software de la Escuela de Ingeniería informática de la Universidad de Oviedo.
<br><br>
La función de Agents es la de permitir el manejo de información de diversos agentes almacenados en el sistema. Por ahora, el sistema maneja agentes de tres tipos distintos: Usuarios, entidades, y sensores.<br>
Agents busca ofrecer a sus usuarios una forma simple y sencilla para acceder a sus datos registrados, así como para cambiarlos siempre que lo deseen. Para esto proporciona una minimalista interfaz de usuario.
<br><br>
Si desea probar Agents, siga leyendo para obtener las instrucciones de compilación y ejecución.

# Cómo ejecutar
Para ejecutar la aplicación hace falta tener maven correctamente instalado, se puede instalar siguiendo estas instrucciones en caso de no tenerlo: https://www.mkyong.com/maven/how-to-install-maven-in-windows/ <br> 
Una vez instalado, ejecutar en el cmd el comando "mvn --version" para comprobar que la instalación ha sido correcta.
<br><br>
Tras comprobarlo, aseguraros de clonar el proyecto en vuestro ordenador, y situaros en el cmd en esa en la raiz del proyecto, es decir donde se pueden ver las carpetas src, cartas, bin... una vez situados, ejecutad el comando "mvn spring-boot:run". Esto pondrá en ejecución el programa.<br>
Otra posibilidad es realizar la ejecución mediante un entorno de desarrollo como Eclipse, importando el proyecto maven, en vez de usar la venta de comandos.
<br><br>
Una vez tengáis en ejecución la aplicación, deberéis acceder a la dirección http://localhost:8080/ con vuestro navegador preferido y observaréis la pantalla de login. Para poder acceder a los datos de un usuario, podéis ver algunos de los usuarios de prueba más abajo. En este caso, el usuario siempre es el DNI. Por ejemplo, para ver los datos de Paco Gómez, introducid el usuario 12345678B, la contraseña 123456 y el tipo Person.

# Usuarios de prueba para la aplicación

Se accede mediante el DNI:

- Email: juan@example.com <br>
  Contraseña: UDDFJEMVG310 <br>
  Nombre: Juan Torres Pardo <br>
  DNI: 87654321P <br>
  Kind: Person  <br>

- Email: luis@example.com <br>
  Contraseña: OIOGQFCYR680 <br>
  Nombre: Luis López Fernando <br>
  DNI: 19160962F <br>
  Kind: Person  <br>

- Email: ana@example.com <br>
  Contraseña: YUQUVKGJA230 <br>
  Nombre: Ana Torres Pardo <br>
  DNI: 09940449X <br>
  Kind: Person  <br>


