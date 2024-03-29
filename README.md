# Menopausal Status Extraction System

If using the system, please cite:

Hannah Eyre, Patrick R Alba, Carolyn J Gibson, Elise Gatsby, Kristine E Lynch, Olga V Patterson, Scott L DuVall. Bridging information gaps in menopause status classification through natural language processing. JAMIA Open. 2024.

```
@article{10.1093/jamiaopen/ooae013,
    author = {Eyre, Hannah and Alba, Patrick R and Gibson, Carolyn J and Gatsby, Elise and Lynch, Kristine E and Patterson, Olga V and DuVall, Scott L},
    title = "{Bridging information gaps in menopause status classification through natural language processing}",
    journal = {JAMIA Open},
    year = {2024},
    month = {02},
    issn = {2574-2531},
    doi = {10.1093/jamiaopen/ooae013},
    url = {https://doi.org/10.1093/jamiaopen/ooae013},
}
````

The system is based on Leo architecture extending UIMA AS.  For more info on Leo see [ http://department-of-veterans-affairs.github.io/Leo/userguide.html ]
To use the system:
  1. Follow the instructions to install and configure UIMA AS Steps 2.1-2.9 on page [ http://department-of-veterans-affairs.github.io/Leo/userguide.html#/a2_Installation_and_Configuration_of_Leo-Example ] .
  2. Start UIMA AS Broker.

Open the code in IDE of your preference. We recommend using IntelliJ Community version [ https://www.jetbrains.com/idea/download ]

To run Service, right click on src/main/java/gov/va/vinci/menopause/Service and select Run Service.main()

To run Client to read from files and write to xmi, right click on src/main/java/gov/va/vinci/menopause/Client and select Run Client.main()

To run Service to read from other sources and write to a different output, readers and listeners have to be configured and then specified as Program arguments.
If reading from a database, you might need to add Djava.library.path VM configuration

Client VM options:

    -Djava.library.path="lib;"
    -Dlog4j.configuration='config/log4j.properties'

Client Program arguments:

    -clientConfigFile=config/ClientConfig.groovy

    -readerConfigFile=config/readers/FileCollectionReaderConfig.groovy
    -readerConfigFile=config/readers/DatabaseCollectionReaderConfig.groovy
    -readerConfigFile=config/readers/SQLServerPagedDatabaseCollectionReaderConfig.groovy
    -readerConfigFile=config/readers/BatchDatabaseCollectionReaderConfig.groovy

    -listenerConfigFile=config/listeners/SimpleXmiListenerConfig.groovy
    -listenerConfigFile=config/listeners/SimpleCsvListenerConfig.groovy
    -listenerConfigFile=config/listeners/DatabaseListenerConfig.groovy
    -listenerConfigFile=config/listeners/KnowtatorListenerConfig.groovy
    -listenerConfigFile=config/listeners/AuCompareSummaryListenerConfig.groovy
    -listenerConfigFile=config/listeners/AuCompareCsvListenerConfig.groovy
