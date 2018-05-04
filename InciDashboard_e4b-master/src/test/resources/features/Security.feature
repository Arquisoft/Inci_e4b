# language: en
Feature: Test security 

Scenario Outline: Security 
	Given A user with username "<username>" and password "<password>"
	When the user go to "<url>" 
	Then the user see the following text "<text>" 
	
	Examples: 
		|username|password|url|text|
		|NoExist|NoExist|http://localhost:8090/incidencias/list|Identifícate|
		|111111Z|123456|http://localhost:8090/incidencias/list|Incidencias:|
		|NoExist|NoExist|http://localhost:8090/notificaciones/list|Identifícate|
		|111111Z|123456|http://localhost:8090/notificaciones/list|Notificaciones:|
		|NoExist|NoExist|http://localhost:8090/filtro/list|Identifícate|
		|111111Z|123456|http://localhost:8090/filtro/list|Filtros:|
		|NoExist|NoExist|http://localhost:8090/filtro/add|Identifícate|
		|111111Z|123456|http://localhost:8090/filtro/add|Agregar filtro|