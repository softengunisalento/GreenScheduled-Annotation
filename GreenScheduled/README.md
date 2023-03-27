# Read Me First
## @GreenScheduled
Questa documentazione è volta allo sviluppo di un'Annotation in framework Springboot, la quale permette di schedulare i propri task, in base alle emissioni di anidride carbonica in una determinata zona.



# Getting Started
## Descrizione
Una volta scaricato il contenuto di questo Repository, si potrà annotare il metodo da schedulare con la custom annotation "@GreenScheduled". Il metodo annotato lavorerà solo in condizioni di Live Carbon Intensity favorevoli, e tali condizioni saranno scelte dallo sviluppatore.
All'annotazione in questione dovranno essere passati i seguenti parametri:
* Zona di interesse.
* Key, Value e v3 reperibili tramte il sito electricitymaps.com
* Valore massimo di Live Carbon Intensity
* Delay, ossia quanto dovrà aspettare il software prima di effettuare un altro controllo se le condizioni di Live Carbon Intensity non sono favorevoli.
## Energy Data Provider
Il sito web scelto per prelevare i dati relativi a Live Carbon Intensity è Electricity Maps. Iscrivendosi sul sito è possibile abbonarsi GRATUITAMENTE a uno dei piani messi a disposizione, il quale ha la durata di 1 mese e permette di
accedere a un endpoint in particolare, il quale permette di reperire le informazioni cercate. Una volta effettuato l'abbonamento, sul sito, saranno messi a disposizione 3 valori che dovranno essere passati
nell'annotation, come scritto in precedenza.
Dal [Catalogo abbonamenti Electricity Maps](https://api-portal.electricitymaps.com) scegliere "Free Trial" per avere accesso al piano appena descritto.
## Come funziona?
Utilizzare tale annotation è molto semplice:
* Scegliere quale metodo dovrà essere svolto solo in condizioni particolari di emissioni di C02.
* Annotare il metodo.
* Impostare i parametri in base alle proprie credenziali e alle proprie preferenze.

Finchè i valori di emissioni di C02, nella zona scelta, non saranno al di sotto di "maxCarbonIntensity" il metodo non verrà svolto e ogni tot millisecondi scelti in "delay" verrà effettuato un nuovo controllo.
## Reference Documentation
Per maggiori approfondimenti, consultare la seguente documentazione:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/#web)
* [Electricity Maps API Documentation](https://static.electricitymaps.com/api/docs/index.html)
* [Creating a Custom Annotation in SpringBoot](https://www.baeldung.com/java-custom-annotation)


