## Servlet Api 3.1, Spring Framework 4, Logback

### Spring Data Jpa, Hibernate 4 and CXF
In Memory H2 Database for Test and development
Run the Application with mvn jetty:run

### Rest Service
WADL URL http://localhost:8080/bpms-web/service/rs/welcome?_wadl

GET http://localhost:8080/bpms-web/service/rs/welcome.json
GET http://localhost:8080/bpms-web/service/rs/welcome.xml

### SOAP Service
WSDL URL http://localhost:8080/bpms-web/service/ws/welcome?wsdl

POST http://localhost:8080/bpms-web/service/ws/welcome?wsdl
	HEADERS 
	ContentType text/xml
	BODY ROW 
	<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:hs="http://ws.service.bpms.trenet.org/">
		<soap:Body>
			<hs:welcome></hs:welcome>
		</soap:Body>
	</soap:Envelope>