## Car Employment Test

This project was made for an interview process.
Given the following problem: 

```text Una fábrica de automóviles produce uno de sus modelos en tres variantes, llamadas sedán, coupé y familiar. Cada una tiene un precio de venta básico sin opcionales. A su vez, a cada variante se le pueden agregar opciones como techo corredizo, aire acondicionado, sistema de frenos ABS, airbag y llantas de aleación. Cada uno de estos opcionales tiene un precio que suma al básico. En este caso, cada auto vendrá caracterizado por su variante y podrá tener ninguno, uno o más opcionales.
Asumiendo los siguientes costos:
•          Básico sedán          230.000
•          Básico familiar        245.000
•          Básico coupé          270.000
•          Techo corredizo (TC)        12.000
•          Aire acondicionado (AA)  20.000
•          Sistemas de frenos ABS (ABS)    14.000
•          Airbag (AB)   7.000
•          Llantas de aleación (LL)   12.000
1)Diseñar una solución que permita calcular el costo final de un automóvil.
2)Desarrollar una API Rest CRUD que me permita crear, modificar, listar y eliminar objetos del tipo “Automóvil”.
Ej:
{
“id”: 1,
“nombre”: “Sedán”,
“opcionales”: [“TC”, “AA”, “LL”]
}
Las operaciones de alta/consulta deberán almacenar/mostrar el costo del mismo.
```

The solution was made by using:

- Maven
- Spring boot 2
- JPA
- Hibernate
- PostgreSQL
- Docker & Docker compose
- Bash


You can run the project just by using ` ./mvnw clean install ` & ` ./mvnw spring-boot:run `, but it is ready to be used on a docker-based architecture

Once the project is up and running you can go to the path ` /swagger-ui.html ` in order to see and use all the available enpoints