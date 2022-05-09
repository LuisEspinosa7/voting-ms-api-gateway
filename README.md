# Voting app microservice - API GATEWAY (BACKEND)

Voting app is a web app for voting, there are some configurable candidates, subscribed and enabled people can select between them by 
presenting a unique code which should've been provided in the subscription process (Subscription process NOT covered in this development).
A person could only vote once. Whenever a vote is valid, it is saved on MongoDB and then put on Kafka, the info microservice which should
be listening to the topic, should get it and save it in POSTGRESQL (Sync). On the other hand, the results can be obtained using the 
results microservice. This WEB APP's backend was developed by Luis Espinosa Llanos using a microservice approach and it was used 
the following technologies and tools: 

<table style="width:100%">
  <tr>
    <td>
  	Core	
    </td>
    <td>
  	Java 11, Spring Boot 2, Data JPA, Hibernate, Loombok, Jackson Databinding.
    </td>
  </tr>
  <tr>
    <td>
  	Databases
    </td>
    <td>
  	PostgreSQL 11, MongoDB.
    </td>
  </tr>
  <tr>
    <td>
  	Cache
    </td>
    <td>
  	Redis
    </td>
  </tr>
  <tr>
    <td>
  	Service discovery	
    </td>
    <td>
  	Consul
    </td>
  </tr>
  <tr>
    <td>
  	Queues
    </td>
    <td>
  	Apache Kafka
    </td>
  </tr>
  <tr>
    <td>
  	Virtualization
    </td>
    <td>
  	Docker
    </td>
  </tr>
  <tr>
    <td>
  	Web Server
    </td>
    <td>
  	Nginx
    </td>
  </tr>
  <tr>
    <td>
  	Distributed Tracing
    </td>
    <td>
  	Zipkin
    </td>
  </tr>
  <tr>
    <td>
  	Api Gateway
    </td>
    <td>
  	Spring Cloud Api Gateway
    </td>
  </tr>
  <tr>
    <td>
  	Server	
    </td>
    <td>
  	Apache Tomcat Embebido (Spring Boot)
    </td>
  </tr>
  <tr>
    <td>
  	IDE	
    </td>
    <td>
  	Spring Tool Suite
    </td>
  </tr>
  <tr>
    <td>
  	Executable	
    </td>
    <td>
  	Jar
    </td>
  </tr>
</table>

It was written using the best practices for instance, a controller, service and repository layer approach, code reusing, 
dependecy injection, inversion of control, abstractions, design patterns and more... 

## Where is the FrontEnd?
This project still has no FrontEnd.... But It will soon, of course developed in reactJS.

## Video
A video exposing the functionality of the proyect in local environment on a Desktop screen.

1. https://youtu.be/Mc5IMID86yE
2. https://youtu.be/Yf-jjmybYTg
3. https://youtu.be/NcJqeNIPpDw
4. https://youtu.be/2JH3GydLfKQ

## Development Resources
I provide the following resources:

<table style="width:100%">
  <tr>
    <td>
  	Database SQL Backup	
    </td>
    <td>
	In the db folder
    </td>
  </tr>
  <tr>
    <td>
  	Postman Collection	
    </td>
    <td>
	In the postman folder
    </td>
  </tr>
  <tr>
    <td>
  	Architenture
    </td>
    <td>
	In the architenture folder
    </td>
  </tr>
</table>


## Pictures
Some pictures of the project on a local environment respectively:

<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167336671-402551f1-1907-4c88-ada4-927288213f58.PNG">
	  </td>
    <td>
  	<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167336691-b03a5a61-1b1f-4c07-9fc4-23f528753682.PNG">
    </td>
  </tr>
</table>




<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167336730-9ad38708-970f-41f2-9900-21f66e06448a.png">
	  </td>
    <td>
	<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337632-4a11cfc0-fcb9-4acd-abba-0cf696e17d02.PNG">
    </td>
  </tr>
</table>


<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337659-591737c4-3607-48e1-99a2-ff5ddb544bab.PNG">
	  </td>
    <td>
	<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337699-234ed4af-9b0c-4166-a2d8-846c0eb71d33.PNG">
    </td>
  </tr>
</table>


<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337750-c8b26cfa-1ee0-4f60-8253-00effbb782c3.PNG">
	  </td>
    <td>
	<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337777-3c7f9fc8-775d-45e3-b1bd-abdce8bd37f1.PNG">
    </td>
  </tr>
</table>


<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337816-579d9b60-b4fd-48fd-a678-491b4d69225e.PNG">
	  </td>
    <td>
	<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337849-330597ae-f8a5-482a-aecb-c57a36b5edc4.PNG">
    </td>
  </tr>
</table>


<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Image" src="https://user-images.githubusercontent.com/56041525/167337879-45c74245-c995-48be-b960-01c84add512d.PNG">
	  </td>
</table>


## Installation

This proyect should be installed using the following command:
```bash
mvn clean install -DskipTests
```

## Usage
The recommendation by now is to import it in your favority IDE. And run the project the way I did.


## Contributing
This proyect is quite simple, and is part of my personal portfolio, so it is not intended to receive contributions.


## License
It is free.

